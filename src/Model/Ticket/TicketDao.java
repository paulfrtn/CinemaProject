package Model.Ticket;

import java.util.List;
import java.sql.Date;

public interface TicketDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addTicket(Ticket ticket, int user_id, int seance_id, int offer_id);

    // Read
    public Ticket getTicketById(int id);
    public List<Ticket> getTicketByDate(Date date);

    // Update
    public void updateTicket(Ticket ticket);

    // Delete
    public void deleteTicketById(Ticket ticket);
}
