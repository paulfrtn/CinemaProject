package View;

import javax.swing.*;
import Model.DataBase.ConnectionDb;
import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import View.HomeView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ConnectionDb dbConnection = new ConnectionDb();
                FilmDaoImpl filmDao = new FilmDaoImpl(dbConnection.getConnection());

                int filmLimit = 100; // Définissez le nombre de films à afficher dans chaque carousel

                List<Film> nowShowingFilms = filmDao.getNowShowingFilms(filmLimit);
                List<Film> premieresFilms = filmDao.getPremieresFilms(filmLimit);
                List<Film> comingSoonFilms = filmDao.getComingSoonFilms(filmLimit);

                new HomeView(nowShowingFilms, premieresFilms, comingSoonFilms, filmLimit);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unable to connect to the database.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
