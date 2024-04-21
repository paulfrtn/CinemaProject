package Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitaire pour établir une connexion à la base de données.
 */
public class ConnectionDb {

    private static final String url = "jdbc:mysql://localhost:3307/Cinema"; // URL de la base de données
    private static final String user = "root"; // Nom d'utilisateur de la base de données
    private static final String password = "password"; // Mot de passe de la base de données

    /**
     * Obtient une connexion à la base de données.
     *
     * @return la connexion à la base de données
     * @throws SQLException si une erreur survient lors de la connexion à la base de données
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password); // Retourne la connexion établie avec les informations d'URL, d'utilisateur et de mot de passe
    }
}
