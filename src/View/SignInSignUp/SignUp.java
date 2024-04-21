package View.SignInSignUp;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

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

    private ImageIcon image;

    public SignUp(ControllerSignUp controller) {
        this.controller = controller;

        setLayout(new BorderLayout());

        // Charger l'image depuis le fichier
        image = new ImageIcon("src/Model/Images/SignInUp/Background.jpg");

        JLabel bgLabel = new JLabel(image);
        bgLabel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel row1 = new JPanel(new BorderLayout());
        row1.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.01;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.BOTH;
        bgLabel.add(row1, gbc);

        JPanel row2 = new JPanel(new BorderLayout());
        row2.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel cardPanel = new BorderRadPanel(new GridBagLayout(), 10);
        cardPanel.setBackground(new Color(255, 255, 255, 51));
        cardPanel.setLayout(new GridBagLayout());
        cardPanel.setPreferredSize(new Dimension(400, 600));
        GridBagConstraints gbcCard = new GridBagConstraints();
        gbcCard.insets = new Insets(20, 20, 20, 20);
        gbcCard.fill = GridBagConstraints.HORIZONTAL;

        JPanel cRow1 = new JPanel(new BorderLayout());
        cRow1.setOpaque(false);
        JLabel titleLabel = new JLabel("Inscription");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        cRow1.add(titleLabel, BorderLayout.CENTER);
        gbcCard.gridx = 0;
        gbcCard.gridy = 0;
        gbcCard.gridwidth = 1;
        gbcCard.weightx = 1;
        gbcCard.weighty = 0.2;
        cardPanel.add(cRow1, gbcCard);

        JPanel cRow2 = new JPanel(new GridLayout(14, 1, 5, 2));
        cRow2.setOpaque(false);
        String[] labels = {"Prénom:", "Nom de famille:", "E-mail:", "Pseudo:", "Mot de passe:", "Date de naissance (YYYY-MM-DD):"};
        for (String label : labels) {
            JLabel formLabel = new JLabel(label);
            formLabel.setForeground(Color.WHITE);
            JTextField formField;

            if (label.equals("Mot de passe:")) {
                formField = new BorderRadPasswordField(10);
                formField.setPreferredSize(new Dimension(200, 25));
                formField.setBackground(new Color(255, 255, 255, 150));
                formField.setBorder(new LineBorder(Color.decode("#000000")));
            } else {
                formField = new BorderRadTextField(10);
                formField.setPreferredSize(new Dimension(200, 20));
                formField.setBackground(new Color(255, 255, 255, 150));
                formField.setBorder(null);
            }
            cRow2.add(formLabel);
            cRow2.add(formField);

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
        gbcCard.gridx = 0;
        gbcCard.gridy = 1;
        gbcCard.gridwidth = 1;
        gbcCard.weightx = 1;
        gbcCard.weighty = 0.8;
        cardPanel.add(cRow2, gbcCard);

        signUpButton = new BorderRadButton("S'inscrire", 10);
        alreadyMemberButton = new BorderRadButton("Déjà membre ?", 10);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setBackground(new Color(255, 255, 255, 150));
        buttonPanel.add(signUpButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        alreadyMemberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        alreadyMemberButton.setBackground(new Color(255, 255, 255, 150));
        buttonPanel.add(alreadyMemberButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gbcCard.gridx = 0;
        gbcCard.gridy = 2;
        gbcCard.gridwidth = 1;
        gbcCard.weightx = 1;
        gbcCard.weighty = 0.2;
        cardPanel.add(buttonPanel, gbcCard);

        row2.add(cardPanel, BorderLayout.CENTER);
        bgLabel.add(row2, gbc);

        JPanel row3 = new JPanel(new BorderLayout());
        row3.setBackground(Color.decode("#FFFFFF"));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.19;
        gbc.insets = new Insets(3, 3, 3, 3);
        bgLabel.add(row3, gbc);

        add(bgLabel, BorderLayout.CENTER);
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
        System.out.println(birthdayField.getText());
        return birthdayField.getText();
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getalreadyMemberButton() {
        return alreadyMemberButton;
    }

}
