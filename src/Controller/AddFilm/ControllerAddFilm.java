package Controller.AddFilm;


import Model.Film.Film;
import Model.Film.FilmDao;
import Model.Film.FilmDaoImpl;
import View.AddFilm;
import View.PopUpMessage;

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

public class ControllerAddFilm {
    private AddFilm view;
    private FilmDao filmDao;

    public ControllerAddFilm(AddFilm view, FilmDao filmDao) {
        this.view = view;
        this.filmDao = filmDao;
        this.view.addAddListener(new AddListener());
        this.view.addInsertPosterListener(new InsertPosterListener());
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    public void addFilm() {
        String title = view.getTitleField();
        String director = view.getDirectorField();
        String genre = view.getGenreField();
        String synopsis = view.getSynopsisArea();
        int duration = 0;
        Date releaseDate = null;

        try {
            duration = Integer.parseInt(view.getDurationField());
        } catch (NumberFormatException e) {
            PopUpMessage.showErrorMessage("Veuillez saisir une durée valide.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(view.getReleaseDateField());
            releaseDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            PopUpMessage.showErrorMessage("Format de date invalide. Utilisez le format yyyy-MM-dd.");
            return;
        }

        int status = view.getStatus();
        if (status == 0) {
            PopUpMessage.showErrorMessage("Veuillez choisir un statut.");
            return;
        }

        String posterPath = view.getPosterPath();
        posterPath = "src/Images/" + posterPath;

        // Création de l'objet Film
        Film film = new Film(0, title, director, genre, duration, synopsis, releaseDate, true, posterPath);

        // Ajout du film à la base de données
        filmDao.addFilm(film);

        PopUpMessage.showSuccessMessage("Le film a été ajouté avec succès !");
        view.dispose();
    }

    private class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addFilm();
        }
    }

    private class InsertPosterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg"));
            int returnValue = fileChooser.showOpenDialog(view);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    // Obtenir le chemin absolu vers le dossier "Images"
                    String imagesFolderPath = new File("src/Model/Images").getAbsolutePath();
                    // Copier le fichier sélectionné vers le dossier "Images"
                    Files.copy(selectedFile.toPath(), Paths.get(imagesFolderPath, selectedFile.getName()), StandardCopyOption.REPLACE_EXISTING);
                    // Définir le chemin du poster dans la vue
                    view.setPosterPath(selectedFile.getName());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    PopUpMessage.showErrorMessage("Erreur lors de l'enregistrement de l'image du poster.");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Créez une instance de FilmDao
        FilmDao filmDao = new FilmDaoImpl();
        // Créez une instance de la vue
        AddFilm view = new AddFilm();
        // Passez la vue et le DAO au contrôleur
        ControllerAddFilm controller = new ControllerAddFilm(view, filmDao);
        // Lancez l'interface utilisateur
        controller.start();
    }
}



