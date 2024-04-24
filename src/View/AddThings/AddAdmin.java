package View.AddThings;

import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadPasswordField;
import View.BorderRadCompenent.BorderRadTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Fenêtre permettant d'ajouter un administrateur.
 */
public class AddAdmin extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField mailField;
    private JTextField pseudoField;
    private JPasswordField passwordField;
    private JTextField birthdayField;
    private JButton addButton;

    /**
     * Constructeur de la classe AddAdmin.
     */
    public AddAdmin() {
        setTitle("Ajouter Administrateur");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 5, 5));
        panel.setBackground(Color.decode("#2a2d43")); // Couleur de fond

        JLabel firstNameLabel = new JLabel("Prénom : ");
        firstNameLabel.setForeground(Color.WHITE); // Texte en blanc
        firstNameField = new BorderRadTextField(10);
        JLabel lastNameLabel = new JLabel("Nom : ");
        lastNameLabel.setForeground(Color.WHITE); // Texte en blanc
        lastNameField = new BorderRadTextField(10);
        JLabel mailLabel = new JLabel("E-mail : ");
        mailLabel.setForeground(Color.WHITE); // Texte en blanc
        mailField = new BorderRadTextField(10);
        JLabel pseudoLabel = new JLabel("Pseudo : ");
        pseudoLabel.setForeground(Color.WHITE); // Texte en blanc
        pseudoField = new BorderRadTextField(10);
        JLabel passwordLabel = new JLabel("Mot de passe : ");
        passwordLabel.setForeground(Color.WHITE); // Texte en blanc
        passwordField = new BorderRadPasswordField(10);
        JLabel birthdayLabel = new JLabel("Date de naissance : ");
        birthdayLabel.setForeground(Color.WHITE); // Texte en blanc
        birthdayField = new BorderRadTextField(10);
        addButton = new BorderRadButton("Ajouter",10);
        addButton.setBackground(Color.decode("#BCF4F5")); // Couleur de bouton
        addButton.setForeground(Color.BLACK); // Texte en noir

        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(mailLabel);
        panel.add(mailField);
        panel.add(pseudoLabel);
        panel.add(pseudoField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(birthdayLabel);
        panel.add(birthdayField);
        panel.add(addButton);

        add(panel);
    }

    /**
     * Renvoie le prénom de l'administrateur.
     *
     * @return Prénom de l'administrateur.
     */
    public String getFirstName() {
        return firstNameField.getText();
    }

    /**
     * Renvoie le nom de l'administrateur.
     *
     * @return Nom de l'administrateur.
     */
    public String getLastName() {
        return lastNameField.getText();
    }

    /**
     * Renvoie l'e-mail de l'administrateur.
     *
     * @return E-mail de l'administrateur.
     */
    public String getMail() {
        return mailField.getText();
    }

    /**
     * Renvoie le pseudo de l'administrateur.
     *
     * @return Pseudo de l'administrateur.
     */
    public String getPseudo() {
        return pseudoField.getText();
    }

    /**
     * Renvoie le mot de passe de l'administrateur.
     *
     * @return Mot de passe de l'administrateur.
     */
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    /**
     * Renvoie la date de naissance de l'administrateur.
     *
     * @return Date de naissance de l'administrateur.
     */
    public Date getBirthday() {
        // Convertir la date de naissance en format Date
        return Date.valueOf(birthdayField.getText());
    }

    /**
     * Ajoute un écouteur pour le bouton d'ajout d'administrateur.
     *
     * @param listener ActionListener pour le bouton d'ajout.
     */
    public void addAddAdminListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    /**
     * Affiche un message dans la fenêtre.
     *
     * @param message Message à afficher.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
