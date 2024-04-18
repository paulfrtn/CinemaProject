package View;

import Controller.SignUp.ControllerSignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardsPanel;

    public MainFrame() {
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Création du conteneur principal avec CardLayout
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        getContentPane().add(cardsPanel, BorderLayout.CENTER);

        // Création des différentes pages
        ControllerSignUp controller = new ControllerSignUp();
        SignUp signUpPanel = new SignUp(controller);
        SignUp2 signUp2Panel = new SignUp2();
        SignInTest signInPanel = new SignInTest();

        // Ajout des pages au conteneur principal
        cardsPanel.add(signUpPanel, "SignUpPanel");
        cardsPanel.add(signUp2Panel, "SignUp2Panel");
        cardsPanel.add(signInPanel, "SignInPanel");

        // Afficher la page Controller.SignUp au démarrage
        cardLayout.show(cardsPanel, "SignUpPanel");

        // ActionListener pour changer de page de Controller.SignUp à SignUp2
        signUpPanel.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = signUpPanel.getFirstName();
                String lastName = signUpPanel.getLastName();
                String email = signUpPanel.getEmail();
                String pseudo = signUpPanel.getPseudo();
                String password = signUpPanel.getPassword();
                String birthday = signUpPanel.getBirthday();

                boolean success = controller.onSignUp(firstName, lastName, email, pseudo, password, birthday);
                if (success) {
                    cardLayout.show(cardsPanel, "SignUp2Panel");
                }
            }
        });
        signUpPanel.getalreadyMemberButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "SignInPanel");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
