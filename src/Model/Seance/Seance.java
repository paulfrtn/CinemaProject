package Model.Seance;

import java.sql.Time;
import java.sql.Date;

public class Seance {
    private int seance_id;
    private Date seance_date;
    private Time seance_time;
    private String seance_language;
    private int seance_nb_reservation;
    private int film_id;
    private int salle_id;

    public Seance(int seance_id, Date seance_date, Time seance_time, String seance_language, int seance_nb_reservation, int film_id, int salle_id) {
        this.seance_id = seance_id;
        this.seance_date = seance_date;
        this.seance_time = seance_time;
        this.seance_language = seance_language;
        this.seance_nb_reservation = seance_nb_reservation;
        this.film_id = film_id; // Initialisation de film_id
        this.salle_id = salle_id; // Initialisation de salle_id
    }
    public Seance( Date seance_date, Time seance_time, String seance_language, int seance_nb_reservation, int film_id, int salle_id) {

        this.seance_date = seance_date;
        this.seance_time = seance_time;
        this.seance_language = seance_language;
        this.seance_nb_reservation = seance_nb_reservation;
        this.film_id = film_id; // Initialisation de film_id
        this.salle_id = salle_id; // Initialisation de salle_id
    }

    // Getters
    public int getSeance_id() {
        return seance_id;
    }

    public Date getSeance_date() {
        return seance_date;
    }

    public Time getSeance_time() {
        return seance_time;
    }

    public String getSeance_language() {
        return seance_language;
    }

    public int getSeance_nb_reservation() {
        return seance_nb_reservation;
    }

    public int getFilm_id() {
        return film_id;
    }

    public int getSalle_id() {
        return salle_id;
    }
    // Setters

    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    public void setSeance_date(Date seance_date) {
        this.seance_date = seance_date;
    }

    public void setSeance_time(Time seance_time) {
        this.seance_time = seance_time;
    }

    public void setSeance_language(String seance_language) {
        this.seance_language = seance_language;
    }

    public void setSeance_nb_reservation(int seance_nb_reservation) {
        this.seance_nb_reservation = seance_nb_reservation;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setSalle_id(int salle_id) {
        this.salle_id = salle_id;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "seance_id=" + seance_id +
                ", seance_date=" + seance_date +
                ", seance_time=" + seance_time +
                ", seance_language='" + seance_language + '\'' +
                ", seance_nb_reservation=" + seance_nb_reservation +
                '}';
    }

}
