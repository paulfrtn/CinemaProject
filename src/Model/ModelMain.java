package Model;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;

import java.sql.Connection;
import java.util.Date;

import Model.DataBase.ConnectionDb;

public class ModelMain {
    public static void main(String[] args) {
        try (Connection connection = ConnectionDb.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                // Créer une instance de FilmDaoImpl
                FilmDaoImpl filmDao = new FilmDaoImpl();

                // Créer un nouvel objet film
                // Créer un nouvel objet film
                Film newFilm = new Film(
                        0, // l'ID est généralement auto-généré par la base de données
                        "Le Titre du Film",
                        "Le Réalisateur",
                        "Le Genre",
                        120, // Durée en minutes
                        "Le Synopsis",
                        new Date(), // Utiliser java.sql.Date pour les tests
                        true, // Statut du film
                        "https://lien.vers/affiche_du_film.jpg" // URL de l'affiche du film
                );

// Ajouter le film dans la base de données
                filmDao.addFilm(newFilm);
                System.out.println("Film added to database.");


                // Récupérer le film par son titre
                Film fetchedFilm = filmDao.getFilmByTitle("Le Titre du Film");
                if (fetchedFilm != null) {
                    System.out.println("Film retrieved: " + fetchedFilm.toString());
                }

                // Mettre à jour le film
                if (fetchedFilm != null) {
                    fetchedFilm.setFilm_duration(125); // Modifier la durée
                    filmDao.updateFilm(fetchedFilm);
                    System.out.println("Film updated.");
                }

                // Supprimer le film
                if (fetchedFilm != null) {
                    filmDao.deleteFilm(fetchedFilm);
                    System.out.println("Film deleted.");
                }

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

