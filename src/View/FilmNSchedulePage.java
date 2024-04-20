package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Controller.FilmSchedule.ControllerFilmSchedule;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import java.util.Comparator;
import java.util.Collections;


//A supprimer apres
import Controller.MainFrame;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;

public class FilmNSchedulePage extends JPanel {
    private ControllerFilmSchedule controller;
    private MainFrame mainFrame;
    private JButton profil;
    private JButton CurrentButtonDate;
    private Boolean Start;
    List<Seance> seances;
    private JPanel line2;
    private JPanel line4;
    private int current_film_id;
    String couleur;
    String couleur2;
    String couleur3;

    public FilmNSchedulePage(MainFrame controller,
                             int film_id,
                             String film_title,
                             String film_director,
                             String film_genre,
                             int film_duration,
                             String film_synopsis,
                             Date film_release_date,
                             Boolean film_status,
                             String film_poster) {
        this.mainFrame = controller;
        couleur = "#003049";
        couleur3 = "#669BBC";
        couleur2 = "#FDF0D5";
        Start = false;
        setBackground(Color.decode(couleur));
        current_film_id=film_id;
        //FilmDaoImpl filmDao = new FilmDaoImpl();
        //film = filmDao.getFilmById(film_id);
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        seances = null;
        BandeADiffuser bandeADiffuser = new BandeADiffuser();


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Les composants occupent tout l'espace disponible

        // Panel pour la partie supérieure (2/10 de la hauteur)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.decode(couleur));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Remplit toute la largeur
        gbc.weightx = 1.0; // Poids pour étendre sur toute la largeur
        gbc.weighty = 0.01; // 2/10 de la hauteur
        gbc.insets = new Insets(3, 3, 3, 3); // Marge de 0 partout

        // Création du bouton avec une image redimensionnée et sans texte
        profil = new BorderRadButton(10);
        profil.setContentAreaFilled(false); // Supprime le remplissage pour que l'image soit visible
        profil.setBorder(null); // Supprime la bordure
        try {
            // Chargez votre image ici
            BufferedImage originalImage = ImageIO.read(new File("src/Model/Images/Icon/utilisateur.png"));
            // Redimensionner l'image
            int width = 35; // Largeur souhaitée
            int height = 35; // Hauteur souhaitée
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            profil.setIcon(icon);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        profil.setText(null); // Supprime le texte

        // Ajouter le bouton tout en haut à droite
        topPanel.add(profil, BorderLayout.EAST);

        add(topPanel, gbc);

        // Panel pour la première partie centrale (4/10 de la hauteur)
        JPanel middlePanel1 = new JPanel(new GridBagLayout());
        middlePanel1.setBackground(Color.decode(couleur));
        gbc.gridy = 1;
        gbc.weighty = 0.11; // 4/10 de la hauteur

        // Première colonne
        JPanel column1 = new JPanel(new GridBagLayout()); // Utilisation d'un nouveau GridBagLayout pour centrer l'image
        column1.setBackground(Color.decode(couleur));
        GridBagConstraints gbcColumn1 = new GridBagConstraints();
        gbcColumn1.gridx = 0;
        gbcColumn1.gridy = 0;
        gbcColumn1.weightx = 0.3;
        gbcColumn1.weighty = 1.0;
        gbcColumn1.fill = GridBagConstraints.BOTH;
        gbcColumn1.insets = new Insets(0, 20, 0, 20);
        column1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // L'image centrée dans la première colonne
        try {
            BufferedImage posterImage = ImageIO.read(new File(film_poster));
            Image resizedImage = posterImage.getScaledInstance(210, 297, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);
            JLabel imageLabel = new BorderRadLabel(icon, 10, Color.decode(couleur)); // 10 est le rayon du bord
           // imageLabel.setBorder(null);
            column1.add(imageLabel, gbcColumn1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        middlePanel1.add(column1);

        // Deuxième colonne
        JPanel column2 = new JPanel(new BorderLayout()); // Utiliser BorderLayout pour contrôler l'alignement à gauche
        column2.setBackground(Color.decode(couleur));
        GridBagConstraints gbcColumn2 = new GridBagConstraints();
        gbcColumn2.gridx = 1;
        gbcColumn2.gridy = 0;
        gbcColumn2.weightx = 1;
        gbcColumn2.weighty = 0.33;
        gbcColumn2.gridheight = 1;
        gbcColumn2.fill = GridBagConstraints.BOTH;
        gbcColumn2.anchor = GridBagConstraints.WEST;
        gbcColumn2.insets = new Insets(0, 0, 0, 0);

        // Création d'une grille pour afficher les informations du film
        JPanel gridPanel = new JPanel(new GridLayout(4, 1, 0, -2));
        gridPanel.setBackground(Color.decode(couleur));
        // Création d'un JLabel pour afficher le titre
        JLabel title = new JLabel(film_title);
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.LEFT);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        gridPanel.add(title);

        JLabel director = new JLabel("Réalisateur: " + film_director + "    -    " + "Genre: " + film_genre);
        director.setForeground(Color.WHITE);
        director.setHorizontalAlignment(SwingConstants.LEFT);
        gridPanel.add(director);


        JLabel duration = new JLabel("Durée: " + film_duration + " minutes" + "     -     " + "Date de sortie: " + film_release_date);
        duration.setForeground(Color.WHITE);
        duration.setHorizontalAlignment(SwingConstants.LEFT);
        gridPanel.add(duration);


        JTextArea synopsisArea = new JTextArea(film_synopsis);
        synopsisArea.setLineWrap(true); // Permet le retour automatique à la ligne
        synopsisArea.setWrapStyleWord(true); // Coupe les mots entiers seulement
        synopsisArea.setEditable(false); // Empêche l'édition du texte
        synopsisArea.setBackground(Color.decode(couleur));
        synopsisArea.setForeground(Color.WHITE);
        synopsisArea.setPreferredSize(new Dimension(600, 200));
        synopsisArea.setAlignmentX(SwingConstants.LEFT);
        gridPanel.add(synopsisArea);


        // Ajout du JScrollPane à la deuxième colonne
        column2.add(gridPanel, BorderLayout.WEST);


        middlePanel1.add(column2, gbcColumn2);


        // Troisième colonne
        JPanel column3 = new JPanel(new GridBagLayout()); // Utilisation d'un nouveau GridBagLayout pour centrer le bouton
        column3.setBackground(Color.decode(couleur));
        GridBagConstraints gbcColumn3 = new GridBagConstraints();
        gbcColumn3.gridx = 2;
        gbcColumn3.gridy = 0;
        gbcColumn3.weightx = 0.3;
        gbcColumn3.weighty = 1.0;
        gbcColumn3.fill = GridBagConstraints.NONE;

        // Bouton "Bande d'annonce" centré dans la troisième colonne
        JButton bandeAnnonceButton = new BorderRadButton("Bande d'annonce",10);
        bandeAnnonceButton.setPreferredSize(new Dimension(10, 30)); // Définir la taille du bouton
        bandeAnnonceButton.setBackground(Color.decode(couleur2));
        bandeAnnonceButton.addActionListener(e -> BandeAnnonceButtonClicked("src/Model/Images/BandeAnnonce/TFG.mp4"));
        column3.add(bandeAnnonceButton, gbcColumn3);

        middlePanel1.add(column3, gbcColumn3);

        add(middlePanel1, gbc);


        // Panel pour la deuxième partie centrale (4/10 de la hauteur)
        JPanel middlePanel2 = new JPanel(new GridBagLayout());
        middlePanel2.setBackground(Color.decode(couleur));
        gbc.gridy = 2;
        gbc.weighty = 0.595; // 4/10 de la hauteur

// Première ligne (35% de la hauteur)
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 10));
        row1.setBackground(Color.decode(couleur)); // Couleur pour visualiser
        GridBagConstraints gbcRow1 = new GridBagConstraints();
        gbcRow1.gridx = 0;
        gbcRow1.gridy = 0;
        gbcRow1.weightx = 1.0;
        gbcRow1.weighty = 0.35; // 35% de la hauteur
        //gbcRow1.fill = GridBagConstraints.BOTH;


        JButton button1 = new BorderRadButton(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM")),10);
        button1.setBackground(Color.decode(couleur2));
        button1.setPreferredSize(new Dimension(75, 50));
        button1.setName(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); // Définir un nom pour le bouton
        button1.addActionListener(e -> buttonClicked(button1));
        if (!Start) {
            button1.setBackground(Color.decode(couleur3));
            CurrentButtonDate = button1;
            System.out.println(CurrentButtonDate.getName());
            seances = seanceDao.getSeanceByDateNFilmId(java.sql.Date.valueOf(CurrentButtonDate.getName()), film_id);
            Collections.sort(seances, new SeanceComparator());
            Start = true;
        }

        row1.add(button1);

// Création des 5 boutons suivants pour les 5 jours suivants
        for (int i = 1; i <= 5; i++) {

            LocalDate nextDate = LocalDate.now().plusDays(i);
            JButton nextButton = new BorderRadButton(nextDate.format(DateTimeFormatter.ofPattern("dd MMM")),10);
            nextButton.setBackground(Color.decode(couleur2));
            nextButton.setPreferredSize(new Dimension(75, 50));
            nextButton.setName(nextDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); // Définir un nom pour le bouton
            nextButton.addActionListener(e -> buttonClicked(nextButton));
            row1.add(nextButton);
        }


        middlePanel2.add(row1, gbcRow1);

// Deuxième ligne (65% de la hauteur)
        JPanel row2 = new JPanel(new GridBagLayout()); // Utiliser GridBagLayout pour ajouter les lignes avec des tailles variables
        row2.setBackground(Color.decode(couleur)); // Couleur pour visualiser
        GridBagConstraints gbcRow2 = new GridBagConstraints();
        gbcRow2.gridx = 0;
        gbcRow2.gridy = 1;
        gbcRow2.weightx = 1.0;
        gbcRow2.weighty = 0.65; // 65% de la hauteur
        gbcRow2.fill = GridBagConstraints.BOTH;

// Créer et ajouter les quatre lignes avec des couleurs différentes
        JPanel line1 = new JPanel(new GridBagLayout()); // Utiliser GridBagLayout pour aligner les composants
        line1.setBackground(Color.decode(couleur));
        GridBagConstraints gbcLine1 = new GridBagConstraints();
        gbcLine1.gridx = 0;
        gbcLine1.gridy = 0;
        gbcLine1.weightx = 1.0;
        gbcLine1.weighty = 0.25; // 1/4 de la hauteur de row2
        gbcLine1.fill = GridBagConstraints.BOTH;
        gbcLine1.insets = new Insets(0, 10, 0, 20);

// Ajouter le composant "VOSTFR" tout à gauche
        JLabel vostfrLabel = new JLabel("VOSTFR : ");
        vostfrLabel.setBackground(Color.decode(couleur));
        vostfrLabel.setForeground(Color.WHITE);
        line1.add(vostfrLabel, gbcLine1);

        row2.add(line1, gbcLine1);

        line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        line2.setBackground(Color.decode(couleur));
        GridBagConstraints gbcLine2 = new GridBagConstraints();
        gbcLine2.gridx = 0;
        gbcLine2.gridy = 1;
        gbcLine2.weightx = 1.0;
        gbcLine2.weighty = 0.4; // 1/4 de la hauteur de row2
        gbcLine2.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < seances.size(); i++) {

            Seance seance = seances.get(i);
            if (seance.getSeance_language().equals("Vostfr")) {
                LocalTime startTime = seance.getSeance_time().toLocalTime();
                String buttonText = startTime.format(DateTimeFormatter.ofPattern("HH:mm")); // Formatage de l'heure et des minutes
                JButton button = new BorderRadButton(buttonText, 10);;
                button.setBackground(Color.decode(couleur2));
                button.setName(seance.getSeance_id() + "");
                button.setBorder(BorderFactory.createEtchedBorder(0));
                button.setBorderPainted(false);
                button.setPreferredSize(new Dimension(100, 50)); // Définir la taille des boutons
                line2.add(button);
            }

        }

        row2.add(line2, gbcLine2);

        JPanel line3 = new JPanel(new GridBagLayout());
        line3.setBackground(Color.decode(couleur));
        GridBagConstraints gbcLine3 = new GridBagConstraints();
        gbcLine3.gridx = 0;
        gbcLine3.gridy = 2;
        gbcLine3.weightx = 1.0;
        gbcLine3.weighty = 0.1; // 1/4 de la hauteur de row2
        gbcLine3.fill = GridBagConstraints.BOTH;
        gbcLine3.insets = new Insets(0, 10, 0, 20);

        JLabel vfLabel = new JLabel("VF : ");
        vfLabel.setBackground(Color.decode(couleur));
        vfLabel.setForeground(Color.WHITE);
        line3.add(vfLabel, gbcLine3);

        row2.add(line3, gbcLine3);

        line4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        line4.setBackground(Color.decode(couleur));
        GridBagConstraints gbcLine4 = new GridBagConstraints();
        gbcLine4.gridx = 0;
        gbcLine4.gridy = 3;
        gbcLine4.weightx = 1.0;
        gbcLine4.weighty = 0.4; // 1/4 de la hauteur de row2
        gbcLine4.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < seances.size(); i++) {

            Seance seance = seances.get(i);
            if (seance.getSeance_language().equals("Vf") ) {
                LocalTime startTime = seance.getSeance_time().toLocalTime();
                String buttonText = startTime.format(DateTimeFormatter.ofPattern("HH:mm")); // Formatage de l'heure et des minutes
                JButton button = new BorderRadButton(buttonText, 10);
                button.setBackground(Color.decode(couleur2));
                button.setName(seance.getSeance_id() + "");
                //button.setBorder(new LineBorder(Color.decode(couleur2), 1));
                button.setPreferredSize(new Dimension(100, 50)); // Définir la taille des boutons
                line4.add(button);
            }

        }

        row2.add(line4, gbcLine4);

        middlePanel2.add(row2, gbcRow2);


        add(middlePanel2, gbc);

    }

    public JButton getButtonProfil() {
        return profil;
    }

    public void buttonClicked(JButton button) {
        if (CurrentButtonDate != null) {
            CurrentButtonDate.setBackground(Color.decode(couleur2));
        }
        button.setBackground(Color.decode(couleur3));
        CurrentButtonDate = button;
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        seances = seanceDao.getSeanceByDateNFilmId(java.sql.Date.valueOf(CurrentButtonDate.getName()), current_film_id);
        updateSeanceButtons();
    }

    public String getButtonClickedName(JButton button) {
        return button.getName();
    }

    public JButton getCurrentButtonDate() {
        return CurrentButtonDate;
    }

    public void BandeAnnonceButtonClicked(String path) {
        BandeADiffuser.showVideoPopup(path);
    }

    public class SeanceComparator implements Comparator<Seance> {
        @Override
        public int compare(Seance s1, Seance s2) {
            // Compare les heures de début des séances
            return s1.getSeance_time().compareTo(s2.getSeance_time());
        }
    }

    // Ajoutez cette méthode à votre classe FilmNSchedulePage
    private void updateSeanceButtons() {
        line2.removeAll(); // Supprime tous les boutons actuels de line2
        line4.removeAll(); // Supprime tous les boutons actuels de line4


        for (int i = 0; i < seances.size(); i++) {
            Seance seance = seances.get(i);
            LocalTime startTime = seance.getSeance_time().toLocalTime();
            String buttonText = startTime.format(DateTimeFormatter.ofPattern("HH:mm")); // Formatage de l'heure et des minutes
            JButton button = new BorderRadButton(buttonText, 10);
            button.setBackground(Color.decode(couleur2));
            button.setName(seance.getSeance_id() + "");
            button.setPreferredSize(new Dimension(100, 50)); // Définir la taille des boutons

            // Ajoutez le bouton à la bonne ligne en fonction de la langue de la séance
            if (seance.getSeance_language().equals("Vostfr")) {
                line2.add(button);
            } else if (seance.getSeance_language().equals("Vf")) {
                line4.add(button);
            }
        }

        buttonListeners(mainFrame.getSeanceButtonListener());
        // Rafraîchit l'affichage des boutons
        line2.revalidate();
        line2.repaint();
        line4.revalidate();
        line4.repaint();

    }


    public void buttonListeners(ActionListener actionListener) {
        Component[] components = line2.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(actionListener);
            }
        }

        components = line4.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(actionListener);
            }
        }
    }

    public void addLine2ButtonListener(ActionListener actionListener) {
        Component[] components = line2.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(actionListener);
            }
        }
    }

    public void addLine4ButtonListener(ActionListener actionListener) {
        Component[] components = line4.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(actionListener);
            }
        }
    }



}
