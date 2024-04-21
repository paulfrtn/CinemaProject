package Controller.AddSeance;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Salle.Salle;
import Model.Salle.SalleDaoImpl;
import Model.Seance.SeanceDaoImpl;
import View.PopUpMessage;
import Model.Seance.Seance;
import Model.Seance.SeanceDao;//
import View.AddSeance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerAddSeance implements ControllerAddSeanceInterface {
    private AddSeance view;
    private SeanceDaoImpl seanceDao;
    private FilmDaoImpl filmDao;

    public ControllerAddSeance(AddSeance view, SeanceDaoImpl seanceDao, FilmDaoImpl filmDao) {
        this.view = view;
        this.seanceDao = seanceDao;
        this.filmDao = filmDao;

        this.view.addAddListener(new AddListener());
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    public void addSeance() {
        String filmTitle = view.getFilmTitle();
        String dateStr = view.getDate();
        String timeStr = view.getTime();
        String language = view.getLanguage();
        int salleNumber = view.getSalleNumber(); // Récupérer le numéro de salle

        if (salleNumber == -1) {
            // Si le numéro de salle n'est pas valide, ne pas poursuivre l'ajout de la séance
            return;
        }

        if (!filmDao.filmExists(filmTitle)) {
            // Si le film n'existe pas dans la base de données, affiche un message d'erreur
            PopUpMessage.showErrorMessage("Le film spécifié n'existe pas dans la base de données !");
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

            // Vérifier si la séance existe déjà
            int existingSeance = seanceDao.getSeanceByCriteria(film.getFilm_id(), date, time, language, salle.getSalle_id());
            if (existingSeance != 0) {
                PopUpMessage.showErrorMessage("Cette séance existe déjà !");
                return;
            }



            Seance seance = new Seance( date, time, language, 0, film.getFilm_id(), salle.getSalle_id()); // Utiliser le numéro de salle
            seanceDao.addSeance(seance);
            PopUpMessage.showSuccessMessage("Séance ajoutée avec succès !");
            view.dispose();
        } catch (ParseException e) {
            PopUpMessage.showErrorMessage("Format de date ou d'heure invalide !");
        }
    }


    private class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addSeance();
        }
    }

    public static void main(String[] args) {
        // Création de l'instance du DAO
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        FilmDaoImpl filmDao = new FilmDaoImpl();

        // Création de l'instance de la vue
        AddSeance view = new AddSeance();

        // Création du contrôleur et démarrage
        ControllerAddSeance controller = new ControllerAddSeance(view, seanceDao, filmDao);
        controller.start();
    }
}

