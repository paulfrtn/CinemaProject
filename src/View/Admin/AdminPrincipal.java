package View.Admin;

import Model.Seance.SeanceDaoImpl;
import View.Accueil.JCarousel;
import View.BandeADiffuser;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;

import javax.swing.*;
import java.awt.*;

public class AdminPrincipal extends JPanel {
    String couleur1;
    String couleur2;
    String couleur3;
    private JPanel mainPanel;
    private JButton btnFilms;
    private JButton btnLogOut;
    private JButton GestionOffre;
    private JButton GestionFilm;
    private JButton GestionUser;

    public AdminPrincipal() {
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


        btnFilms = new BorderRadButton("Films", 10);
        btnFilms.setBackground(Color.decode(couleur2));
        btnLogOut = new BorderRadButton("Déconnexion", 10);
        btnLogOut.setBackground(Color.decode(couleur2));

        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnFilms, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalGlue()); // Ajout d'un espace flexible
        buttonsPanel.add(btnLogOut, BorderLayout.EAST); // Aligner le bouton "Profil" à droite
        row1.add(buttonsPanel, BorderLayout.CENTER);

        mainPanel.add(row1, gbc);

        JPanel row2 = new JPanel(new BorderLayout());
        //row2.setOpaque(false);
        row2.setBackground(Color.decode(couleur3));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.60;
        //gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.BOTH;



        mainPanel.add(row2, gbc);

        JPanel row3 = new JPanel();
        row3.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.39;
        //gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.NONE;

        GestionOffre = new BorderRadButton("Gestion des Offres", 10);
        GestionOffre.setBackground(Color.decode(couleur3));
        GestionOffre.setPreferredSize(new Dimension(200, 75));
        GestionFilm = new BorderRadButton("Gestion des Films", 10);
        GestionFilm.setBackground(Color.decode(couleur3));
        GestionFilm.setPreferredSize(new Dimension(200, 75));
        GestionUser = new BorderRadButton("Gestion des Utilisateurs", 10);
        GestionUser.setBackground(Color.decode(couleur3));
        GestionUser.setPreferredSize(new Dimension(200, 75));

        row3.add(GestionOffre, BorderLayout.WEST);
        row3.add(Box.createHorizontalStrut(100));
        row3.add(GestionFilm, BorderLayout.CENTER);
        row3.add(Box.createHorizontalStrut(100));
        row3.add(GestionUser, BorderLayout.EAST);


        mainPanel.add(row3, gbc);

        add(mainPanel);
    }



    public JButton getBtnFilms() {
        return btnFilms;
    }
    public JButton getGestionOffre() {
        return GestionOffre;
    }
    public JButton getGestionFilm() {
        return GestionFilm;
    }
    public JButton getGestionUser() {
        return GestionUser;
    }
    public JButton getBtnLogOut() {
        return btnLogOut;
    }

}
