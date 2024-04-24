package View.AddThings;

import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Fenêtre permettant d'ajouter un film.
 */
public class AddFilm extends JFrame {
    private JTextField titleField;
    private JTextField directorField;
    private JTextField genreField;
    private JTextArea synopsisArea;
    private JTextField durationField;
    private JTextField releaseDateField;
    private JButton addButton;
    private JRadioButton atAfficheButton;
    private JRadioButton aVenirButton;
    private JRadioButton enAvantPremiereButton;
    private JButton insertPosterButton;
    private JLabel posterLabel;

    /**
     * Constructeur de la classe AddFilm.
     */
    public AddFilm() {
        setTitle("Ajouter un film");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2, 10, 10));
        panel.setBackground(Color.decode("#2a2d43"));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Titre du film
        JLabel titleLabel = new JLabel("Nom du film : ");
        titleLabel.setForeground(Color.WHITE);
        titleField = new BorderRadTextField(10);
        titleField.setBorder(BorderFactory.createLineBorder(Color.decode("#BCF4F5"))); // Bordure plus fine

        // Réalisateur
        JLabel directorLabel = new JLabel("Réalisateur : ");
        directorLabel.setForeground(Color.WHITE);
        directorField = new BorderRadTextField(10);


        // Genre
        JLabel genreLabel = new JLabel("Genre : ");
        genreLabel.setForeground(Color.WHITE);
        genreField = new BorderRadTextField(10);


        // Synopsis
        JLabel synopsisLabel = new JLabel("Synopsis : ");
        synopsisLabel.setForeground(Color.WHITE);
        synopsisArea = new JTextArea();
        JScrollPane synopsisScrollPane = new JScrollPane(synopsisArea);


        // Durée
        JLabel durationLabel = new JLabel("Durée (en minutes) : ");
        durationLabel.setForeground(Color.WHITE);
        durationField = new BorderRadTextField(10);


        // Date de sortie
        JLabel releaseDateLabel = new JLabel("Date de sortie : ");
        releaseDateLabel.setForeground(Color.WHITE);
        releaseDateField = new BorderRadTextField(10);


        // Statut
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(1, 3));
        statusPanel.setBackground(Color.decode("#2a2d43"));

        JLabel statusLabel = new JLabel("Choisissez un statut : ");
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setOpaque(false);

        atAfficheButton = new JRadioButton("À l'affiche");
        aVenirButton = new JRadioButton("À venir");
        enAvantPremiereButton = new JRadioButton("En Avant Première");

        atAfficheButton.setBackground(new Color(0,0,0,0));
        aVenirButton.setBackground(new Color(0,0,0,0));
        enAvantPremiereButton.setBackground(new Color(0,0,0,0));

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(atAfficheButton);
        statusGroup.add(aVenirButton);
        statusGroup.add(enAvantPremiereButton);

        atAfficheButton.setForeground(Color.WHITE);
        aVenirButton.setForeground(Color.WHITE);
        enAvantPremiereButton.setForeground(Color.WHITE);

        statusPanel.add(atAfficheButton);
        statusPanel.add(aVenirButton);
        statusPanel.add(enAvantPremiereButton);
        statusPanel.setOpaque(false);

        // Bouton pour insérer le poster
        insertPosterButton = new BorderRadButton("Insérer Poster",10);

        // Label pour afficher le chemin du poster sélectionné
        posterLabel = new JLabel("Aucun fichier sélectionné");
        posterLabel.setForeground(Color.WHITE);

        JLabel posterTextLabel = new JLabel("Poster : ");
        posterTextLabel.setForeground(Color.WHITE);

        // Bouton pour ajouter un film
        addButton = new BorderRadButton("Ajouter",10);
        addButton.setBackground(Color.decode("#BCF4F5"));

        // Ajout des composants au panel
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(directorLabel);
        panel.add(directorField);
        panel.add(genreLabel);
        panel.add(genreField);
        panel.add(synopsisLabel);
        panel.add(synopsisScrollPane);
        panel.add(durationLabel);
        panel.add(durationField);
        panel.add(releaseDateLabel);
        panel.add(releaseDateField);
        panel.add(statusLabel);
        panel.add(statusPanel);
        panel.add(new JLabel()); // espace vide
        panel.add(insertPosterButton);
        panel.add(posterTextLabel);
        panel.add(posterLabel);
        panel.add(new JLabel()); // espace vide
        panel.add(addButton);

        add(panel);
    }

    /**
     * Renvoie le chemin du poster du film.
     *
     * @return Chemin du poster.
     */
    public String getPosterPath() {
        return posterLabel.getText();
    }

    /**
     * Définit le chemin du poster du film.
     *
     * @param path Chemin du poster.
     */
    public void setPosterPath(String path) {
        posterLabel.setText(path);
    }

    /**
     * Ajoute un écouteur pour le bouton d'insertion de poster.
     *
     * @param listener ActionListener pour le bouton d'insertion de poster.
     */
    public void addInsertPosterListener(ActionListener listener) {
        insertPosterButton.addActionListener(listener);
    }

    /**
     * Renvoie le titre du film.
     *
     * @return Titre du film.
     */
    public String getTitleField() {
        return titleField.getText();
    }

    /**
     * Renvoie le réalisateur du film.
     *
     * @return Réalisateur du film.
     */
    public String getDirectorField() {
        return directorField.getText();
    }

    /**
     * Renvoie le genre du film.
     *
     * @return Genre du film.
     */
    public String getGenreField() {
        return genreField.getText();
    }

    /**
     * Renvoie le synopsis du film.
     *
     * @return Synopsis du film.
     */
    public String getSynopsisArea() {
        return synopsisArea.getText();
    }

    /**
     * Renvoie la durée du film.
     *
     * @return Durée du film.
     */
    public String getDurationField() {
        return durationField.getText();
    }

    /**
     * Renvoie la date de sortie du film.
     *
     * @return Date de sortie du film.
     */
    public String getReleaseDateField() {
        return releaseDateField.getText();
    }

    /**
     * Renvoie le statut du film.
     *
     * @return Statut du film (1 = À l'affiche, 2 = À venir, 3 = En Avant Première).
     */
    public int getStatus() {
        if (atAfficheButton.isSelected()) {
            return 1; // À l'affiche
        } else if (aVenirButton.isSelected()) {
            return 2; // À venir
        } else if (enAvantPremiereButton.isSelected()) {
            return 3; // En Avant Première
        }
        return 0; // Aucun statut sélectionné
    }

    /**
     * Affiche un message dans la fenêtre.
     *
     * @param message Message à afficher.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Ajoute un écouteur pour le bouton d'ajout de film.
     *
     * @param listener ActionListener pour le bouton d'ajout de film.
     */
    public void addAddListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
