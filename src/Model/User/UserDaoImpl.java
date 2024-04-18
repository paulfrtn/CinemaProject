package Model.User;

import Model.DataBase.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.DataBase.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            System.out.println(user.getUser_mail());
            ps.setString(4, user.getUser_pseudo());
            ps.setString(5, user.getUser_password());
            ps.setBoolean(6, user.getUser_role());
            ps.setDate(7, user.getUser_birthday());
            ps.setInt(8, user.getUser_type());
            ps.setInt(9, user.getUser_id());
            ps.executeUpdate();
            System.out.println("Utilisateur modifié avec succès !");
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
    public void deleteUserById(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM user WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
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

    public void deleteUserByPseudo(String pseudo) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM user WHERE user_pseudo = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pseudo);
            ps.executeUpdate();
            System.out.println("Utilisateur supprimé avec succès !");
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

    //Méthodes verifiant si un pseudo est déjà utilisé ou un mail est déjà utilisé
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

    public Boolean DoesPasswordExist(String mail, String password){
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




        public static class AuthentificationPanel extends JPanel {
            private JTextField emailField;
            private JPasswordField passwordField;

            public AuthentificationPanel() {
                setBackground(Color.decode("#2a2d43"));
                setLayout(new BorderLayout());

                // Création du panneau central
                JPanel centralPanel = new JPanel();
                centralPanel.setPreferredSize(new Dimension(400, 600));
                centralPanel.setBackground(Color.decode("#7A82AB"));
                centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
                add(centralPanel, BorderLayout.CENTER);

                // Création du titre
                JLabel titleLabel = new JLabel("Connexion");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                centralPanel.add(titleLabel);

                // Ajout d'un espace
                centralPanel.add(Box.createRigidArea(new Dimension(0, 20)));

                // Création du formulaire
                JPanel formPanel = new JPanel();
                formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
                formPanel.setBackground(Color.decode("#2a2d43"));

                JLabel emailLabel = new JLabel("Email:");
                emailLabel.setForeground(Color.WHITE);
                emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                formPanel.add(emailLabel);

                emailField = new JTextField();
                emailField.setMaximumSize(new Dimension(200, 30));
                emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
                formPanel.add(emailField);

                JLabel passwordLabel = new JLabel("Mot de passe:");
                passwordLabel.setForeground(Color.WHITE);
                passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                formPanel.add(passwordLabel);

                passwordField = new JPasswordField();
                passwordField.setMaximumSize(new Dimension(200, 30));
                passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
                formPanel.add(passwordField);

                centralPanel.add(formPanel);

                // Ajout d'un espace
                centralPanel.add(Box.createRigidArea(new Dimension(0, 100)));

                // Bouton de connexion
                JButton loginButton = new JButton("Se connecter");
                loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        authenticateUser();
                    }
                });
                centralPanel.add(loginButton);
            }

            public void authenticateUser() {
                // Récupérer l'email et le mot de passe saisis par l'utilisateur
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                boolean isConnected = false; // Pour contrôler la boucle de connexion

                while (!isConnected) {
                    // Vérifier si l'email et le mot de passe ne sont pas vides
                    if (email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Veuillez fournir un email et un mot de passe.");
                        return; // Sortir de la méthode si l'email ou le mot de passe est vide
                    }

                    // Création d'une instance de UserDaoImpl pour vérifier si l'email existe
                    UserDaoImpl userDao = new UserDaoImpl();
                    User user = userDao.getUserByMail(email);

                    if (user == null) {
                        JOptionPane.showMessageDialog(this, "Aucun utilisateur trouvé avec cet email.");
                        return; // Sortir de la méthode si aucun utilisateur n'est trouvé
                    }

                    // Vérifier si le mot de passe est correct
                    if (password.equals(user.getUser_password())) {
                        JOptionPane.showMessageDialog(this, "Connexion réussie pour l'utilisateur : " + user.getUser_firstname());
                        isConnected = true; // Mettre à jour la condition pour arrêter la boucle
                    } else {
                        JOptionPane.showMessageDialog(this, "Mot de passe incorrect.");
                        return; // Sortir de la méthode si le mot de passe est incorrect
                    }
                }
            }

        }
    }














