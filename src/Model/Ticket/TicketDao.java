package Model.Ticket;

import java.util.List;
import java.sql.Date;

/**
 * Cette interface définit les opérations CRUD (Create, Read, Update, Delete) pour les tickets.
 */
public interface TicketDao {
    // Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute un nouveau ticket à la base de données.
     *
     * @param ticket    Le ticket à ajouter
     * @param user_id   L'identifiant de l'utilisateur associé au ticket
     * @param seance_id L'identifiant de la séance associée au ticket
     * @param offer_id  L'identifiant de l'offre associée au ticket
     */
    public void addTicket(Ticket ticket, int user_id, int seance_id, int offer_id);

    // Read

    /**
     * Récupère un ticket par son identifiant.
     *
     * @param id L'identifiant du ticket à récupérer
     * @return Le ticket correspondant à l'identifiant spécifié
     */
    public Ticket getTicketById(int id);

    /**
     * Récupère une liste de tickets pour une date donnée.
     *
     * @param date La date pour laquelle récupérer les tickets
     * @return Une liste de tickets pour la date spécifiée
     */
    public List<Ticket> getTicketByDate(Date date);

    // Update

    /**
     * Met à jour les informations d'un ticket dans la base de données.
     *
     * @param ticket Le ticket à mettre à jour
     */
    public void updateTicket(Ticket ticket);

    // Delete

    /**
     * Supprime un ticket de la base de données.
     *
     * @param ticket Le ticket à supprimer
     */
    public void deleteTicketById(Ticket ticket);
}

