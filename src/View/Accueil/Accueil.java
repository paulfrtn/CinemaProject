package View.Accueil;

import Controller.MainFrame;
import Model.Film.Film;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Accueil extends JPanel {
    private JPanel mainPanel;
    private JButton btnFilms;
    private JButton btnProfile;
    private JButton btnSearch;
    private JButton btnOffers;
    private JCarousel carouselNowShowing;
    private JCarousel carouselPremieres;
    private JCarousel carouselComingSoon;
    private MainFrame controller;
    private String couleur1;
    private String couleur2;
    private String couleur3;

    public Accueil(MainFrame controller, List<Film> nowShowingFilms, List<Film> premieresFilms, List<Film> comingSoonFilms, int filmLimit) {

        this.controller = controller;
        setLayout(new BorderLayout());
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";
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


        btnSearch = new BorderRadButton("Rechercher", 10);
        btnSearch.setBackground(Color.decode(couleur2));
        btnFilms = new BorderRadButton("Films", 10);
        btnFilms.setBackground(Color.decode(couleur2));
        btnOffers = new BorderRadButton("Offres", 10);
        btnOffers.setBackground(Color.decode(couleur2));
        btnProfile = new BorderRadButton("Profil", 10);
        btnProfile.setBackground(Color.decode(couleur2));

        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnSearch, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnFilms, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnOffers, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalGlue()); // Ajout d'un espace flexible
        buttonsPanel.add(btnProfile, BorderLayout.EAST); // Aligner le bouton "Profil" à droite
        row1.add(buttonsPanel, BorderLayout.CENTER);

        mainPanel.add(row1, gbc);

        JPanel row2 = new JPanel(new BorderLayout());
        row2.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.90;
        //gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.BOTH;


        carouselNowShowing = new JCarousel(this.controller,"Now Showing", nowShowingFilms.subList(0, Math.min(nowShowingFilms.size(), filmLimit)));
        carouselPremieres = new JCarousel(this.controller,"Premieres", premieresFilms.subList(0, Math.min(premieresFilms.size(), filmLimit)));
        carouselComingSoon = new JCarousel(this.controller,"Coming Soon", comingSoonFilms.subList(0, Math.min(comingSoonFilms.size(), filmLimit)));

        // Utilise GridLayout pour le panneau des carrousels
        JPanel carouselPanel = new JPanel(new GridLayout(3, 1));
        carouselPanel.add(carouselNowShowing);
        carouselPanel.add(carouselPremieres);
        carouselPanel.add(carouselComingSoon);

        row2.add(carouselPanel, BorderLayout.CENTER);
        mainPanel.add(row2, gbc);

        add(mainPanel);
    }

    public JButton getbtnSearch(){
        return btnSearch;
    }

    public JButton getbtnFilms(){
        return btnFilms;
    }

    public JButton getbtnOffers(){
        return btnOffers;
    }

}

