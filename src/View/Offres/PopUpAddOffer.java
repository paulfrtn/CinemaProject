package View.Offres;

import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Classe représentant une fenêtre de dialogue pour ajouter une nouvelle offre.
 */
public class PopUpAddOffer extends JFrame {
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextField startDateField;
    private JTextField endDateField;

    private JTextField discountField;
    private JTextField userTypeField;
    private JButton addButton;

    /**
     * Constructeur de la fenêtre de dialogue pour ajouter une nouvelle offre.
     */
    public PopUpAddOffer() {
        setTitle("Ajouter une offre");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 2, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#2a2d43"));

        JLabel nameLabel = new JLabel("Nom de l'offre:");
        nameLabel.setForeground(Color.WHITE);
        nameField = new BorderRadTextField(10);


        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        JLabel startDateLabel = new JLabel("Date de début (yyyy-MM-dd):");
        startDateLabel.setForeground(Color.WHITE);
        startDateField = new BorderRadTextField(10);

        JLabel endDateLabel = new JLabel("Date de fin (yyyy-MM-dd):");
        endDateLabel.setForeground(Color.WHITE);
        endDateField = new BorderRadTextField(10);

        JLabel discountLabel = new JLabel("Réduction:");
        discountLabel.setForeground(Color.WHITE);
        discountField = new BorderRadTextField(10);


        JLabel userTypeLabel = new JLabel("Type d'utilisateur:");
        userTypeLabel.setForeground(Color.WHITE);
        userTypeField = new BorderRadTextField(10);

        addButton = new BorderRadButton("Ajouter", 10);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descriptionLabel);
        panel.add(descriptionScrollPane);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(endDateLabel);
        panel.add(endDateField);

        panel.add(discountLabel);
        panel.add(discountField);

        panel.add(userTypeLabel);
        panel.add(userTypeField);
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
    }

    /**
     * Renvoie le contenu du champ de saisie du nom de l'offre.
     *
     * @return Le contenu du champ de saisie du nom de l'offre.
     */
    public String getNameField() {
        return nameField.getText();
    }

    /**
     * Renvoie le contenu de la zone de texte de description de l'offre.
     *
     * @return Le contenu de la zone de texte de description de l'offre.
     */
    public String getDescriptionArea() {
        return descriptionArea.getText();
    }

    /**
     * Renvoie le contenu du champ de saisie de la date de début de l'offre.
     *
     * @return Le contenu du champ de saisie de la date de début de l'offre.
     */
    public String getStartDateField() {
        return startDateField.getText();
    }

    /**
     * Renvoie le contenu du champ de saisie de la date de fin de l'offre.
     *
     * @return Le contenu du champ de saisie de la date de fin de l'offre.
     */
    public String getEndDateField() {
        return endDateField.getText();
    }

    /**
     * Renvoie le contenu du champ de saisie de la réduction de l'offre.
     *
     * @return Le contenu du champ de saisie de la réduction de l'offre.
     */
    public String getDiscountField() {
        return discountField.getText();
    }

    /**
     * Renvoie le contenu du champ de saisie du type d'utilisateur de l'offre.
     *
     * @return Le contenu du champ de saisie du type d'utilisateur de l'offre.
     */
    public String getUserTypeField() {
        return userTypeField.getText();
    }

    /**
     * Ajoute un écouteur d'événement au bouton d'ajout.
     *
     * @param listener L'écouteur d'événement à ajouter.
     */
    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
