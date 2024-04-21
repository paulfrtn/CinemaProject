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
import Controller.ProfilPage.SeanceDetails;

public class ControllerPageProfil {
    private ViewPageProfil view;
    private UserDaoImpl modeluser;
    private TicketDaoImpl modelticket;
    private SeanceDaoImpl modelseance;
    private FilmDaoImpl modelfilm;
    private SalleDaoImpl modelsalle;

    public ControllerPageProfil(ViewPageProfil view, UserDaoImpl modeluser, TicketDaoImpl modelticket, SeanceDaoImpl modelseance, FilmDaoImpl modelfilm, SalleDaoImpl modelsalle) {
        this.view = view;
        this.modeluser = modeluser;
        this.modelticket = modelticket;
        this.modelseance = modelseance;
        this.modelfilm = modelfilm;
        this.modelsalle = modelsalle;
    }

    public void displayUser(int userId) throws UserNotFoundException{
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
