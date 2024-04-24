package Model.User;

import Model.DataBase.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe implémente l'interface UserDao pour fournir des méthodes CRUD (Create, Read, Update, Delete) pour les utilisateurs.
 */
public class UserDaoImpl implements UserDao {
    // Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     *
     * @param user L'utilisateur à ajouter
     */
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Read

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à récupérer
     * @return L'utilisateur correspondant à l'identifiant spécifié
     */
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
                user = new User(rs.getInt("user_id"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    /**
     * Récupère un utilisateur par son pseudo.
     *
     * @param pseudo Le pseudo de l'utilisateur à récupérer
     * @return L'utilisateur correspondant au pseudo spécifié
     */
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
                user = new User(rs.getInt("user_id"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    /**
     * Récupère un utilisateur par son adresse e-mail.
     *
     * @param mail L'adresse e-mail de l'utilisateur à récupérer
     * @return L'utilisateur correspondant à l'adresse e-mail spécifiée
     */
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
                user = new User(rs.getInt("user_id"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    // Update

    /**
     * Met à jour les informations d'un utilisateur dans la base de données.
     *
     * @param user L'utilisateur à mettre à jour
     */
    public void updateUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "UPDATE user SET user_firstname = ?, user_lastname = ?, user_mail = ?, user_pseudo = ?, user_password = ?, user_role = ?, user_birthday = ?, user_type = ? WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUser_firstname());
            ps.setString(2, user.getUser_lastname());
            ps.setString(3, user.getUser_mail());
            ps.setString(4, user.getUser_pseudo());
            ps.setString(5, user.getUser_password());
            ps.setBoolean(6, user.getUser_role());
            ps.setDate(7, user.getUser_birthday());
            ps.setInt(8, user.getUser_type());
            ps.setInt(9, user.getUser_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Delete

    /**
     * Supprime un utilisateur de la base de données par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à supprimer
     */
    public void deleteUserById(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM user WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Supprime un utilisateur de la base de données par son pseudo.
     *
     * @param pseudo Le pseudo de l'utilisateur à supprimer
     */
    public void deleteUserByPseudo(String pseudo) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM user WHERE user_pseudo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pseudo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthodes vérifiant si un pseudo ou un mail est déjà utilisé

    /**
     * Vérifie si un pseudo est déjà utilisé dans la base de données.
     *
     * @param pseudo Le pseudo à vérifier
     * @return true si le pseudo est déjà utilisé, sinon false
     */
    public boolean DoesPseudoExist(String pseudo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isUsed = false;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT COUNT(*) FROM user WHERE user_pseudo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pseudo);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    isUsed = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUsed;
    }

    /**
     * Vérifie si une adresse e-mail est déjà utilisée dans la base de données.
     *
     * @param mail L'adresse e-mail à vérifier
     * @return true si l'adresse e-mail est déjà utilisée, sinon false
     */
    public boolean DoesMailExist(String mail) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isUsed = false;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT COUNT(*) FROM user WHERE user_mail = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    isUsed = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUsed;
    }

    /**
     * Vérifie si un mot de passe correspond à une adresse e-mail dans la base de données.
     *
     * @param mail     L'adresse e-mail de l'utilisateur
     * @param password Le mot de passe à vérifier
     * @return true si le mot de passe correspond à l'adresse e-mail, sinon false
     */
    public Boolean DoesPasswordExist(String mail, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Boolean isUsed = false;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT COUNT(*) FROM user WHERE user_mail = ? AND user_password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, mail);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) > 0) {
                    isUsed = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isUsed;
    }

    /**
     * Récupère tous les utilisateurs de la base de données.
     *
     * @return Une liste de tous les utilisateurs
     */
    public List<User> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM user";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("user_id"), rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getString("user_mail"), rs.getString("user_pseudo"), rs.getString("user_password"), rs.getBoolean("user_role"), rs.getDate("user_birthday"), rs.getInt("user_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return users;
    }
}
