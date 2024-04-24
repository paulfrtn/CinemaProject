package Model.Seance;

import java.sql.Time;
import java.sql.Date;

/**
 * La classe Seance représente une séance de cinéma.
 */
public class Seance {
    private int seance_id;
    private Date seance_date;
    private Time seance_time;
    private String seance_language;
    private int seance_nb_reservation;
    private int film_id;
    private int salle_id;

    /**
     * Constructeur de la classe Seance avec tous les paramètres.
     * @param seance_id L'identifiant de la séance.
     * @param seance_date La date de la séance.
     * @param seance_time L'heure de la séance.
     * @param seance_language La langue de la séance.
     * @param seance_nb_reservation Le nombre de réservations pour la séance.
     * @param film_id L'identifiant du film associé à la séance.
     * @param salle_id L'identifiant de la salle où se déroule la séance.
     */
    public Seance(int seance_id, Date seance_date, Time seance_time, String seance_language, int seance_nb_reservation, int film_id, int salle_id) {
        this.seance_id = seance_id;
        this.seance_date = seance_date;
        this.seance_time = seance_time;
        this.seance_language = seance_language;
        this.seance_nb_reservation = seance_nb_reservation;
        this.film_id = film_id; // Initialisation de film_id
        this.salle_id = salle_id; // Initialisation de salle_id
    }

    /**
     * Constructeur de la classe Seance sans l'identifiant de la séance.
     * @param seance_date La date de la séance.
     * @param seance_time L'heure de la séance.
     * @param seance_language La langue de la séance.
     * @param seance_nb_reservation Le nombre de réservations pour la séance.
     * @param film_id L'identifiant du film associé à la séance.
     * @param salle_id L'identifiant de la salle où se déroule la séance.
     */
    public Seance(Date seance_date, Time seance_time, String seance_language, int seance_nb_reservation, int film_id, int salle_id) {
        this.seance_date = seance_date;
        this.seance_time = seance_time;
        this.seance_language = seance_language;
        this.seance_nb_reservation = seance_nb_reservation;
        this.film_id = film_id; // Initialisation de film_id
        this.salle_id = salle_id; // Initialisation de salle_id
    }

    // Getters
    /**
     * Getter pour l'identifiant de la séance.
     * @return L'identifiant de la séance.
     */
    public int getSeance_id() {
        return seance_id;
    }

    /**
     * Getter pour la date de la séance.
     * @return La date de la séance.
     */
    public Date getSeance_date() {
        return seance_date;
    }

    /**
     * Getter pour l'heure de la séance.
     * @return L'heure de la séance.
     */
    public Time getSeance_time() {
        return seance_time;
    }

    /**
     * Getter pour la langue de la séance.
     * @return La langue de la séance.
     */
    public String getSeance_language() {
        return seance_language;
    }

    /**
     * Getter pour le nombre de réservations de la séance.
     * @return Le nombre de réservations de la séance.
     */
    public int getSeance_nb_reservation() {
        return seance_nb_reservation;
    }

    /**
     * Getter pour l'identifiant du film associé à la séance.
     * @return L'identifiant du film associé à la séance.
     */
    public int getFilm_id() {
        return film_id;
    }

    /**
     * Getter pour l'identifiant de la salle où se déroule la séance.
     * @return L'identifiant de la salle où se déroule la séance.
     */
    public int getSalle_id() {
        return salle_id;
    }

    // Setters

    /**
     * Setter pour l'identifiant de la séance.
     * @param seance_id L'identifiant de la séance à définir.
     */
    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    /**
     * Setter pour la date de la séance.
     * @param seance_date La date de la séance à définir.
     */
    public void setSeance_date(Date seance_date) {
        this.seance_date = seance_date;
    }

    /**
     * Setter pour l'heure de la séance.
     * @param seance_time L'heure de la séance à définir.
     */
    public void setSeance_time(Time seance_time) {
        this.seance_time = seance_time;
    }

    /**
     * Setter pour la langue de la séance.
     * @param seance_language La langue de la séance à définir.
     */
    public void setSeance_language(String seance_language) {
        this.seance_language = seance_language;
    }

    /**
     * Setter pour le nombre de réservations de la séance.
     * @param seance_nb_reservation Le nombre de réservations de la séance à définir.
     */
    public void setSeance_nb_reservation(int seance_nb_reservation) {
        this.seance_nb_reservation = seance_nb_reservation;
    }

    /**
     * Setter pour l'identifiant du film associé à la séance.
     * @param film_id L'identifiant du film associé à la séance à définir.
     */
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    /**
     * Setter pour l'identifiant de la salle où se déroule la séance.
     * @param salle_id L'identifiant de la salle où se déroule la séance à définir.
     */
    public void setSalle_id(int salle_id) {
        this.salle_id = salle_id;
    }

    /**
     * Méthode pour obtenir une représentation textuelle de la séance.
     * @return Une représentation textuelle de la séance.
     */
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
