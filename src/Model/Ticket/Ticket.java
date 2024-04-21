package Model.Ticket;

import java.sql.Date;

public class Ticket {
    private int ticket_id;
    private Date ticket_date;
    private Boolean ticket_status; // True = payé, False = non payé (panier ?)
    private int ticket_price;
    private int user_id; // Si user_id = 0 alors c'est un invité
    private int seance_id;
    private int offer_id;// Si offer_id = 0 alors pas d'offre
    private String mail;



    public Ticket(java.sql.Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, String mail) {
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.mail = mail;
    }

    public Ticket(java.sql.Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, int offer_id, String mail) {
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.offer_id = offer_id;
        this.mail = mail;
    }
    public Ticket(int ticket_id, java.sql.Date ticket_date, Boolean ticket_status, int ticket_price, int user_id, int seance_id, int offer_id, String mail) {
        this.ticket_id = ticket_id;
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
        this.user_id = user_id;
        this.seance_id = seance_id;
        this.offer_id = offer_id;
    }

    // Getters
    public int getTicket_id() {
        return ticket_id;
    }

    public Date getTicket_date() {
        return ticket_date;
    }

    public Boolean getTicket_status() {
        return ticket_status;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getSeance_id() {
        return seance_id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public String getMail() {
        return mail;
    }

    // Setters

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setTicket_date(Date ticket_date) {
        this.ticket_date = ticket_date;
    }

    public void setTicket_status(Boolean ticket_status) {
        this.ticket_status = ticket_status;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

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
