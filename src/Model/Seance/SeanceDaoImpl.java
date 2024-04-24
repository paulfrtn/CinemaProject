package Model.Seance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import Model.DataBase.ConnectionDb;
import Model.Film.Film;
import Model.Salle.Salle;

/**
 * La classe SeanceDaoImpl implémente l'interface SeanceDao et définit les méthodes pour manipuler les objets Seance en base de données.
 */
public class SeanceDaoImpl implements SeanceDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    /**
     * Ajoute une séance à la base de données.
     * @param seance La séance à ajouter.
     */
    public void addSeance(Seance seance) {
        String sql = "INSERT INTO Seance (seance_date, seance_time, seance_language, seance_nb_reservation, film_id, salle_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(seance.getSeance_date().getTime()));
            stmt.setTime(2, seance.getSeance_time());
            stmt.setString(3, seance.getSeance_language());
            stmt.setInt(4, seance.getSeance_nb_reservation());
            stmt.setInt(5, seance.getFilm_id()); // Utiliser le getter pour film_id
            stmt.setInt(6, seance.getSalle_id()); // Utiliser le getter pour salle_id
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    /**
     * Récupère une séance par son identifiant.
     * @param id L'identifiant de la séance à récupérer.
     * @return La séance correspondant à l'identifiant donné.
     */
    public Seance getSeanceById(int id) {
        String query = "SELECT * FROM Seance WHERE seance_id = ?";
        //Récupérer une séance par son id
        try (Connection connection = ConnectionDb.getConnection();
             java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Seance(
                        resultSet.getInt("seance_id"),
                        resultSet.getDate("seance_date"),
                        resultSet.getTime("seance_time"),
                        resultSet.getString("seance_language"),
                        resultSet.getInt("seance_nb_reservation"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("salle_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    // Update
    /**
     * Met à jour les informations d'une séance dans la base de données.
     * @param seance La séance à mettre à jour.
     */
    public void updateSeance(Seance seance) {
        String sql = "UPDATE Seance SET seance_date = ?, seance_time = ?, seance_language = ?, seance_nb_reservation = ? WHERE seance_id = ?";
        try (Connection conn = ConnectionDb.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(seance.getSeance_date().getTime()));
            stmt.setTime(2, seance.getSeance_time());
            stmt.setString(3, seance.getSeance_language());
            stmt.setInt(4, seance.getSeance_nb_reservation());
            stmt.setInt(5, seance.getSeance_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    /**
     * Supprime une séance de la base de données.
     * @param seance La séance à supprimer.
     */
    public void deleteSeance(Seance seance) {
        String sql = "DELETE FROM Seance WHERE seance_id = ?";
        try (Connection conn = ConnectionDb.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seance.getSeance_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère une liste de séances pour une date donnée et un identifiant de film donné.
     * @param date La date des séances à récupérer.
     * @param film_id L'identifiant du film des séances à récupérer.
     * @return La liste des séances correspondant à la date et à l'identifiant de film donnés.
     */
    public List<Seance> getSeanceByDateNFilmId(java.sql.Date date, int film_id) {
        String query = "SELECT * FROM Seance WHERE seance_date = ? AND film_id = ?";
        List<Seance> seances = new ArrayList<>();
        //Récupérer une séance par sa date
        try (Connection connection = ConnectionDb.getConnection();

             java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, film_id);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seances.add(new Seance(
                        resultSet.getInt("seance_id"),
                        resultSet.getDate("seance_date"),
                        resultSet.getTime("seance_time"),
                        resultSet.getString("seance_language"),
                        resultSet.getInt("seance_nb_reservation"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("salle_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    /**
     * Récupère une séance par son heure, son identifiant de film et sa date.
     * @param time L'heure de la séance à récupérer.
     * @param film_id L'identifiant du film de la séance à récupérer.
     * @param date La date de la séance à récupérer.
     * @return La séance correspondant à l'heure, l'identifiant de film et la date donnés.
     */
    public Seance getSeanceByTimeNFilmIdNDate(Time time, int film_id, Date date) {
        String query = "SELECT * FROM Seance WHERE seance_time = ? AND film_id = ? AND seance_date = ?";
        Seance seance = null;
        //Récupérer une séance par son heure
        try (Connection connection = ConnectionDb.getConnection();
             java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTime(1, time);
            preparedStatement.setInt(2, film_id);
            preparedStatement.setDate(3, date);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seance = new Seance(
                        resultSet.getInt("seance_id"),
                        resultSet.getDate("seance_date"),
                        resultSet.getTime("seance_time"),
                        resultSet.getString("seance_language"),
                        resultSet.getInt("seance_nb_reservation"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("salle_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }

    /**
     * Compte le nombre de séances selon certains critères.
     * @param filmId L'identifiant du film des séances à compter.
     * @param seanceDate La date des séances à compter.
     * @param seanceTime L'heure des séances à compter.
     * @param seanceLanguage Le langage des séances à compter.
     * @param salleId L'identifiant de la salle des séances à compter.
     * @return Le nombre de séances correspondant aux critères donnés.
     */
    public int getSeanceByCriteria(int filmId, Date seanceDate, Time seanceTime, String seanceLanguage, int salleId) {
        String query = "SELECT COUNT(*) FROM Seance WHERE film_id = ? AND seance_date = ? AND seance_time = ? AND seance_language = ? AND salle_id= ?";
        int count = 0;

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, filmId);
            preparedStatement.setDate(2, new java.sql.Date(seanceDate.getTime()));
            preparedStatement.setTime(3, seanceTime);
            preparedStatement.setString(4, seanceLanguage);
            preparedStatement.setInt(5, salleId);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count= resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Récupère toutes les séances de la base de données.
     * @return La liste de toutes les séances.
     */
    public List<Seance> getAllSeances() {
        String query = "SELECT * FROM Seance";
        List<Seance> seances = new ArrayList<>();
        //Récupérer toutes les séances
        try (Connection connection = ConnectionDb.getConnection();
             java.sql.Statement statement = connection.createStatement();
             java.sql.ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                seances.add(new Seance(
                        resultSet.getInt("seance_id"),
                        resultSet.getDate("seance_date"),
                        resultSet.getTime("seance_time"),
                        resultSet.getString("seance_language"),
                        resultSet.getInt("seance_nb_reservation"),
                        resultSet.getInt("film_id"),
                        resultSet.getInt("salle_id"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }
}
