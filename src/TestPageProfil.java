import Controller.ProfilPage.ControllerPageProfil;
import CustomExceptions.UserNotFoundException;
import Model.User.UserDaoImpl;
import Model.Ticket.TicketDaoImpl;
import Model.Seance.SeanceDaoImpl;
import Model.Film.*;
import Model.Salle.*;
import View.ProfilPage.ViewPageProfil;
import java.util.*;

public class TestPageProfil{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ViewPageProfil view = new ViewPageProfil();
        UserDaoImpl modeluser = new UserDaoImpl();
        TicketDaoImpl modelticket = new TicketDaoImpl();
        SeanceDaoImpl modelseance = new SeanceDaoImpl();
        FilmDaoImpl modelfilm = new FilmDaoImpl();
        SalleDaoImpl modelsalle = new SalleDaoImpl();
        ControllerPageProfil controller = new ControllerPageProfil(view, modeluser, modelticket, modelseance, modelfilm, modelsalle);
        int userId;
        userId = 2;

        try{
            controller.displayUser(userId);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
