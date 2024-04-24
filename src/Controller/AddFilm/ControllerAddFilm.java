package Controller.AddFilm;

import Model.Film.Film;
import Model.Film.FilmDao;
import Model.Film.FilmDaoImpl;
import View.AddThings.AddFilm;
import View.PopUpMessage.PopUpMessage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * Contrôleur pour la gestion de l'ajout de films dans l'application.
 * Fournit des méthodes pour interagir avec la vue et le modèle afin d'ajouter des films à la base de données.
 */
public class ControllerAddFilm {
    private AddFilm view;
    private FilmDao filmDao;

    /**
     * Constructeur pour ControllerAddFilm.
     *
     * @param view    L'interface utilisateur pour ajouter des films.
     * @param filmDao Le DAO pour interagir avec la base de données des films.
     */
    public ControllerAddFilm(AddFilm view, FilmDao filmDao) {
        this.view = view;
        this.filmDao = filmDao;
        this.view.addAddListener(new AddListener());
        this.view.addInsertPosterListener(new InsertPosterListener());
    }

    /**
     * Affiche la vue dans le thread de l'interface graphique.
     */
    public void start() {
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    /**
     * Gère l'ajout d'un film en récupérant les données depuis la vue et en les envoyant au modèle.
     * Affiche des messages d'erreur si les données sont invalides.
     */
    public void addFilm() {
        String title = view.getTitleField();
        String director = view.getDirectorField();
        String genre = view.getGenreField();
        String synopsis = view.getSynopsisArea();
        int duration = parseDuration(view.getDurationField());
        Date releaseDate = parseReleaseDate(view.getReleaseDateField());

        if (releaseDate == null || duration < 0 || view.getStatus() == 0) {
            return; // Error messages handled within parse methods and status check
        }

        String posterPath = managePosterPath(view.getPosterPath());

        // Création de l'objet Film et ajout à la base de données
        Film film = new Film(0, title, director, genre, duration, synopsis, releaseDate, true, posterPath);
        filmDao.addFilm(film);
        PopUpMessage.showSuccessMessage("Le film a été ajouté avec succès !");
        view.dispose();
    }

    private int parseDuration(String durationField) {
        try {
            return Integer.parseInt(durationField);
        } catch (NumberFormatException e) {
            PopUpMessage.showErrorMessage("Veuillez saisir une durée valide.");
            return -1;
        }
    }

    private Date parseReleaseDate(String releaseDateField) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(releaseDateField);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            PopUpMessage.showErrorMessage("Format de date invalide. Utilisez le format yyyy-MM-dd.");
            return null;
        }
    }

    private String managePosterPath(String posterPath) {
        return "src/Images/" + posterPath;
    }

    /**
     * Classe interne pour écouter les actions sur le bouton d'ajout de film.
     */
    private class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addFilm();
        }
    }

    /**
     * Classe interne pour écouter les actions sur le bouton d'insertion de poster.
     */
    private class InsertPosterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg"));
            if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                movePosterImage(selectedFile);
            }
        }

        private void movePosterImage(File selectedFile) {
            try {
                String imagesFolderPath = new File("src/Model/Images").getAbsolutePath();
                Files.copy(selectedFile.toPath(), Paths.get(imagesFolderPath, selectedFile.getName()), StandardCopyOption.REPLACE_EXISTING);
                view.setPosterPath(selectedFile.getName());
            } catch (IOException ex) {
                PopUpMessage.showErrorMessage("Erreur lors de l'enregistrement de l'image du poster.");
            }
        }
    }

    public static void main(String[] args) {
        FilmDao filmDao = new FilmDaoImpl();
        AddFilm view = new AddFilm();
        ControllerAddFilm controller = new ControllerAddFilm(view, filmDao);
        controller.start();
    }
}
