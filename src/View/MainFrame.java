package View;

import Controller.SignIn.ControllerSignIn;
import Controller.SignUp.ControllerSignUp;
import Controller.ControllerFilmSchedule;
import View.TestPage.InvitePage;
import View.TestPage.SignInTest;
import View.TestPage.SignUp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardsPanel;

    public MainFrame() {
        setTitle("Cinema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Création du conteneur principal avec CardLayout
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        getContentPane().add(cardsPanel, BorderLayout.CENTER);

        // Création des différentes pages
        ControllerSignUp controllerSignUp = new ControllerSignUp();
        ControllerSignIn controllerSignIn = new ControllerSignIn();
        SignUp signUpPanel = new SignUp(controllerSignUp);
        SignUp2 signUp2Panel = new SignUp2();
        SignIn signInPanel = new SignIn(controllerSignIn);
        SignInTest signInTestPanel = new SignInTest();
        InvitePage invitePage = new InvitePage();

        ControllerFilmSchedule controller = new ControllerFilmSchedule();
        FilmNSchedulePage filmNSchedulePage = new FilmNSchedulePage(controller);


        // Ajout des pages au conteneur principal
        cardsPanel.add(filmNSchedulePage, "FilmNSchedulePage");
        cardsPanel.add(signUpPanel, "SignUpPanel");
        cardsPanel.add(signUp2Panel, "SignUp2Panel");
        cardsPanel.add(signInPanel, "SignInPanel");
        cardsPanel.add(signInTestPanel, "SignInTestPanel");
        cardsPanel.add(invitePage, "InvitePage");


        // Afficher la page Controller.SignUp au démarrage
        cardLayout.show(cardsPanel, "SignInPanel");
        //cardLayout.show(cardsPanel, "filmNSchedulePage");


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

                boolean success = controllerSignUp.onSignUp(firstName, lastName, email, pseudo, password, birthday);
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

        signInPanel.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = signInPanel.getEmail();
                String password = signInPanel.getPassword();


                boolean isAuthenticated = controllerSignIn.onSignIn(email, password);
                if (isAuthenticated) {
                    cardLayout.show(cardsPanel, "SignInTestPanel");
                }

            }
        });

        signInPanel.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "SignUpPanel");
            }
        });

        signInPanel.getInviteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "InvitePage");
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
