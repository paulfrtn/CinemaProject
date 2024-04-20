package Controller;

import Controller.Panier.ControllerPanier;
import Controller.SignIn.ControllerSignIn;
import Controller.SignUp.ControllerSignUp;
import Controller.FilmSchedule.ControllerFilmSchedule;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.SeanceDaoImpl;
import View.*;
import View.TestPage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;


public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardsPanel;
    private int CurrentFilmId;
    private int CurrentSeanceId;
    private ActionListener SeanceButtonListener;

    public MainFrame() {

        ///////////////////////////CONFIGURATION DE LA FENETRE ///////////////////////////
        setTitle("Cinema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        // Création du conteneur principal avec CardLayout
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        getContentPane().add(cardsPanel, BorderLayout.CENTER);
        /////////////////////////////////////////////////////////////////////////////////


        CurrentFilmId=5;

        ///////////////////////////CONFIGURATION DES PAGES///////////////////////////
        ControllerSignUp controllerSignUp = new ControllerSignUp();
        ControllerSignIn controllerSignIn = new ControllerSignIn();
        ControllerPanier controllerPanier = new ControllerPanier();
        SignUp signUpPanel = new SignUp(controllerSignUp);
        SignUp2 signUp2Panel = new SignUp2();
        SignUp5 signUp5Panel = new SignUp5(controllerSignUp);
        SignIn signInPanel = new SignIn(controllerSignIn);
        SignInTest signInTestPanel = new SignInTest();
        InvitePage invitePage = new InvitePage();
        FauxAccueil fauxAccueil = new FauxAccueil();
        /////////////////////////////////////////////////////////////////////////////


        ///////////////////////////TEST///////////////////////////
        //Il faudra mettre cette partie dans un actionListener ensuite
        ControllerFilmSchedule controller = new ControllerFilmSchedule();
        FilmDaoImpl filmDao = new FilmDaoImpl();
        Film film = filmDao.getFilmById(CurrentFilmId);
        String film_title = film.getFilm_title();
        String film_director = film.getFilm_director();
        String film_genre = film.getFilm_genre();
        int film_duration = film.getFilm_duration();
        String film_synopsis = film.getFilm_synopsis();
        Date film_release_date = film.getFilm_release_date();
        Boolean film_status = film.getFilm_status();
        String film_poster = film.getFilm_poster();
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        FilmNSchedulePage filmNSchedulePage = new FilmNSchedulePage(this, CurrentFilmId, film_title, film_director, film_genre, film_duration, film_synopsis, film_release_date, film_status, film_poster);
        ///////////////////////////////////////////////////////////


        ///////////////////////////AJOUT DES PAGES///////////////////////////
        cardsPanel.add(filmNSchedulePage, "FilmNSchedulePage");
        cardsPanel.add(signUpPanel, "SignUpPanel");
        cardsPanel.add(signUp2Panel, "SignUp2Panel");
        cardsPanel.add(signUp5Panel, "SignUp5Panel");
        cardsPanel.add(signInPanel, "SignInPanel");
        /////////////////////////////////////////////////////////////////////

        //Fausses pages pour les tests
        cardsPanel.add(signInTestPanel, "SignInTestPanel");
        cardsPanel.add(invitePage, "InvitePage");
        cardsPanel.add(fauxAccueil, "FauxAccueil");



        // Afficher la page Controller.SignUp au démarrage
        //cardLayout.show(cardsPanel, "SignInPanel");
        //cardLayout.show(cardsPanel, "SignUp5Panel");
        cardLayout.show(cardsPanel, "filmNSchedulePage");



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

        filmNSchedulePage.getButtonProfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "FauxAccueil");
            }
        });

        SeanceButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                CurrentSeanceId = Integer.parseInt(button.getName());
                Panier panierPanel = new Panier(controllerPanier, CurrentSeanceId);
                cardsPanel.add(panierPanel, "Panier");
                cardLayout.show(cardsPanel, "Panier");
                System.out.println("CurrentSeanceId : " + CurrentSeanceId);
            }
        };
        filmNSchedulePage.buttonListeners(SeanceButtonListener);


    }

    public ActionListener getSeanceButtonListener() {
        return SeanceButtonListener;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
