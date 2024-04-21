package Controller;

import Controller.Panier.ControllerPanier;
import Controller.SignIn.ControllerSignIn;
import Controller.SignUp.ControllerSignUp;
import Controller.FilmSchedule.ControllerFilmSchedule;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.SeanceDaoImpl;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.*;
import View.Accueil.Accueil;
import View.Accueil.JCarousel;
import View.FilmNSeance.FilmNSchedulePage;
import View.Offres.OffersPage;
import View.Reservation.Paiement;
import View.Reservation.Panier;
import View.SignInSignUp.SignIn;
import View.SignInSignUp.SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardsPanel;
    private User CurrentUser;
    private int CurrentFilmId;
    private int CurrentSeanceId;
    private ActionListener SeanceButtonListener;
    private ActionListener FilmButtonListener;
    private FilmNSchedulePage filmNSchedulePage;
    private Film film;
    private FilmDaoImpl filmDao;
    private OffersPage offersPage;
    private Paiement paiementPage;
    private ActionListener PaiementButtonListener;


    public MainFrame() {

        ///////////////////////////CONFIGURATION DE LA FENETRE ///////////////////////////
        setTitle("Cinema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        // Création du conteneur principal avec CardLayout
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);
        getContentPane().add(cardsPanel, BorderLayout.CENTER);
        /////////////////////////////////////////////////////////////////////////////////

        UserDaoImpl userdao = new UserDaoImpl();
        filmDao = new FilmDaoImpl();
        PopUpMessage popUP = new PopUpMessage();
        CurrentUser = userdao.getUserById(1);
        int filmLimit = 100;
        java.util.List<Film> nowShowingFilms = filmDao.getNowShowingFilms(filmLimit);
        java.util.List<Film> premieresFilms = filmDao.getPremieresFilms(filmLimit);
        List<Film> comingSoonFilms = filmDao.getComingSoonFilms(filmLimit);

        ///////////////////////////CONFIGURATION DES PAGES///////////////////////////
        ControllerSignUp controllerSignUp = new ControllerSignUp();
        ControllerSignIn controllerSignIn = new ControllerSignIn();
        ControllerPanier controllerPanier = new ControllerPanier();
        ControllerFilmSchedule controller = new ControllerFilmSchedule();
        SignUp signUpPanel = new SignUp(controllerSignUp);
        SignIn signInPanel = new SignIn(controllerSignIn);
        Accueil accueilPanel = new Accueil(this, nowShowingFilms, premieresFilms, comingSoonFilms, filmLimit);
        FauxAccueil fauxAccueil = new FauxAccueil();
        JCarousel jCarousel = new JCarousel(this, "Now Showing", nowShowingFilms);
        /////////////////////////////////////////////////////////////////////////////


        ///////////////////////////AJOUT DES PAGES///////////////////////////
        cardsPanel.add(signUpPanel, "signUpPanel");
        cardsPanel.add(signInPanel, "SignInPanel");
        cardsPanel.add(accueilPanel, "Accueil");
        /////////////////////////////////////////////////////////////////////

        //Fausses pages pour les tests
        cardsPanel.add(fauxAccueil, "FauxAccueil");


        //cardLayout.show(cardsPanel, "SignInPanel");
        cardLayout.show(cardsPanel, "Accueil");


        signUpPanel.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = signUpPanel.getFirstName();
                String lastName = signUpPanel.getLastName();
                String email = signUpPanel.getEmail();
                String pseudo = signUpPanel.getPseudo();
                String password = signUpPanel.getPassword();
                String birthday = signUpPanel.getBirthday();
                System.out.println("Birthday : " + birthday);

                boolean success = controllerSignUp.onSignUp(firstName, lastName, email, pseudo, password, birthday);
                if (success) {
                    cardLayout.show(cardsPanel, "SignInPanel");
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
                    CurrentUser = userdao.getUserByMail(email);
                    cardLayout.show(cardsPanel, "Accueil");
                }

            }
        });

        signInPanel.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "signUpPanel");
            }
        });

        signInPanel.getInviteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentUser = null;
                cardLayout.show(cardsPanel, "Accueil");
            }
        });


        accueilPanel.getbtnSearch().addActionListener(e -> {
            String searchText = JOptionPane.showInputDialog(this, "Entrez le titre du film à rechercher:");

            if (searchText != null && !searchText.trim().isEmpty()) {
                filmDao = new FilmDaoImpl();
                Film film2 = filmDao.getFilmByTitle(searchText.trim());
                if (film != null) {
                    JOptionPane.showMessageDialog(this, "Film trouvé : " + film.getFilm_title() +
                            "\nRéalisateur: " + film.getFilm_director() +
                            "\nGenre: " + film.getFilm_genre(), "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun film trouvé avec ce titre.", "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La recherche ne peut être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        SeanceButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                CurrentSeanceId = Integer.parseInt(button.getName());
                Panier panierPanel = new Panier(MainFrame.this, controllerPanier, CurrentSeanceId);
                cardsPanel.add(panierPanel, "Panier");
                cardLayout.show(cardsPanel, "Panier");


                panierPanel.getValiderButton().addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int quantity = panierPanel.getNumberOfTickets();
                        int price = panierPanel.getPrice();
                        int offerId = panierPanel.getOfferId();


                        if(quantity>0) {
                            if (CurrentUser != null) {

                                controllerPanier.addPanier(CurrentSeanceId, CurrentUser.getUser_id(), offerId, price, true, quantity, CurrentUser.getUser_mail());
                                popUP.showSuccessMessage("T'as réussi" + CurrentUser.getUser_firstname());
                            }
                        }
                    }
                });


            }
        };
        FilmButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel filmPanel = (JPanel) e.getSource();

                CurrentFilmId = Integer.parseInt(filmPanel.getName());
                System.out.println("CurrentFilmId : " + CurrentFilmId);
                film = filmDao.getFilmById(CurrentFilmId);
                String film_title = film.getFilm_title();
                String film_director = film.getFilm_director();
                String film_genre = film.getFilm_genre();
                int film_duration = film.getFilm_duration();
                String film_synopsis = film.getFilm_synopsis();
                Date film_release_date = film.getFilm_release_date();
                Boolean film_status = film.getFilm_status();
                String film_poster = film.getFilm_poster();
                SeanceDaoImpl seanceDao = new SeanceDaoImpl();

                filmNSchedulePage = new FilmNSchedulePage(MainFrame.this, CurrentFilmId, film_title, film_director, film_genre, film_duration, film_synopsis, film_release_date, film_status, film_poster);
                cardsPanel.add(filmNSchedulePage, "FilmNSchedulePage");
                cardLayout.show(cardsPanel, "FilmNSchedulePage");

                filmNSchedulePage.getButtonProfil().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "FauxAccueil");
                    }
                });
                filmNSchedulePage.buttonListeners(SeanceButtonListener);
            }

        };


        accueilPanel.getbtnOffers().addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Offres");
            if (CurrentUser != null) {
                offersPage = new OffersPage(CurrentUser.getUser_type());
                cardsPanel.add(offersPage, "OffersPage");
                cardLayout.show(cardsPanel, "OffersPage");
            } else {
                offersPage = new OffersPage(-1);
                cardsPanel.add(offersPage, "OffersPage");
                cardLayout.show(cardsPanel, "OffersPage");
            }
        });


    }

    public ActionListener getSeanceButtonListener() {
        return SeanceButtonListener;
    }

    public ActionListener getFilmButtonListener() {
        return FilmButtonListener;
    }

    public ActionListener getPaiementButtonListener() {
        return PaiementButtonListener;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
