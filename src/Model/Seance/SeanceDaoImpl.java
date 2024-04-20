package Model.Seance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Model.Film.*;
import Model.Salle.Salle;
import Model.DataBase.ConnectionDb;


public class SeanceDaoImpl implements SeanceDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
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

}
