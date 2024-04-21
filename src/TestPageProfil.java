import Controller.ProfilPage.ControllerPageProfil;
import CustomExceptions.UserNotFoundException;
import Model.User.UserDaoImpl;
import Model.Ticket.TicketDaoImpl;
import Model.Seance.SeanceDaoImpl;
import Model.Film.*;
import Model.Salle.*;
import View.ProfilPage.ViewPageProfil;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestPageProfil {
    public static void main(String[] args) {
        // Créer une JFrame pour contenir le panneau
        JFrame frame = new JFrame("Test Page Profil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Créer une instance de ViewPageProfil (qui étend JPanel)
        ViewPageProfil view = new ViewPageProfil();

        // Créer les instances des modèles nécessaires
        UserDaoImpl modeluser = new UserDaoImpl();
        TicketDaoImpl modelticket = new TicketDaoImpl();
        SeanceDaoImpl modelseance = new SeanceDaoImpl();
        FilmDaoImpl modelfilm = new FilmDaoImpl();
        SalleDaoImpl modelsalle = new SalleDaoImpl();

        // Créer une instance du contrôleur avec le panneau et les modèles
        ControllerPageProfil controller = new ControllerPageProfil(view, modeluser, modelticket, modelseance, modelfilm, modelsalle);

        // Ajouter le panneau à la JFrame
        frame.add(view);


        // Rendre la JFrame visible
        frame.setSize(1200, 800);
        frame.setVisible(true);

        int userId = 2; // ID de l'utilisateur à afficher

        try {
            // Appeler la méthode du contrôleur pour afficher l'utilisateur
            controller.displayUser(userId);
        } catch (UserNotFoundException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}

