package Model.Ticket;

import java.sql.Date;

/**
 * Cette classe représente un ticket pour une séance de cinéma.
 */
public class Ticket {
    private int ticket_id; // Identifiant unique du ticket
    private Date ticket_date; // Date du ticket
    private Boolean ticket_status; // Statut du ticket (True = payé, False = non payé)
    private int ticket_price; // Prix du ticket
    private int user_id; // Identifiant de l'utilisateur (Si user_id = 0 alors c'est un invité)
    private int seance_id; // Identifiant de la séance
    private int offer_id; // Identifiant de l'offre (Si offer_id = 0 alors pas d'offre)
    private String mail; // Adresse e-mail de l'utilisateur

    /**
     * Constructeur pour un ticket sans offre.
     *
     * @param ticket_date   Date du ticket
     * @param ticket_status Statut du ticket
     * @param ticket_price  Prix du ticket
     * @param user_id       Identifiant de l'utilisateur
     * @param seance_id     Identifiant de la séance
     * @param mail          Adresse e-mail de l'utilisateur
     */
    public Ticket(Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, String mail) {
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.mail = mail;
    }

    /**
     * Constructeur pour un ticket invité.
     *
     * @param ticket_date   Date du ticket
     * @param ticket_status Statut du ticket
     * @param ticket_price  Prix du ticket
     * @param seance_id     Identifiant de la séance
     * @param mail          Adresse e-mail de l'utilisateur
     */
    public Ticket(Date ticket_date, Boolean ticket_status, int ticket_price, int seance_id, String mail) {
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.seance_id = seance_id;
        this.mail = mail;
    }

    /**
     * Constructeur pour un ticket avec une offre.
     *
     * @param ticket_date   Date du ticket
     * @param ticket_status Statut du ticket
     * @param ticket_price  Prix du ticket
     * @param user_id       Identifiant de l'utilisateur
     * @param seance_id     Identifiant de la séance
     * @param offer_id      Identifiant de l'offre
     * @param mail          Adresse e-mail de l'utilisateur
     */
    public Ticket(Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, int offer_id, String mail) {
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.offer_id = offer_id;
        this.mail = mail;
    }

    /**
     * Constructeur pour un ticket existant avec tous les détails.
     *
     * @param ticket_id     Identifiant unique du ticket
     * @param ticket_date   Date du ticket
     * @param ticket_status Statut du ticket
     * @param ticket_price  Prix du ticket
     * @param user_id       Identifiant de l'utilisateur
     * @param seance_id     Identifiant de la séance
     * @param offer_id      Identifiant de l'offre
     * @param mail          Adresse e-mail de l'utilisateur
     */
    public Ticket(int ticket_id, Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, int offer_id, String mail) {
        this.ticket_id = ticket_id;
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.offer_id = offer_id;
    }

    // Getters

    /**
     * Obtient l'identifiant du ticket.
     *
     * @return L'identifiant du ticket
     */
    public int getTicket_id() {
        return ticket_id;
    }

    /**
     * Obtient la date du ticket.
     *
     * @return La date du ticket
     */
    public Date getTicket_date() {
        return ticket_date;
    }

    /**
     * Obtient le statut du ticket.
     *
     * @return Le statut du ticket
     */
    public Boolean getTicket_status() {
        return ticket_status;
    }

    /**
     * Obtient le prix du ticket.
     *
     * @return Le prix du ticket
     */
    public int getTicket_price() {
        return ticket_price;
    }

    /**
     * Obtient l'identifiant de l'utilisateur.
     *
     * @return L'identifiant de l'utilisateur
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Obtient l'identifiant de la séance.
     *
     * @return L'identifiant de la séance
     */
    public int getSeance_id() {
        return seance_id;
    }

    /**
     * Obtient l'identifiant de l'offre.
     *
     * @return L'identifiant de l'offre
     */
    public int getOffer_id() {
        return offer_id;
    }

    /**
     * Obtient l'adresse e-mail de l'utilisateur.
     *
     * @return L'adresse e-mail de l'utilisateur
     */
    public String getMail() {
        return mail;
    }

    // Setters

    /**
     * Définit l'identifiant du ticket.
     *
     * @param ticket_id Nouvel identifiant du ticket
     */
    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    /**
     * Définit la date du ticket.
     *
     * @param ticket_date Nouvelle date du ticket
     */
    public void setTicket_date(Date ticket_date) {
        this.ticket_date = ticket_date;
    }

    /**
     * Définit le statut du ticket.
     *
     * @param ticket_status Nouveau statut du ticket
     */
    public void setTicket_status(Boolean ticket_status) {
        this.ticket_status = ticket_status;
    }

    /**
     * Définit le prix du ticket.
     *
     * @param ticket_price Nouveau prix du ticket
     */
    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    /**
     * Définit l'identifiant de l'utilisateur.
     *
     * @param user_id Nouvel identifiant de l'utilisateur
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Définit l'identifiant de la séance.
     *
     * @param seance_id Nouvel identifiant de la séance
     */
    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    /**
     * Définit l'identifiant de l'offre.
     *
     * @param offer_id Nouvel identifiant de l'offre
     */
    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    /**
     * Définit l'adresse e-mail de l'utilisateur.
     *
     * @param mail Nouvelle adresse e-mail de l'utilisateur
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", ticket_date=" + ticket_date +
                ", ticket_status=" + ticket_status +
                ", ticket_price=" + ticket_price +
                ", user_id=" + user_id +
                ", seance_id=" + seance_id +
                ", offer_id=" + offer_id +
                '}';
    }
}

