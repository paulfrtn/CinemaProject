package Model.User;

import Model.DataBase.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "INSERT INTO user (user_firstname, user_lastname, user_mail, user_pseudo, user_password, user_role, user_birthday, user_type) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUser_firstname());
            ps.setString(2, user.getUser_lastname());
            ps.setString(3, user.getUser_mail());
            ps.setString(4, user.getUser_pseudo());
            ps.setString(5, user.getUser_password());
            ps.setBoolean(6, user.getUser_role());
            ps.setDate(7, user.getUser_birthday());
            ps.setInt(8, user.getUser_type());
            ps.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    // Read
    public User getUserById(int id) {
        // TODO
        return null;
    }

    public User getUserByPseudo(String pseudo) {
        // TODO
        return null;
    }

    public User getUserByMail(String mail) {
        // TODO
        return null;
    }

    // Update
    public void updateUser(User user) {
        // TODO
    }

    // Delete
    public void deleteUser(User user) {
        // TODO
    }

    public void deleteAdmin(User user) {
        // TODO
    }
}
