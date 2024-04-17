package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class SignUp extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField pseudoField;
    private JTextField passwordField;
    private JTextField birthdayField;

    public SignUp() {
        setBackground(Color.decode("#2a2d43"));

        JPanel centralPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(400, 600));
        centralPanel.setBackground(Color.decode("#7A82AB"));

        JLabel title = new JLabel("Inscription");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.decode("#FFFFFF"));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.decode("#7A82AB"));
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 60));
        formPanel.setBackground(Color.decode("#7A82AB"));

        String[] labels = {"Prénom:", "Nom de famille:", "E-mail:", "Pseudo:", "Mot de passe:", "Date de naissance (YYYY-MM-DD):"};
        for (String label : labels) {
            JLabel formLabel = new JLabel(label);
            formLabel.setForeground(Color.WHITE);
            JTextField formField = new JTextField();
            formPanel.add(formLabel);
            formPanel.add(formField);
            // Stockez les références aux champs dans les variables membres privées
            switch (label) {
                case "Prénom:":
                    firstNameField = formField;
                    break;
                case "Nom de famille:":
                    lastNameField = formField;
                    break;
                case "E-mail:":
                    emailField = formField;
                    break;
                case "Pseudo:":
                    pseudoField = formField;
                    break;
                case "Mot de passe:":
                    passwordField = formField;
                    break;
                case "Date de naissance (yyyy-MM-dd):":
                    birthdayField = formField;
                    break;
            }
        }

        JButton signUpButton = new JButton("S'inscrire");
        JButton alreadyMemberButton = new JButton("Déjà membre ?");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.decode("#7A82AB"));
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(signUpButton);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espace vertical entre les boutons
        alreadyMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(alreadyMemberButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(titlePanel, BorderLayout.NORTH);
        centralPanel.add(formPanel, BorderLayout.CENTER);
        centralPanel.add(buttonPanel, BorderLayout.SOUTH);

        int vgap = 20;
        formPanel.setBorder(new EmptyBorder(0, 0, vgap, 0)); // Ajout d'un espace en bas du formulaire

        centralPanel.setBorder(new EmptyBorder(vgap, 0, vgap, 0));

        add(centralPanel);
    }

    // Méthodes pour récupérer les valeurs des champs du formulaire
    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPseudo() {
        return pseudoField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getBirthday() {
        return birthdayField.getText();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        SignUp signUpPanel = new SignUp();
        frame.add(signUpPanel);
        frame.setVisible(true);

    }
}
