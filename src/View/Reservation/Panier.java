package View.Reservation;

import Controller.MainFrame;
import Controller.Panier.ControllerPanier;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import View.BorderRadCompenent.BorderRadButton;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class Panier extends JPanel {
    private MainFrame controller;
    private JLabel filmLabel;
    private JLabel seanceLabel;
    private JLabel prixTotalLabel;
    private JButton payerButton;
    private JPanel billetsPanel;
    private JLabel posterLabel;
    private JSpinner spinner;
    private int prixParBillet = 12;
    private int nombreBillets = 0;
    private int seanceId;
    private int offerId;
    private Boolean validerPaiement;
    private JButton ValiderButton;
    private String couleur1;
    private String couleur2;
    private String couleur3;

    public Panier(MainFrame controller, ControllerPanier controllerPanier, int seanceId) {
        this.controller = controller;
        this.seanceId = seanceId;
        this.offerId = 0;
        this.validerPaiement = false;
        couleur1 = "#003049";
        couleur3 = "#669BBC";
        couleur2 = "#FDF0D5";
        setLayout(new BorderLayout());
        setBackground(Color.decode(couleur1)); // Couleur de fond
        setSize(1200, 800);

        // Création d'une instance de Seance pour le film
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        Seance seance = seanceDao.getSeanceById(seanceId);
        FilmDaoImpl filmDao = new FilmDaoImpl();
        Film film = filmDao.getFilmById(seance.getFilm_id());

        // Création d'un JPanel pour contenir les informations du film et le poster
        JPanel infoPosterPanel = new JPanel(new GridLayout(1, 2));
        infoPosterPanel.setBackground(Color.decode(couleur1)); // Couleur de fond

        // Création d'un JPanel pour contenir les informations du film
        JPanel infoPanel = new JPanel(new GridLayout(13, 1)); // GridLayout avec 12 lignes pour les informations
        infoPanel.setBackground(Color.decode(couleur1)); // Couleur de fond

        // Affichage des informations du film
        filmLabel = new JLabel("Film : " + film.getFilm_title());
        seanceLabel = new JLabel("Date : " + formatDate(seance.getSeance_date()));
        JLabel horaireLabel = new JLabel("Horaire : " + seance.getSeance_time());
        JLabel languageLabel = new JLabel("Langue : " + seance.getSeance_language());

        // Définition de la taille de police
        Font font = new Font("Arial", Font.PLAIN, 17);
        filmLabel.setFont(font);
        seanceLabel.setFont(font);
        horaireLabel.setFont(font);
        languageLabel.setFont(font);

        filmLabel.setForeground(Color.WHITE); // Texte en blanc
        seanceLabel.setForeground(Color.WHITE); // Texte en blanc
        horaireLabel.setForeground(Color.WHITE); // Texte en blanc
        languageLabel.setForeground(Color.WHITE); // Texte en blanc

        infoPanel.add(filmLabel);
        // Ajout de labels vides pour créer de l'espace
        infoPanel.add(new JLabel(""));
        infoPanel.add(seanceLabel);
        // Ajout de labels vides pour créer de l'espace
        infoPanel.add(new JLabel(""));
        infoPanel.add(horaireLabel);
        // Ajout de labels vides pour créer de l'espace
        infoPanel.add(new JLabel(""));
        infoPanel.add(languageLabel);

        // Ajout du JPanel d'informations du film au JPanel contenant informations et poster
        infoPosterPanel.add(infoPanel);

        // Création d'un JPanel pour l'espace à gauche du poster
        JPanel spacePanel = new JPanel();
        spacePanel.setOpaque(false); // Rend le JPanel transparent
        infoPosterPanel.add(spacePanel);

        // Création d'un JLabel pour afficher le poster du film
        posterLabel = new JLabel(new ImageIcon(film.getFilm_poster()));
        // Redimensionnement de l'image du poster
        Image img = ((ImageIcon) posterLabel.getIcon()).getImage();
        Image newimg = img.getScaledInstance(200, 300, java.awt.Image.SCALE_SMOOTH);
        posterLabel.setIcon(new ImageIcon(newimg));

        // Ajout du poster au JPanel contenant informations et poster
        infoPosterPanel.add(posterLabel);

        // Ajout du JPanel contenant informations et poster à la fenêtre
        add(infoPosterPanel, BorderLayout.NORTH);

        prixTotalLabel = new JLabel("Prix total : " + nombreBillets * prixParBillet + " euros");
        prixTotalLabel.setForeground(Color.WHITE); // Texte en blanc
        prixTotalLabel.setFont(font); // Taille de police plus grande
        add(prixTotalLabel, BorderLayout.CENTER);
        // Ajout de labels vides pour créer de l'espace
        infoPanel.add(new JLabel(""));
        infoPanel.add(new JLabel(""));
        infoPanel.add(new JLabel(""));

        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
        spinner.setPreferredSize(new Dimension(60, 10)); // Taille fixe du spinner
        spinner.addChangeListener(e -> {
            nombreBillets = (int) spinner.getValue();
            updatePrixTotal();
        });
        JPanel spinnerPanel = new JPanel(new BorderLayout());
        spinnerPanel.setBackground(Color.decode(couleur1)); // Couleur de fond

        JLabel billetsLabel = new JLabel("Nombre de billets : ");
        billetsLabel.setForeground(Color.WHITE); // Texte en blanc
        billetsLabel.setFont(font); // Taille de police plus grande
        spinnerPanel.add(billetsLabel, BorderLayout.WEST);
        spinnerPanel.add(spinner, BorderLayout.CENTER);

        // Création du conteneur principal avec un GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode(couleur1)); // Couleur de fond

        // Ajout du panel du spinner au conteneur principal avec des contraintes de centrage horizontal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Position en X
        gbc.gridy = 0; // Position en Y
        gbc.weightx = 1.0; // Poids horizontal (pour le centrage)
        gbc.weighty = 1.0; // Poids vertical (pour le centrage)
        gbc.anchor = GridBagConstraints.CENTER; // Ancrage au centre horizontal
        mainPanel.add(prixTotalLabel, gbc);
        gbc.gridy = 100; // Position en Y
        mainPanel.add(spinnerPanel, gbc);

        // Ajout du conteneur principal à la frame
        add(mainPanel, BorderLayout.CENTER);

        payerButton = new BorderRadButton("Payer",10);
        payerButton.setBackground(Color.decode(couleur2)); // Couleur de bouton
        // Définition de la taille de police plus grande pour le bouton "Payer"
        Font boutonFont = new Font("Arial", Font.PLAIN, 18); // Choisir la police et la taille de police désirées
        payerButton.setFont(boutonFont);
        payerButton.setPreferredSize(new Dimension(100, 50)); // Taille du bouton
        payerButton.addActionListener(e -> payer());
        JPanel payerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        payerPanel.setBackground(Color.decode(couleur1));

        payerPanel.add(payerButton);

        ValiderButton = new BorderRadButton("Valider",10);
        ValiderButton.setBackground(Color.decode(couleur2)); // Couleur de bouton
// Définition de la taille de police plus grande pour le bouton "Payer"
        Font boutonFont1 = new Font("Arial", Font.PLAIN, 18); // Choisir la police et la taille de police désirées
        ValiderButton.setFont(boutonFont1);
        ValiderButton.setPreferredSize(new Dimension(100, 50)); // Taille du bouton
        payerPanel.add(ValiderButton);



        add(payerPanel, BorderLayout.SOUTH);

    }

    private void updatePrixTotal() {
        prixTotalLabel.setText("Prix total : " + nombreBillets * prixParBillet + " euros");
    }

    private void payer() {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        Paiement paiement = new Paiement(controller);
        validerPaiement = paiement.getValiderInformation();
        validerPaiement = paiement.getValiderPaiement();
        paiement.setVisible(true);
    }


    private String formatDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    public int getPrice() {
        return prixParBillet;
    }

    public int getNumberOfTickets() {
        return nombreBillets;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public int getOfferId() {
        return offerId;
    }

    public JButton getValiderButton() {
        return ValiderButton;
    }

    public Boolean getValiderPaiement() {
        return validerPaiement;

    }


}






