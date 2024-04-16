package Model.Seance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Film.*;
import Model.Salle.Salle;

public class SeanceDaoImpl {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)
    private Connection getConnection () throws SQLException {
        //Connexion à la base de données
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/Cinema", "root", "password");

    }
    // Create
    public void addSeance(Seance seance) {
        String sql = "INSERT INTO Seance (seance_date, seance_time, seance_language, seance_nb_reservation, film_id, salle_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
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
        try (Connection connection = getConnection();
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
        try (Connection conn = getConnection();
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
        try (Connection conn = getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, seance.getSeance_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
