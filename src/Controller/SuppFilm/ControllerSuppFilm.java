package Controller.SuppFilm;


import Model.Film.Film;
import Model.Film.FilmDao;
import Model.Film.FilmDaoImpl;
import View.SuppFilm;
import View.PopUpMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSuppFilm implements ControllerSuppFilmInterface {
    private SuppFilm view;
    private FilmDao filmDao;

    public ControllerSuppFilm() {
        view = new SuppFilm();
        filmDao = new FilmDaoImpl();

        view.addDeleteListener(new DeleteListener());
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filmTitle = view.getFilmTitle();
            Film film = filmDao.getFilmByTitle(filmTitle);
            if (film != null) {
                filmDao.deleteFilm(film);
                PopUpMessage.showSuccessMessage("Le film a été supprimé avec succès !");
            } else {
                PopUpMessage.showErrorMessage("Le film n'existe pas dans la base de données.");
            }
        }
    }

    public static void main(String[] args) {
        ControllerSuppFilmInterface controller = new ControllerSuppFilm();
        controller.start();
    }
}

