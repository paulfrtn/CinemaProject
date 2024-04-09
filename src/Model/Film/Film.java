package Model.Film;

import java.util.Date;

public class Film {
    private int film_id;
    private String film_title;
    private String film_director;
    private String film_genre;
    private int film_duration;
    private String film_synopsis;
    private Date film_release_date;
    private Boolean film_status;

    public Film(int film_id, String film_title, String film_director, String film_genre, int film_duration, String film_synopsis, Date film_release_date, Boolean film_status) {
        this.film_id = film_id;
        this.film_title = film_title;
        this.film_director = film_director;
        this.film_genre = film_genre;
        this.film_duration = film_duration;
        this.film_synopsis = film_synopsis;
        this.film_release_date = film_release_date;
        this.film_status = film_status;
    }

    // Getters
    public int getFilm_id() {
        return film_id;
    }

    public String getFilm_title() {
        return film_title;
    }

    public String getFilm_director() {
        return film_director;
    }

    public String getFilm_genre() {
        return film_genre;
    }

    public int getFilm_duration() {
        return film_duration;
    }

    public String getFilm_synopsis() {
        return film_synopsis;
    }

    public Date getFilm_release_date() {
        return film_release_date;
    }

    public Boolean getFilm_status() {
        return film_status;
    }

    // Setters

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setFilm_title(String film_title) {
        this.film_title = film_title;
    }

    public void setFilm_director(String film_director) {
        this.film_director = film_director;
    }

    public void setFilm_genre(String film_genre) {
        this.film_genre = film_genre;
    }

    public void setFilm_duration(int film_duration) {
        this.film_duration = film_duration;
    }

    public void setFilm_synopsis(String film_synopsis) {
        this.film_synopsis = film_synopsis;
    }

    public void setFilm_release_date(Date film_release_date) {
        this.film_release_date = film_release_date;
    }

    public void setFilm_status(Boolean film_status) {
        this.film_status = film_status;
    }

    @Override
    public String toString() {
        return "Film{" + "film_id=" + film_id + ", film_title=" + film_title + ", film_director=" + film_director + ", film_genre=" + film_genre + ", film_duration=" + film_duration + ", film_synopsis=" + film_synopsis + ", film_release_date=" + film_release_date + ", film_status=" + film_status + '}';
    }

}
