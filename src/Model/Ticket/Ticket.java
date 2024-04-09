package Model.Ticket;

import java.util.Date;

public class Ticket {
    private int ticket_id;
    private Date ticket_date;
    private Boolean ticket_status;
    private int ticket_price;

    public Ticket(int ticket_id, Date ticket_date, Boolean ticket_status, int ticket_price) {
        this.ticket_id = ticket_id;
        this.ticket_date = ticket_date;
        this.ticket_status = ticket_status;
        this.ticket_price = ticket_price;
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



}
