package View.SignInSignUp;

import javax.swing.*;
import java.awt.*;

import Controller.SignIn.ControllerSignIn;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadPanel;
import View.BorderRadCompenent.BorderRadPasswordField;
import View.BorderRadCompenent.BorderRadTextField;

/**
 * Vue pour la connexion.
 */
public class SignIn extends JPanel {
    private ControllerSignIn controller;

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton inviteButton;

    private ImageIcon image;

    /**
     * Constructeur de la classe SignIn.
     *
     * @param controller Le contrôleur pour la connexion
     */
    public SignIn(ControllerSignIn controller) {
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
        JLabel titleLabel = new JLabel("Connexion");
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

        JPanel cRow2 = new JPanel(new GridLayout(4, 1, 5, 2)); // Réduire le nombre de lignes
        cRow2.setOpaque(false);
        gbcCard.gridx = 0;
        gbcCard.gridy = 1;
        gbcCard.gridwidth = 1;
        gbcCard.weightx = 1;
        gbcCard.weighty = 0.8;

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setHorizontalAlignment(JLabel.CENTER);
        cRow2.add(emailLabel);

        emailField = new BorderRadTextField(10);
        emailField.setBackground(new Color(255, 255, 255, 150));
        emailField.setPreferredSize(new Dimension(200, 25));
        cRow2.add(emailField);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        cRow2.add(passwordLabel);

        passwordField = new BorderRadPasswordField(10);
        passwordField.setBackground(new Color(255, 255, 255, 150));
        passwordField.setPreferredSize(new Dimension(200, 25));
        cRow2.add(passwordField);

        cardPanel.add(cRow2, gbcCard);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout()); // Utiliser un GridBagLayout pour aligner les boutons
        buttonPanel.setOpaque(false);
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0;
        gbcButton.gridy = 0;
        gbcButton.weightx = 1;
        gbcButton.fill = GridBagConstraints.NONE;
        gbcButton.insets = new Insets(5, 0, 5, 0);

        loginButton = new BorderRadButton("Se connecter", 10);
        loginButton.setPreferredSize(new Dimension(200, 25));
        loginButton.setBackground(new Color(255, 255, 255, 150));
        buttonPanel.add(loginButton, gbcButton);

        signUpButton = new BorderRadButton("S'inscrire", 10);
        signUpButton.setPreferredSize(new Dimension(200, 25));
        signUpButton.setBackground(new Color(255, 255, 255, 150));
        gbcButton.gridy = 1;
        buttonPanel.add(signUpButton, gbcButton);

        inviteButton = new BorderRadButton("Continuer en invité", 10);
        inviteButton.setPreferredSize(new Dimension(200, 25));
        inviteButton.setBackground(new Color(255, 255, 255, 150));
        gbcButton.gridy = 2;
        buttonPanel.add(inviteButton, gbcButton);

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
