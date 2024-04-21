package Model.Salle;

import Model.DataBase.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de l'interface SalleDao pour les opérations CRUD sur les salles.
 */
public class SalleDaoImpl implements SalleDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute une nouvelle salle à la base de données.
     *
     * @param salle La salle à ajouter.
     */
    public void addSalle(Salle salle) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "INSERT INTO salle (salle_number, salle_capa_max, salle_dispo) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, salle.getSalle_number());
            ps.setInt(2, salle.getSalle_capa_max());
            ps.setBoolean(3, salle.getSalle_dispo());
            ps.executeUpdate();
            System.out.println("Salle ajoutée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Read

    /*public Salle getSalleById(int id) {
        return null;
    }*/

    /**
     * Récupère une salle de la base de données en fonction de son numéro.
     *
     * @param number Le numéro de la salle à récupérer.
     * @return La salle correspondant au numéro spécifié, null si aucune salle trouvée.
     */
    public Salle getSalleByNumber(int number) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Salle salle = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM salle WHERE salle_number = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            if (rs.next()) {
                salle = new Salle(rs.getInt("salle_id"), rs.getInt("salle_number"), rs.getInt("salle_capa_max"), rs.getBoolean("salle_dispo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return salle;
    }

    // Update

    /**
     * Met à jour les informations d'une salle dans la base de données.
     *
     * @param salle La salle avec les nouvelles informations.
     */
    public void updateSalle(Salle salle) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "UPDATE salle SET salle_capa_max = ?, salle_dispo = ?, salle_number = ? WHERE salle_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, salle.getSalle_capa_max());
            ps.setBoolean(2, salle.getSalle_dispo());
            ps.setInt(3, salle.getSalle_number());
            ps.setInt(4, salle.getSalle_id());
            ps.executeUpdate();
            System.out.println("Salle modifiée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Delete

    /**
     * Supprime une salle de la base de données en fonction de son numéro.
     *
     * @param number Le numéro de la salle à supprimer.
     */
    public void deleteSalleByNumber(int number) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM salle WHERE salle_number = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, number);
            ps.executeUpdate();
            System.out.println("Salle supprimée avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
