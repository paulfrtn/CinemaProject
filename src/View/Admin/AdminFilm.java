package View.Admin;

import Controller.AddFilm.ControllerAddFilm;
import Controller.AddSeance.ControllerAddSeance;
import Controller.SuppFilm.ControllerSuppFilm;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import Model.User.User;
import View.AddThings.AddFilm;
import View.AddThings.AddSeance;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;
import View.BorderRadCompenent.BorderRadPanel;
import View.AddThings.SuppFilm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Cette classe représente le panneau de gestion des films pour l'administrateur.
 * Elle permet d'ajouter, de supprimer et de visualiser les films ainsi que les séances associées.
 */
public class AdminFilm extends JPanel {
    // Déclaration des variables de couleur et des composants
    String couleur1;
    String couleur2;
    String couleur3;
    private JPanel mainPanel;
    private JButton btnBack;
    private JButton btnFilms;
    private JButton btnOffers;
    private JButton btnLogOut;
    private JButton viewAllFilms;
    private JButton btnAddFilm;
    private JButton btnDeleteFilm;
    private JButton btnAddSeance;
    private FilmDaoImpl filmDao;
    private SeanceDaoImpl seanceDao;
    private Film film;
    private JPanel FilmsPanel;
    private List<Seance> seances;

    /**
     * Constructeur de la classe AdminFilm.
     *
     * @param films   La liste des films à afficher
     * @param seances La liste des séances à afficher
     */
    public AdminFilm(List<Film> films, List<Seance> seances) {
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";

        setLayout(new BorderLayout());
        setBackground(Color.decode(couleur1));

        filmDao = new FilmDaoImpl();
        seanceDao = new SeanceDaoImpl();
        this.seances = seances;

        FilmsPanel = new JPanel();
        FilmsPanel.setOpaque(false);
        FilmsPanel.setLayout(new BoxLayout(FilmsPanel, BoxLayout.Y_AXIS));

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
        buttonsPanel.add(Box.createHorizontalGlue()); // Ajout d'un espace flexible
        buttonsPanel.add(btnLogOut); // Aligner le bouton "Profil" à droite
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


        viewAllFilms = new BorderRadButton("Voir tous les films", 10);
        viewAllFilms.setBackground(Color.decode(couleur2));
        viewAllFilms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Ajouter la logique pour afficher tous les films
            }
        });

        btnAddFilm = new BorderRadButton("Ajouter un film", 10);
        btnAddFilm.setBackground(Color.decode(couleur2));
        btnAddFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFilm addFilm = new AddFilm();
                ControllerAddFilm controllerAddFilm = new ControllerAddFilm(addFilm, filmDao);
                controllerAddFilm.start();
            }
        });

        btnDeleteFilm = new BorderRadButton("Supprimer un film", 10);
        btnDeleteFilm.setBackground(Color.decode(couleur2));
        btnDeleteFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuppFilm suppFilm = new SuppFilm();
                ControllerSuppFilm controllerSuppFilm = new ControllerSuppFilm();
                controllerSuppFilm.start();

            }
        });

        btnAddSeance = new BorderRadButton("Ajouter une séance", 10);
        btnAddSeance.setBackground(Color.decode(couleur2));
        btnAddSeance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSeance addSeance = new AddSeance();
                ControllerAddSeance controllerAddSeance = new ControllerAddSeance(addSeance, seanceDao, filmDao);
                controllerAddSeance.start();
                updateSeances();
            }
        });


        ButtonPanel.add(viewAllFilms);
        ButtonPanel.add(btnAddFilm);
        ButtonPanel.add(btnDeleteFilm);
        ButtonPanel.add(btnAddSeance);

        row2.add(ButtonPanel, gbc2);

        JScrollPane FilmsScrollPane = new JScrollPane(FilmsPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        FilmsScrollPane.setOpaque(false);
        FilmsScrollPane.getViewport().setOpaque(false);
        FilmsScrollPane.setBorder(BorderFactory.createEmptyBorder());

        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.9;
        gbc2.insets = new Insets(7, 7, 7, 15);
        gbc2.fill = GridBagConstraints.BOTH;
        //gbc2.anchor = GridBagConstraints.NORTH;


        for (Seance seance : seances) {
            JPanel SeancePanel = new BorderRadPanel(10);
            Film film = filmDao.getFilmById(seance.getFilm_id());
            JLabel SeanceLabel = new JLabel("Film :" + film.getFilm_title() + " - " + seance.getSeance_date() + " - " + seance.getSeance_time() + " - " + seance.getSeance_language());
            SeancePanel.add(SeanceLabel);
            SeancePanel.setBackground(Color.decode(couleur3));
            FilmsPanel.add(SeancePanel);
        }

        FilmsScrollPane.setViewportView(FilmsPanel);


        row2.add(FilmsScrollPane, gbc2);

        mainPanel.add(row2, gbc);

        add(mainPanel);

        updateSeances();
    }

    /**
     * Met à jour la liste des séances.
     */
    public void updateSeances() {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        List<Seance> seances = seanceDao.getAllSeances();
        FilmsPanel.removeAll();
        FilmsPanel.revalidate();
        FilmsPanel.repaint();
        // Ajouter les nouvelles séances
        for (Seance seance : seances) {
            JPanel seancePanel = new BorderRadPanel(10);
            film = filmDao.getFilmById(seance.getFilm_id());
            JLabel seanceLabel = new JLabel(film.getFilm_title() + " - " + seance.getSeance_date() + " - " + seance.getSeance_time() + " - " + seance.getSeance_language());
            seancePanel.add(seanceLabel);
            seancePanel.setBackground(Color.decode(couleur3));
            FilmsPanel.add(seancePanel);
        }
        // Mettre à jour l'affichage
        FilmsPanel.revalidate();
        FilmsPanel.repaint();
    }

    /**
     * Retourne le bouton "Retour".
     *
     * @return Le bouton "Retour"
     */
    public JButton getBtnBack() {
        return btnBack;
    }

    /**
     * Retourne le bouton "Films".
     *
     * @return Le bouton "Films"
     */
    public JButton getBtnFilms() {
        return btnFilms;
    }

    /**
     * Retourne le bouton "Déconnexion".
     *
     * @return Le bouton "Déconnexion"
     */
    public JButton getBtnLogOut() {
        return btnLogOut;
    }
}
