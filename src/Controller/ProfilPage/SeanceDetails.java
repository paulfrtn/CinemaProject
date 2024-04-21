package Controller.ProfilPage;

import java.sql.Date;

/**
 * Cette classe représente les détails d'une séance de film.
 */
public class SeanceDetails {
    private String titreFilm; // Le titre du film de la séance
    private Date dateSeance; // La date de la séance
    private String langage; // Le langage du film
    private String posterFilm; // L'URL du poster du film

    /**
     * Constructeur pour initialiser les détails de la séance.
     *
     * @param titreFilm   le titre du film
     * @param dateSeance  la date de la séance
     * @param langage     le langage du film
     * @param posterFilm  l'URL du poster du film
     */
    public SeanceDetails(String titreFilm, Date dateSeance, String langage, String posterFilm) {
        this.titreFilm = titreFilm;
        this.dateSeance = dateSeance;
        this.langage = langage;
        this.posterFilm = posterFilm;
    }

    // Getters and Setters

    /**
     * Retourne le titre du film de la séance.
     *
     * @return le titre du film
     */
    public String getTitreFilm() {
        return titreFilm;
    }

    /**
     * Modifie le titre du film de la séance.
     *
     * @param titreFilm le nouveau titre du film
     */
    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    /**
     * Retourne la date de la séance.
     *
     * @return la date de la séance
     */
    public Date getDateSeance() {
        return dateSeance;
    }

    /**
     * Modifie la date de la séance.
     *
     * @param dateSeance la nouvelle date de la séance
     */
    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    /**
     * Retourne le langage du film de la séance.
     *
     * @return le langage du film
     */
    public String getLangage() {
        return langage;
    }

    /**
     * Modifie le langage du film de la séance.
     *
     * @param langage le nouveau langage du film
     */
    public void setLangage(String langage) {
        this.langage = langage;
    }

    /**
     * Retourne l'URL du poster du film de la séance.
     *
     * @return l'URL du poster du film
     */
    public String getPosterFilm() {
        return posterFilm;
    }

    /**
     * Modifie l'URL du poster du film de la séance.
     *
     * @param posterFilm la nouvelle URL du poster du film
     */
    public void setPosterFilm(String posterFilm) {
        this.posterFilm = posterFilm;
    }
}
