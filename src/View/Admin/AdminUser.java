package View.Admin;

import Controller.AddAdmin.AddAdminController;
import Controller.AddFilm.ControllerAddFilm;
import Controller.SuppUser.SuppUserController;
import Model.Film.Film;
import Model.Seance.Seance;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.AddAdmin;
import View.AddFilm;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;
import View.BorderRadCompenent.BorderRadPanel;
import View.SuppUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Vue pour la gestion des utilisateurs par l'administrateur.
 */
public class AdminUser extends JPanel {
    String couleur1;
    String couleur2;
    String couleur3;
    private JPanel mainPanel;
    private JButton btnBack;
    private JButton btnFilms;
    private JButton btnOffers;
    private JButton btnLogOut;
    private JButton btnAddUser;
    private JButton btnDeleteUser;
    private JPanel FilmsPanel;

    /**
     * Constructeur de la classe AdminUser.
     *
     * @param users La liste des utilisateurs
     */
    public AdminUser(List<User> users) {
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";

        setLayout(new BorderLayout());
        setBackground(Color.decode(couleur1));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel row1 = new JPanel(new BorderLayout());
        row1.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.01;
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.BOTH;

        ImageIcon logoIcon = new ImageIcon("src/Model/Images/logo.jpg");
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logo = new BorderRadLabel(scaledLogoIcon, 10);
        row1.add(logo, BorderLayout.WEST);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        btnBack = new BorderRadButton("Retour", 10);
        btnBack.setBackground(Color.decode(couleur2));
        btnFilms = new BorderRadButton("Films", 10);
        btnFilms.setBackground(Color.decode(couleur2));
        btnLogOut = new BorderRadButton("Déconnexion", 10);
        btnLogOut.setBackground(Color.decode(couleur2));

        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnBack);
        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnFilms);
        buttonsPanel.add(Box.createHorizontalGlue());
        buttonsPanel.add(btnLogOut);
        row1.add(buttonsPanel, BorderLayout.CENTER);

        mainPanel.add(row1, gbc);

        JPanel row2 = new JPanel(new BorderLayout());
        row2.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.90;
        gbc.fill = GridBagConstraints.BOTH;

        row2.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.setOpaque(false);
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.1;
        gbc2.insets = new Insets(7, 7, 7, 7);
        gbc2.fill = GridBagConstraints.NONE;
        gbc2.anchor = GridBagConstraints.CENTER;

        btnAddUser = new BorderRadButton("Ajouter un utilisateur admin", 10);
        btnAddUser.setBackground(Color.decode(couleur2));
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAdmin addAdmin = new AddAdmin();
                AddAdminController addAdminController = new AddAdminController();
                addAdminController.start();
            }
        });
        btnDeleteUser = new BorderRadButton("Supprimer un utilisateur", 10);
        btnDeleteUser.setBackground(Color.decode(couleur2));
        btnDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuppUser suppUser = new SuppUser();
                SuppUserController suppUserController = new SuppUserController();
                suppUserController.start();
            }
        });

        ButtonPanel.add(btnAddUser);
        ButtonPanel.add(btnDeleteUser);

        row2.add(ButtonPanel, gbc2);

        JScrollPane FilmsScrollPane = new JScrollPane();
        FilmsScrollPane.setOpaque(false);
        FilmsScrollPane.getViewport().setOpaque(false);
        FilmsScrollPane.setBorder(BorderFactory.createEmptyBorder());
        FilmsScrollPane.setHorizontalScrollBar(null);
        FilmsScrollPane.setVerticalScrollBar(new JScrollBar());
        FilmsPanel = new JPanel();
        FilmsPanel.setOpaque(false);
        FilmsPanel.setLayout(new BoxLayout(FilmsPanel, BoxLayout.Y_AXIS));
        FilmsScrollPane.setViewportView(FilmsPanel);

        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.9;
        gbc2.insets = new Insets(7, 7, 7, 15);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.anchor = GridBagConstraints.NORTH;

        for (User user : users) {
            if (!user.getUser_role()) {
                JPanel userPanel = new BorderRadPanel(10);
                JLabel userLabel = new JLabel("Prénom: " + user.getUser_firstname() + "Nom: " + user.getUser_lastname() + " Email: " + user.getUser_mail());
                userPanel.add(userLabel);
                userPanel.setBackground(Color.decode(couleur3));
                FilmsPanel.add(userPanel);
            }
        }


        row2.add(FilmsScrollPane, gbc2);

        mainPanel.add(row2, gbc);

        add(mainPanel);
    }

    /**
     * Met à jour la liste des utilisateurs affichée.
     *
     * @param users La nouvelle liste d'utilisateurs
     */
    public void updateUsers(List<User> users) {
        FilmsPanel.removeAll();
        for (User user : users) {
            if (!user.getUser_role()) {
                JPanel userPanel = new BorderRadPanel(10);
                JLabel userLabel = new JLabel("Prénom: " + user.getUser_firstname() + "Nom: " + user.getUser_lastname() + " Email: " + user.getUser_mail());
                userPanel.add(userLabel);
                userPanel.setBackground(Color.decode(couleur3));
                FilmsPanel.add(userPanel);
            }
        }
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnFilms() {
        return btnFilms;
    }


    public JButton getBtnLogOut() {
        return btnLogOut;
    }

}
