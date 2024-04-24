package Controller.SuppFilm;

import Model.Film.Film;
import Model.Film.FilmDao;
import Model.Film.FilmDaoImpl;
import View.AddThings.SuppFilm;
import View.PopUpMessage.PopUpMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur pour la fonctionnalité de suppression d'un film.
 */
public class ControllerSuppFilm implements ControllerSuppFilmInterface {
    private SuppFilm view; // Vue pour la suppression de film
    private FilmDao filmDao; // DAO pour les films

    /**
     * Constructeur par défaut.
     */
    public ControllerSuppFilm() {
        view = new SuppFilm(); // Initialisation de la vue
        filmDao = new FilmDaoImpl(); // Initialisation du DAO des films

        // Ajout d'un écouteur pour le bouton de suppression dans la vue
        view.addDeleteListener(new DeleteListener());
    }

    /**
     * Lance la fonctionnalité de suppression de film.
     */
    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> view.setVisible(true)); // Affichage de la vue dans l'EDT
    }

    /**
     * Écouteur pour le bouton de suppression dans la vue.
     */
    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filmTitle = view.getFilmTitle(); // Obtention du titre du film à supprimer depuis la vue
            Film film = filmDao.getFilmByTitle(filmTitle); // Récupération du film à partir du titre
            if (film != null) {
                filmDao.deleteFilm(film); // Suppression du film de la base de données
                PopUpMessage.showSuccessMessage("Le film a été supprimé avec succès !"); // Affichage d'un message de succès
            } else {
                PopUpMessage.showErrorMessage("Le film n'existe pas dans la base de données."); // Affichage d'un message d'erreur si le film n'existe pas
            }
        }
    }

    /**
     * Méthode principale pour lancer le contrôleur.
     */
    public static void main(String[] args) {
        ControllerSuppFilmInterface controller = new ControllerSuppFilm(); // Création du contrôleur
        controller.start(); // Lancement de la fonctionnalité de suppression de film
    }
}
