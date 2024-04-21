package Controller.AddSeance;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Salle.Salle;
import Model.Salle.SalleDaoImpl;
import Model.Seance.SeanceDaoImpl;
import View.PopUpMessage;
import Model.Seance.Seance;
import Model.Seance.SeanceDao;
import View.AddSeance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contrôleur pour l'ajout de séances de films dans l'application.
 * Gère les interactions entre la vue d'ajout de séances et le modèle de données.
 */
public class ControllerAddSeance implements ControllerAddSeanceInterface {
    private AddSeance view;
    private SeanceDaoImpl seanceDao;
    private FilmDaoImpl filmDao;

    /**
     * Constructeur qui initialise le contrôleur avec les objets de la vue et des DAO nécessaires.
     * @param view L'interface utilisateur pour ajouter des séances.
     * @param seanceDao Le DAO pour gérer les opérations sur les séances.
     * @param filmDao Le DAO pour gérer les opérations sur les films.
     */
    public ControllerAddSeance(AddSeance view, SeanceDaoImpl seanceDao, FilmDaoImpl filmDao) {
        this.view = view;
        this.seanceDao = seanceDao;
        this.filmDao = filmDao;
        this.view.addAddListener(new AddListener());
    }

    /**
     * Lance et affiche la vue dans le thread de l'interface graphique.
     */
    public void start() {
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    /**
     * Méthode pour ajouter une nouvelle séance en récupérant les informations de la vue,
     * en validant ces informations, et en les utilisant pour créer et enregistrer une nouvelle séance.
     */
    public void addSeance() {
        String filmTitle = view.getFilmTitle();
        String dateStr = view.getDate();
        String timeStr = view.getTime();
        String language = view.getLanguage();
        int salleNumber = view.getSalleNumber(); // Récupérer le numéro de salle

        if (salleNumber == -1) {
            PopUpMessage.showErrorMessage("Numéro de salle non valide.");
            return;
        }

        if (!filmDao.filmExists(filmTitle)) {
            PopUpMessage.showErrorMessage("Le film spécifié n'existe pas dans la base de données.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            java.util.Date utilDate = dateFormat.parse(dateStr);
            java.sql.Date date = new java.sql.Date(utilDate.getTime());
            Time time = new Time(timeFormat.parse(timeStr).getTime());

            Film film = filmDao.getFilmByTitle(filmTitle);
            SalleDaoImpl salleDao = new SalleDaoImpl();
            Salle salle = salleDao.getSalleByNumber(salleNumber);

            int existingSeance = seanceDao.getSeanceByCriteria(film.getFilm_id(), date, time, language, salle.getSalle_id());
            if (existingSeance != 0) {
                PopUpMessage.showErrorMessage("Cette séance existe déjà.");
                return;
            }

            Seance seance = new Seance(date, time, language, 0, film.getFilm_id(), salle.getSalle_id()); // Utiliser le numéro de salle
            seanceDao.addSeance(seance);
            PopUpMessage.showSuccessMessage("Séance ajoutée avec succès.");
            view.dispose();
        } catch (ParseException e) {
            PopUpMessage.showErrorMessage("Format de date ou d'heure invalide.");
        }
    }

    /**
     * Classe interne pour écouter les actions sur le bouton d'ajout de séance.
     */
    private class AddListener implements ActionListener {
        /**
         * Déclenche la méthode addSeance lors du clic sur le bouton.
         * @param e L'événement qui indique que l'action a été effectuée.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            addSeance();
        }
    }

    public static void main(String[] args) {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        FilmDaoImpl filmDao = new FilmDaoImpl();
        AddSeance view = new AddSeance();
        ControllerAddSeance controller = new ControllerAddSeance(view, seanceDao, filmDao);
        controller.start();
    }
}
