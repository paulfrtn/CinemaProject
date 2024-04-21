package Controller.ProfilPage;

import Model.User.*;
import Model.Ticket.*;
import Model.Seance.*;
import Model.Film.*;
import Model.Salle.*;
import View.ProfilPage.ViewPageProfil;
import CustomExceptions.UserNotFoundException;
import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for handling user profile page interactions.
 * This class is responsible for fetching and displaying user and related session details on the profile page.
 */
public class ControllerPageProfil {
    private ViewPageProfil view;
    private UserDaoImpl modeluser;
    private TicketDaoImpl modelticket;
    private SeanceDaoImpl modelseance;
    private FilmDaoImpl modelfilm;
    private SalleDaoImpl modelsalle;

    /**
     * Constructs a profile page controller with necessary model and view components.
     * @param view The profile page view component.
     * @param modeluser The user model for accessing user data.
     * @param modelticket The ticket model for accessing ticket data.
     * @param modelseance The seance model for accessing session data.
     * @param modelfilm The film model for accessing film data.
     * @param modelsalle The salle model for accessing hall data.
     */
    public ControllerPageProfil(ViewPageProfil view, UserDaoImpl modeluser, TicketDaoImpl modelticket,
                                SeanceDaoImpl modelseance, FilmDaoImpl modelfilm, SalleDaoImpl modelsalle) {
        this.view = view;
        this.modeluser = modeluser;
        this.modelticket = modelticket;
        this.modelseance = modelseance;
        this.modelfilm = modelfilm;
        this.modelsalle = modelsalle;
    }

    /**
     * Displays user information in the profile view or throws an exception if the user is not found.
     * @param userId The ID of the user to display.
     * @throws UserNotFoundException if the user cannot be found in the database.
     */
    public void displayUser(int userId) throws UserNotFoundException {
        try {
            User user = modeluser.getUserById(userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            view.setUserProfile(user.getUser_firstname(), user.getUser_lastname(), user.getUser_mail(),
                    user.getUser_pseudo(), user.getUser_role(), user.getUser_birthday().toString(),
                    String.valueOf(user.getUser_type()));
            displaySeanceUser(userId);
        } catch (UserNotFoundException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    /**
     * Fetches and displays the seance details for the specified user.
     * This method gathers all the tickets for the user and compiles details about the seances they are attending.
     * @param userId The ID of the user whose seance details are to be displayed.
     */
    public void displaySeanceUser(int userId) {
        try {
            User user = modeluser.getUserById(userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }

            List<SeanceDetails> seanceDetails = new ArrayList<>();

            // Get the tickets for the user
            List<Ticket> tickets = modelticket.getTicketsByUserId(userId);

            // Populate the seanceDetails list
            for (Ticket ticket : tickets) {
                Seance seance = modelseance.getSeanceById(ticket.getSeance_id());
                Film film = modelfilm.getFilmById(seance.getFilm_id());

                SeanceDetails detail = new SeanceDetails(
                        film.getFilm_title(),
                        seance.getSeance_date(),
                        seance.getSeance_language(),
                        film.getFilm_poster()
                );
                seanceDetails.add(detail);
            }
            if(!seanceDetails.isEmpty()){
                view.DisplaySeances(seanceDetails);
            }
        } catch (UserNotFoundException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
