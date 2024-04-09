package Model.Ticket;

public interface TicketDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addTicket(Ticket ticket);

    // Read
    public Ticket getTicketById(int id);
    public Ticket getTicketByDate(String date);

    // Update
    public void updateTicket(Ticket ticket);

    // Delete
    public void deleteTicket(Ticket ticket);
}
