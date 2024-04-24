package Model.Seance;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * L'interface SeanceDao définit les méthodes permettant de manipuler les objets Seance en base de données.
 */
public interface SeanceDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    /**
     * Ajoute une séance à la base de données.
     * @param seance La séance à ajouter.
     */
    public void addSeance(Seance seance);

    // Read
    /**
     * Récupère une séance par son identifiant.
     * @param id L'identifiant de la séance à récupérer.
     * @return La séance correspondant à l'identifiant donné.
     */
    public Seance getSeanceById(int id);

    /**
     * Récupère une liste de séances pour une date donnée et un identifiant de film donné.
     * @param date La date des séances à récupérer.
     * @param film_id L'identifiant du film des séances à récupérer.
     * @return La liste des séances correspondant à la date et à l'identifiant de film donnés.
     */
    public List<Seance> getSeanceByDateNFilmId(Date date, int film_id);

    /**
     * Récupère une séance par son heure, son identifiant de film et sa date.
     * @param time L'heure de la séance à récupérer.
     * @param film_id L'identifiant du film de la séance à récupérer.
     * @param date La date de la séance à récupérer.
     * @return La séance correspondant à l'heure, l'identifiant de film et la date donnés.
     */
    public Seance getSeanceByTimeNFilmIdNDate(Time time, int film_id, Date date);

    // Update
    /**
     * Met à jour les informations d'une séance dans la base de données.
     * @param seance La séance à mettre à jour.
     */
    public void updateSeance(Seance seance);

    // Delete
    /**
     * Supprime une séance de la base de données.
     * @param seance La séance à supprimer.
     */
    public void deleteSeance(Seance seance);
}
