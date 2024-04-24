package Controller;

import Controller.Panier.ControllerPanier;
import Controller.ProfilPage.ControllerPageProfil;
import Controller.SignIn.ControllerSignIn;
import Controller.SignUp.ControllerSignUp;
import Controller.FilmSchedule.ControllerFilmSchedule;
import CustomExceptions.UserNotFoundException;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Offer.Offer;
import Model.Offer.OfferDaoImpl;
import Model.Salle.SalleDaoImpl;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import Model.Ticket.TicketDaoImpl;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.Accueil.Accueil;
import View.Accueil.JCarousel;
import View.Admin.AdminFilm;
import View.Admin.AdminOffer;
import View.Admin.AdminPrincipal;
import View.Admin.AdminUser;
import View.FilmNSeance.FilmNSchedulePage;
import View.Offres.OffersPage;
import View.PopUpMessage.PopUpMessage;
import View.ProfilPage.Stat;
import View.ProfilPage.ViewPageProfil;
import View.Reservation.InviteMail;
import View.Reservation.Paiement;
import View.Reservation.Panier;
import View.SignInSignUp.SignIn;
import View.SignInSignUp.SignUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private SeanceDaoImpl seanceDao;
    private FilmDaoImpl filmDao;
    private OfferDaoImpl offerDao;
    private OffersPage offersPage;
    private TicketDaoImpl ticketDao;
    private SalleDaoImpl salleDao;
    private UserDaoImpl userdao;
    private Paiement paiementPage;
    private ActionListener PaiementButtonListener;
    ControllerPageProfil ControllerProfil;


    public MainFrame() throws UserNotFoundException {

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

        userdao = new UserDaoImpl();
        filmDao = new FilmDaoImpl();
        offerDao = new OfferDaoImpl();
        seanceDao = new SeanceDaoImpl();
        ticketDao = new TicketDaoImpl();
        salleDao = new SalleDaoImpl();


        PopUpMessage PopUp = new PopUpMessage();
        //CurrentUser = userdao.getUserById(5);
        int filmLimit = 100;
        java.util.List<Film> nowShowingFilms = filmDao.getNowShowingFilms(filmLimit);
        java.util.List<Film> premieresFilms = filmDao.getPremieresFilms(filmLimit);
        List<Film> comingSoonFilms = filmDao.getComingSoonFilms(filmLimit);

        ///////////////////////////CONFIGURATION DES PAGES///////////////////////////

        ViewPageProfil viewPageProfil = new ViewPageProfil();
        ControllerProfil = new ControllerPageProfil(viewPageProfil, userdao, ticketDao, seanceDao, filmDao, salleDao);
        ControllerSignUp controllerSignUp = new ControllerSignUp();
        ControllerSignIn controllerSignIn = new ControllerSignIn();
        ControllerPanier controllerPanier = new ControllerPanier();
        ControllerFilmSchedule controller = new ControllerFilmSchedule();
        SignUp signUpPanel = new SignUp(controllerSignUp);
        SignIn signInPanel = new SignIn(controllerSignIn);
        AdminPrincipal adminPrincipal = new AdminPrincipal();
        Accueil accueilPanel = new Accueil(this, nowShowingFilms, premieresFilms, comingSoonFilms, filmLimit);
        JCarousel jCarousel = new JCarousel(this, "Now Showing", nowShowingFilms);
        /////////////////////////////////////////////////////////////////////////////


        ///////////////////////////AJOUT DES PAGES///////////////////////////
        cardsPanel.add(signUpPanel, "signUpPanel");
        cardsPanel.add(signInPanel, "SignInPanel");
        cardsPanel.add(accueilPanel, "Accueil");
        cardsPanel.add(adminPrincipal, "AdminPrincipal");
        cardsPanel.add(viewPageProfil, "ProfilePage");
        /////////////////////////////////////////////////////////////////////


        cardLayout.show(cardsPanel, "SignInPanel");

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
                Film film = filmDao.getFilmByTitle(searchText.trim());
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
                Panier panierPanel = new Panier(MainFrame.this, controllerPanier, CurrentSeanceId, CurrentUser);
                cardsPanel.add(panierPanel, "Panier");
                cardLayout.show(cardsPanel, "Panier");


                panierPanel.getValiderButton().addActionListener(new ActionListener() {


                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int quantity = panierPanel.getNumberOfTickets();
                        int price = panierPanel.getPrice();
                        int offerId = panierPanel.getOfferId();


                        if (quantity > 0) {
                            if (panierPanel.getValiderPaiement()) {
                                if (CurrentUser != null) {
                                    controllerPanier.addPanier(CurrentSeanceId, CurrentUser.getUser_id(), offerId, price, true, quantity, CurrentUser.getUser_mail());
                                    PopUp.showSuccessMessage("Votre réservation a été effectuée avec succès");
                                    cardLayout.show(cardsPanel, "Accueil");
                                } else {
                                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(MainFrame.this);
                                    InviteMail inviteMail = new InviteMail(parentFrame, "Entrez votre adresse e-mail");
                                    if (!inviteMail.isCancelled()) {
                                        String email = inviteMail.getEmail();
                                        controllerPanier.addPanier(CurrentSeanceId, 18, offerId, price, true, quantity, email);
                                        PopUp.showSuccessMessage("Votre réservation a été effectuée avec succès");
                                        cardLayout.show(cardsPanel, "Accueil");
                                    }
                                }
                            }

                        }
                    }

                });

                panierPanel.getBtnBack().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "FilmNSchedulePage");
                    }
                });

                panierPanel.getBtnProfile().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (CurrentUser != null) {
                            if (CurrentUser.getUser_role()) {
                                cardLayout.show(cardsPanel, "AdminPrincipal");
                            } else {
                                cardLayout.show(cardsPanel, "ProfilPage");

                            }
                        }
                        if (CurrentUser == null) {
                            cardLayout.show(cardsPanel, "SignInPanel");
                        }
                    }
                });
                panierPanel.getBtnFilm().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "Accueil");
                    }
                });

            }
        };
        FilmButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel filmPanel = (JPanel) e.getSource();

                CurrentFilmId = Integer.parseInt(filmPanel.getName());
                film = filmDao.getFilmById(CurrentFilmId);
                String film_title = film.getFilm_title();
                String film_director = film.getFilm_director();
                String film_genre = film.getFilm_genre();
                int film_duration = film.getFilm_duration();
                String film_synopsis = film.getFilm_synopsis();
                Date film_release_date = film.getFilm_release_date();
                Boolean film_status = film.getFilm_status();
                String film_poster = film.getFilm_poster();
                seanceDao = new SeanceDaoImpl();

                filmNSchedulePage = new FilmNSchedulePage(MainFrame.this, CurrentFilmId, film_title, film_director, film_genre, film_duration, film_synopsis, film_release_date, film_status, film_poster);
                cardsPanel.add(filmNSchedulePage, "FilmNSchedulePage");
                cardLayout.show(cardsPanel, "FilmNSchedulePage");

                filmNSchedulePage.buttonListeners(SeanceButtonListener);

                filmNSchedulePage.getBackButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "Accueil");
                    }
                });

                filmNSchedulePage.getProfil().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (CurrentUser != null) {
                            if (CurrentUser.getUser_role()) {
                                cardLayout.show(cardsPanel, "AdminPrincipal");
                            } else {
                                try {
                                    ControllerProfil.displayUser(CurrentUser.getUser_id());
                                } catch (UserNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }
                                cardLayout.show(cardsPanel, "ProfilePage");
                            }
                        }
                        if (CurrentUser == null) {
                            cardLayout.show(cardsPanel, "SignInPanel");
                        }
                    }
                });


            }

        };


        accueilPanel.getbtnOffers().addActionListener(e -> {
            if (CurrentUser != null) {
                offersPage = new OffersPage(CurrentUser.getUser_type());
                cardsPanel.add(offersPage, "OffersPage");
                cardLayout.show(cardsPanel, "OffersPage");
            } else {
                offersPage = new OffersPage(-1);
                cardsPanel.add(offersPage, "OffersPage");
                cardLayout.show(cardsPanel, "OffersPage");

                offersPage.getProfile().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (CurrentUser != null) {
                            if (CurrentUser.getUser_role()) {
                                cardLayout.show(cardsPanel, "AdminPrincipal");
                            } else {
                                cardLayout.show(cardsPanel, "ProfilePage");

                            }
                        }
                        if (CurrentUser == null) {
                            cardLayout.show(cardsPanel, "SignInPanel");
                        }

                    }
                });
            }
        });

        accueilPanel.getbtnProfile().addActionListener(e -> {
            if (CurrentUser != null) {
                if (CurrentUser.getUser_role()) {
                    cardLayout.show(cardsPanel, "AdminPrincipal");
                } else {
                    try {
                        ControllerProfil.displayUser(CurrentUser.getUser_id());
                    } catch (UserNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    cardLayout.show(cardsPanel, "ProfilePage");

                }
            }
            if (CurrentUser == null) {
                cardLayout.show(cardsPanel, "SignInPanel");
            }
        });


        viewPageProfil.getRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "Accueil");
            }
        });

        viewPageProfil.getStatistiques().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stat stat = new Stat("Film Durations and Reservations", CurrentUser.getUser_id());
                stat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                stat.setSize(1200, 800);
                stat.setResizable(false);
                stat.setLocationRelativeTo(null);
                stat.setVisible(true);
            }
        });

        viewPageProfil.getLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentUser = null;
                cardLayout.show(cardsPanel, "SignInPanel");
            }
        });
        ////////////////////////ADMIN///////////////////////////////

        adminPrincipal.getBtnFilms().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardsPanel, "Accueil");
            }

        });


        adminPrincipal.getGestionFilm().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Film> films = filmDao.getAllFilms();
                List<Seance> seances =  seanceDao.getAllSeances();
                AdminFilm adminFilm = new AdminFilm(films, seances);
                cardsPanel.add(adminFilm, "AdminFilm");
                cardLayout.show(cardsPanel, "AdminFilm");


                adminFilm.getBtnBack().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "AdminPrincipal");
                    }
                });

                adminFilm.getBtnFilms().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "Accueil");
                    }
                });

                adminFilm.getBtnLogOut().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CurrentUser = null;
                        cardLayout.show(cardsPanel, "SignInPanel");
                    }
                });

            }
        });

        adminPrincipal.getGestionOffre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Offer> offers = offerDao.getAllOffers();
                AdminOffer adminOffer = new AdminOffer(offers, CurrentUser.getUser_id());
                cardsPanel.add(adminOffer, "AdminOffer");
                cardLayout.show(cardsPanel, "AdminOffer");

                adminOffer.getBtnBack().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "AdminPrincipal");
                    }
                });

                adminOffer.getBtnFilms().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "Accueil");
                    }
                });

                adminOffer.getbtnLogOut().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CurrentUser = null;
                        cardLayout.show(cardsPanel, "SignInPanel");
                    }
                });

            }
        });

        adminPrincipal.getGestionUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> users = userdao.getAllUsers();
                AdminUser adminUser = new AdminUser(users);
                cardsPanel.add(adminUser, "AdminUser");
                cardLayout.show(cardsPanel, "AdminUser");

                adminUser.getBtnBack().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "AdminPrincipal");
                    }
                });

                adminUser.getBtnFilms().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardsPanel, "Accueil");
                    }
                });

                adminUser.getBtnLogOut().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CurrentUser = null;
                        cardLayout.show(cardsPanel, "SignInPanel");
                    }
                });

            }
        });

        adminPrincipal.getBtnLogOut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentUser = null;
                cardLayout.show(cardsPanel, "SignInPanel");
            }
        });


    }

    public ActionListener getSeanceButtonListener() {
        return SeanceButtonListener;
    }

    public ActionListener getFilmButtonListener() {
        return FilmButtonListener;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (UserNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void showAccueilView() {
        cardLayout.show(cardsPanel, "Accueil");
    }
}


