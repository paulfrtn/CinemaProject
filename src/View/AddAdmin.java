package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddAdmin extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField mailField;
    private JTextField pseudoField;
    private JPasswordField passwordField;
    private JTextField birthdayField;
    private JButton addButton;

    public AddAdmin() {
        setTitle("Ajouter Administrateur");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.setBackground(Color.decode("#2a2d43")); // Couleur de fond

        JLabel firstNameLabel = new JLabel("Prénom : ");
        firstNameLabel.setForeground(Color.WHITE); // Texte en blanc
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Nom : ");
        lastNameLabel.setForeground(Color.WHITE); // Texte en blanc
        lastNameField = new JTextField();
        JLabel mailLabel = new JLabel("E-mail : ");
        mailLabel.setForeground(Color.WHITE); // Texte en blanc
        mailField = new JTextField();
        JLabel pseudoLabel = new JLabel("Pseudo : ");
        pseudoLabel.setForeground(Color.WHITE); // Texte en blanc
        pseudoField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe : ");
        passwordLabel.setForeground(Color.WHITE); // Texte en blanc
        passwordField = new JPasswordField();
        JLabel birthdayLabel = new JLabel("Date de naissance : ");
        birthdayLabel.setForeground(Color.WHITE); // Texte en blanc
        birthdayField = new JTextField();
        addButton = new JButton("Ajouter");
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

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getMail() {
        return mailField.getText();
    }

    public String getPseudo() {
        return pseudoField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public Date getBirthday() {
        // Convertir la date de naissance en format Date
        return Date.valueOf(birthdayField.getText());
    }

    public void addAddAdminListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}



