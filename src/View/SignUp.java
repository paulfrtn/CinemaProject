package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Controller.SignUp.ControllerSignUp;

public class SignUp extends JPanel {
    private ControllerSignUp controller;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField pseudoField;
    private JPasswordField passwordField;
    private JTextField birthdayField;
    private JButton signUpButton; // Ajout du champ pour le bouton d'inscription
    private JButton alreadyMemberButton;

    public SignUp(ControllerSignUp controller) {
        this.controller = controller;

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
            JTextField formField;
            if (label.equals("Mot de passe:")) {
                formField = new JPasswordField();
            } else {
                formField = new JTextField();
            }
            formPanel.add(formLabel);
            formPanel.add(formField);

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
                    passwordField = (JPasswordField) formField;
                    break;
                case "Date de naissance (YYYY-MM-DD):":
                    birthdayField = formField;
                    break;
            }
        }

        signUpButton = new JButton("S'inscrire"); // Initialisation du bouton d'inscription
        alreadyMemberButton = new JButton("Déjà membre ?");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.decode("#7A82AB"));
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(signUpButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        alreadyMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(alreadyMemberButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(titlePanel, BorderLayout.NORTH);
        centralPanel.add(formPanel, BorderLayout.CENTER);
        centralPanel.add(buttonPanel, BorderLayout.SOUTH);

        int vgap = 20;
        formPanel.setBorder(new EmptyBorder(0, 0, vgap, 0));

        centralPanel.setBorder(new EmptyBorder(vgap, 0, vgap, 0));

        add(centralPanel);

    }

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
        return new String(passwordField.getPassword());
    }

    public String getBirthday() {
        return birthdayField.getText();
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getalreadyMemberButton() {
        return alreadyMemberButton;
    }
}
