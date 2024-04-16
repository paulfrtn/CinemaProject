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
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM user WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"),rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return user;
    }

    public User getUserByPseudo(String pseudo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM user WHERE user_pseudo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pseudo);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"),rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return user;
    }

    public User getUserByMail(String mail) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM user WHERE user_mail = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"),rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return user;
    }

    // Update
    public void updateUser(User user) {

    }

    // Delete
    public void deleteUser(User user) {
        // TODO
    }
}
