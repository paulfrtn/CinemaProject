package Model.Film;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.DataBase.ConnectionDb;

public class FilmDaoImpl implements FilmDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    @Override
    public void addFilm(Film film) {

        String sql = "INSERT INTO film (film_title, film_director, film_genre, film_synopsis, film_duration, film_release_date, film_status, film_poster) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getFilm_title());
            stmt.setString(2, film.getFilm_director());
            stmt.setString(3, film.getFilm_genre());
            stmt.setString(4, film.getFilm_synopsis());
            stmt.setInt(5, film.getFilm_duration());
            stmt.setDate(6, new java.sql.Date(film.getFilm_release_date().getTime()));
            stmt.setBoolean(7, film.getFilm_status());
            stmt.setString(8, film.getFilm_poster()); // Ajouter le champ poster ici
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    @Override
    public Film getFilmById(int id) {
        String query = "SELECT * FROM film WHERE film_id = ?";

        //Récupérer un film par son id
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("film_title"),
                        resultSet.getString("film_director"),
                        resultSet.getString("film_genre"),
                        resultSet.getInt("film_duration"),
                        resultSet.getString("film_synopsis"),
                        resultSet.getDate("film_release_date"),
                        resultSet.getBoolean("film_status"),
                        resultSet.getString("film_poster"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Film getFilmByTitle(String title) {
        String query = "SELECT * FROM film WHERE film_title = ?";
        //Récupérer un film par son titre

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("film_title"),
                        resultSet.getString("film_director"),
                        resultSet.getString("film_genre"),
                        resultSet.getInt("film_duration"),
                        resultSet.getString("film_synopsis"),
                        resultSet.getDate("film_release_date"),
                        resultSet.getBoolean("film_status"),
                        resultSet.getString("film_poster"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean filmExists(String filmTitle) {
        String query = "SELECT COUNT(*) FROM film WHERE film_title = ?";
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, filmTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update
    @Override
    public void updateFilm(Film film) {
        String query = "UPDATE film SET film_title = ?, film_director = ?, film_genre = ?, film_duration = ?, film_synopsis = ?, film_release_date = ?, film_status = ?, film_poster = ? WHERE film_id = ?";

        //Mettre à jour un film
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, film.getFilm_title());
            preparedStatement.setString(2, film.getFilm_director());
            preparedStatement.setString(3, film.getFilm_genre());
            preparedStatement.setInt(4, film.getFilm_duration());
            preparedStatement.setString(5, film.getFilm_synopsis());
            preparedStatement.setDate(6, new java.sql.Date(film.getFilm_release_date().getTime()));
            preparedStatement.setBoolean(7, film.getFilm_status());
            preparedStatement.setString(8, film.getFilm_poster());
            preparedStatement.setInt(9, film.getFilm_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteFilm(Film film) {
        String query = "DELETE FROM film WHERE film_id = ?";
        //Supprimer un film
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, film.getFilm_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public List<Film> getNowShowingFilms(int limit) {
        String sql = "SELECT * FROM film WHERE film_release_date <= CURRENT_DATE LIMIT ?";
        return executeFilmQuery(sql, limit);
    }

    public List<Film> getPremieresFilms(int limit) {
        String sql = "SELECT * FROM film WHERE film_release_date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 1 WEEK) LIMIT ?";
        return executeFilmQuery(sql, limit);
    }

    public List<Film> getComingSoonFilms(int limit) {
        String sql = "SELECT * FROM film WHERE film_release_date > DATE_ADD(CURRENT_DATE, INTERVAL 1 WEEK) LIMIT ?";
        return executeFilmQuery(sql, limit);
    }

    private List<Film> executeFilmQuery(String sql, int limit) {
        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("film_title"),
                        resultSet.getString("film_director"),
                        resultSet.getString("film_genre"),
                        resultSet.getInt("film_duration"),
                        resultSet.getString("film_synopsis"),
                        resultSet.getDate("film_release_date"),
                        resultSet.getBoolean("film_status"),
                        resultSet.getString("film_poster")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this more robustly in production
        }
        return films;
    }

    public List<Film> Top3() {
        String sql = "SELECT f.*, COUNT(t.ticket_id) AS reservations_count " +
                "FROM film f " +
                "LEFT JOIN Seance s ON f.film_id = s.film_id " +
                "LEFT JOIN ticket t ON s.seance_id = t.seance_id " +
                "GROUP BY f.film_id " +
                "ORDER BY reservations_count DESC " +
                "LIMIT 3";

        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("film_title"),
                        resultSet.getString("film_director"),
                        resultSet.getString("film_genre"),
                        resultSet.getInt("film_duration"),
                        resultSet.getString("film_synopsis"),
                        resultSet.getDate("film_release_date"),
                        resultSet.getBoolean("film_status"),
                        resultSet.getString("film_poster")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer cela de manière plus robuste en production
        }
        return films;
    }
    public List<Film> Top3() {
        String sql = "SELECT f.*, COUNT(t.ticket_id) AS reservations_count " +
                "FROM film f " +
                "LEFT JOIN Seance s ON f.film_id = s.film_id " +
                "LEFT JOIN ticket t ON s.seance_id = t.seance_id " +
                "GROUP BY f.film_id " +
                "ORDER BY reservations_count DESC " +
                "LIMIT 3";

        List<Film> films2 = new ArrayList<>();
        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("film_id"),
                        resultSet.getString("film_title"),
                        resultSet.getString("film_director"),
                        resultSet.getString("film_genre"),
                        resultSet.getInt("film_duration"),
                        resultSet.getString("film_synopsis"),
                        resultSet.getDate("film_release_date"),
                        resultSet.getBoolean("film_status"),
                        resultSet.getString("film_poster")
                );
                films2.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer cela de manière plus robuste en production
        }
        return films2;
    }




}
