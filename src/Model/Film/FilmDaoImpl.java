package Model.Film;
import java.sql.*;

public class FilmDaoImpl implements FilmDao {
    private Connection getConnection () throws SQLException {
        //Connexion à la base de données
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/Cinema", "root", "password");

    }
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    @Override
    public void addFilm(Film film) {
        String sql = "INSERT INTO film (film_title, film_director, film_genre, film_synopsis, film_duration, film_release_date, film_status, film_poster) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
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
        try (Connection connection = getConnection();
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

        try (Connection connection = getConnection();
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

    // Update
    @Override
    public void updateFilm(Film film) {
        String query = "UPDATE film SET film_title = ?, film_director = ?, film_genre = ?, film_duration = ?, film_synopsis = ?, film_release_date = ?, film_status = ?, film_poster = ? WHERE film_id = ?";

        //Mettre à jour un film
        try (Connection connection = getConnection();
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
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, film.getFilm_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
