package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Controller.SignUp.ControllerSignUp;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadPanel;
import View.BorderRadCompenent.BorderRadPasswordField;
import View.BorderRadCompenent.BorderRadTextField;

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

        setLayout(new BorderLayout());

        // Charger l'image de fond
        Image backgroundImage = new ImageIcon("src/Model/Images/SignInUp/Background.jpg").getImage();

        JPanel FirstPanel = new BorderRadPanel(10) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, this);
            }
        };

        JPanel centralPanel = new BorderRadPanel(10);
        centralPanel.setPreferredSize(new Dimension(400, 600));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        centralPanel.setBackground(Color.decode("#000000"));

        JLabel title = new JLabel("Inscription");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.decode("#FFFFFF"));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.decode("#000000"));
        titlePanel.add(title, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(12, 1, 5, 10));
        formPanel.setBackground(Color.decode("#000000"));

        String[] labels = {"Prénom:", "Nom de famille:", "E-mail:", "Pseudo:", "Mot de passe:", "Date de naissance (YYYY-MM-DD):"};
        for (String label : labels) {
            JLabel formLabel = new JLabel(label);
            formLabel.setForeground(Color.WHITE);
            JTextField formField;

            if (label.equals("Mot de passe:")) {
                formField = new BorderRadPasswordField(10);
                formField.setPreferredSize(new Dimension(200, 25));
                formField.setBorder(null);
            } else {
                formField = new BorderRadTextField(10);
                formField.setPreferredSize(new Dimension(200, 20));
                formField.setBorder(null);
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

        signUpButton = new BorderRadButton("S'inscrire",15); // Initialisation du bouton d'inscription
        alreadyMemberButton = new BorderRadButton("Déjà membre ?",15);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.decode("#000000"));
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setBackground(Color.decode("#FDF0D5"));
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

        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(titlePanel, BorderLayout.NORTH);
        centralPanel.add(formPanel, BorderLayout.CENTER);
        centralPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(centralPanel, BorderLayout.CENTER);

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
