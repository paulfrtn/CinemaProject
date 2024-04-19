package Model.Film;

import java.util.List;

public interface FilmDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addFilm(Film film);

    // Read
    public Film getFilmById(int id);
    public Film getFilmByTitle(String title);

    // Update
    public void updateFilm(Film film);

    // Delete
    public void deleteFilm(Film film);

    // Read
    public static List<Film> getNowShowingFilms() {
        return null;
    }

    public static List<Film> getPremieresFilms() {
        return null;
    }

    public static List<Film> getComingSoonFilms() {
        return null;
    }


}
