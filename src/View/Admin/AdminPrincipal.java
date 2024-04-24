package View.Admin;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.SeanceDaoImpl;
import View.Accueil.JCarousel;
import View.BandeADiffuser;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;
import View.BorderRadCompenent.BorderRadPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Vue principale pour l'administration du site.
 */
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

    /**
     * Constructeur de la classe AdminPrincipal.
     */
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

        JPanel row2 = new JPanel(new FlowLayout()); // Utiliser un FlowLayout pour aligner les films côte à côte
        row2.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.60;
        gbc.fill = GridBagConstraints.BOTH;

        FilmDaoImpl filmdao = new FilmDaoImpl();
        List<Film> top3Films = filmdao.Top3();

        for(Film film : top3Films){
            JPanel panel = new JPanel(new BorderLayout()); // Utiliser un BorderLayout pour aligner le titre en haut et le poster au centre
            JLabel titre = new JLabel(film.getFilm_title());
            titre.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(titre, BorderLayout.NORTH);
            JPanel poster = new BorderRadPanel(10);
            ImageIcon posterIcon = new ImageIcon(film.getFilm_poster());
            Image scaledPosterImage = posterIcon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            ImageIcon scaledPosterIcon = new ImageIcon(scaledPosterImage);
            JLabel posterLabel = new JLabel(scaledPosterIcon);
            poster.add(posterLabel);
            panel.add(poster, BorderLayout.CENTER);
            row2.add(Box.createHorizontalStrut(20));
            row2.add(panel); // Ajouter le panel contenant le titre et le poster à row2
        }

        mainPanel.add(row2, gbc);

        JPanel row3 = new JPanel();
        row3.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.39;
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

    /**
     * Renvoie le bouton pour accéder à la gestion des films.
     *
     * @return Le bouton pour accéder à la gestion des films
     */
    public JButton getBtnFilms() {
        return btnFilms;
    }

    /**
     * Renvoie le bouton pour accéder à la gestion des offres.
     *
     * @return Le bouton pour accéder à la gestion des offres
     */
    public JButton getGestionOffre() {
        return GestionOffre;
    }

    /**
     * Renvoie le bouton pour accéder à la gestion des films.
     *
     * @return Le bouton pour accéder à la gestion des films
     */
    public JButton getGestionFilm() {
        return GestionFilm;
    }

    /**
     * Renvoie le bouton pour accéder à la gestion des utilisateurs.
     *
     * @return Le bouton pour accéder à la gestion des utilisateurs
     */
    public JButton getGestionUser() {
        return GestionUser;
    }

    /**
     * Renvoie le bouton pour se déconnecter.
     *
     * @return Le bouton pour se déconnecter
     */
    public JButton getBtnLogOut() {
        return btnLogOut;
    }
}
