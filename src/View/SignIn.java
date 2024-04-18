package View;

import Controller.SignIn.ControllerSignIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private ControllerSignIn controller;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton inviteButton;

    public SignIn(ControllerSignIn controller) {
        this.controller = controller;

        setBackground(Color.decode("#2a2d43"));

        // Création du panneau central
        JPanel centralPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(400, 600));
        centralPanel.setBackground(Color.decode("#7A82AB"));
        centralPanel.setLayout(new BorderLayout());

        // Création de la carte centrale
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(Color.decode("#7A82AB"));
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Création du titre
        JLabel titleLabel = new JLabel("Connexion");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(titleLabel);

        // Ajout d'un espace
        cardPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Création du formulaire
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.decode("#7A82AB"));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(200, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(200, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(passwordField);

        cardPanel.add(formPanel);

        // Ajout d'un espace
        cardPanel.add(Box.createVerticalStrut(50)); // Espace vertical

        // Bouton de connexion
        loginButton = new JButton("Se connecter");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(loginButton);

        // Ajout d'un espace
        cardPanel.add(Box.createVerticalStrut(10)); // Espace vertical

        // Bouton d'inscription
        signUpButton = new JButton("Pas encore membre ?");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(signUpButton);

        // Ajout d'un espace
        cardPanel.add(Box.createVerticalStrut(10)); // Espace vertical

        // Bouton d'invitation
        inviteButton = new JButton("Continuer en tant qu'invité");
        inviteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(inviteButton);

        // Ajout de la carte centrale au panneau central
        centralPanel.add(cardPanel, BorderLayout.CENTER);

        // Ajout du panneau central à la vue
        add(centralPanel, BorderLayout.CENTER);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getInviteButton() {
        return inviteButton;
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
