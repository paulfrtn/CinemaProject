package Model.Seance;

import java.sql.Time;
import java.util.Date;

public class Seance {
    private int seance_id;
    private Date seance_date;
    private Time seance_time;
    private String seance_language;
    private int seance_nb_reservation;

    public Seance(int seance_id, Date seance_date, Time seance_time, String seance_language, int seance_nb_reservation) {
        this.seance_id = seance_id;
        this.seance_date = seance_date;
        this.seance_time = seance_time;
        this.seance_language = seance_language;
        this.seance_nb_reservation = seance_nb_reservation;
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
}
