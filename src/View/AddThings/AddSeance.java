package View.AddThings;

import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Cette classe représente la fenêtre d'ajout d'une séance.
 */
public class AddSeance extends JFrame {
    private JTextField filmTitleField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField languageField;
    private JTextField salleNumberField; // Nouveau champ pour le numéro de salle
    private JButton addButton;

    /**
     * Constructeur de la classe AddSeance.
     */
    public AddSeance() {
        setTitle("Ajouter une séance");
        setSize(600, 350); // Ajustement de la hauteur pour le nouveau champ
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // Ajustement du nombre de lignes pour le nouveau champ
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#2a2d43"));

        JLabel filmTitleLabel = new JLabel("Titre du film : ");
        filmTitleLabel.setForeground(Color.WHITE);
        filmTitleField = new BorderRadTextField(10);

        JLabel dateLabel = new JLabel("Date de la séance (yyyy-MM-dd) : ");
        dateLabel.setForeground(Color.WHITE);
        dateField = new BorderRadTextField(10);

        JLabel timeLabel = new JLabel("Horaire de la séance (HH:mm:ss) : ");
        timeLabel.setForeground(Color.WHITE);
        timeField = new BorderRadTextField(10);

        JLabel languageLabel = new JLabel("Langue : ");
        languageLabel.setForeground(Color.WHITE);
        languageField = new BorderRadTextField(10);

        JLabel salleNumberLabel = new JLabel("Numéro de salle (1 à 5) : "); // Label pour le numéro de salle
        salleNumberLabel.setForeground(Color.WHITE);
        salleNumberField = new BorderRadTextField(10);

        addButton = new BorderRadButton("Ajouter", 10);

        panel.add(filmTitleLabel);
        panel.add(filmTitleField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(languageLabel);
        panel.add(languageField);
        panel.add(salleNumberLabel); // Ajout du label pour le numéro de salle
        panel.add(salleNumberField); // Ajout du champ pour le numéro de salle
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
    }

    /**
     * Méthode pour récupérer le titre du film saisi.
     *
     * @return Le titre du film
     */
    public String getFilmTitle() {
        return filmTitleField.getText();
    }

    /**
     * Méthode pour récupérer la date de la séance saisie.
     *
     * @return La date de la séance
     */
    public String getDate() {
        return dateField.getText();
    }

    /**
     * Méthode pour récupérer l'horaire de la séance saisi.
     *
     * @return L'horaire de la séance
     */
    public String getTime() {
        return timeField.getText();
    }

    /**
     * Méthode pour récupérer la langue de la séance saisie.
     *
     * @return La langue de la séance
     */
    public String getLanguage() {
        return languageField.getText();
    }

    /**
     * Méthode pour récupérer le numéro de salle saisi.
     *
     * @return Le numéro de salle
     */
    public int getSalleNumber() {
        try {
            int salleNumber = Integer.parseInt(salleNumberField.getText());
            if (salleNumber < 1 || salleNumber > 6) {
                throw new NumberFormatException(); // Lever une exception si le numéro de salle n'est pas entre 1 et 5
            }
            return salleNumber;
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur si le numéro de salle n'est pas valide
            JOptionPane.showMessageDialog(this, "Veuillez saisir un numéro de salle entre 1 et 5.");
            return -1; // Retourner une valeur invalide pour indiquer une erreur
        }
    }

    /**
     * Méthode pour ajouter un écouteur au bouton d'ajout.
     *
     * @param listener L'écouteur à ajouter
     */
    public void addAddListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    /**
     * Méthode pour afficher un message.
     *
     * @param message Le message à afficher
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
