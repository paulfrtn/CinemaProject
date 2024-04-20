package View;

import javax.swing.*;
import java.awt.*;

import Controller.SignUp.ControllerSignUp;

public class SignUp5 extends JPanel {
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

    public SignUp5(ControllerSignUp controller) {
        this.controller = controller;

        setLayout(new BorderLayout());

        // Charger l'image depuis le fichier
        image = new ImageIcon("src/Model/Images/SignInUp/Background.jpg");

        // Créer un JLabel pour afficher l'image
        JLabel imageLabel = new JLabel(image);
        add(imageLabel, BorderLayout.CENTER);
    }

}
