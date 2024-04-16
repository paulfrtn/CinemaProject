package Model.Salle;
import Model.DataBase.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalleDaoImpl implements SalleDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
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

    public Salle getSalleByNumber(int number) {
        return null;
    }

    // Update

    public void updateSalle(Salle salle) {

    }

    // Delete

    public void deleteSalle(Salle salle) {

    }

}
