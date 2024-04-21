package Model.Ticket;

import java.sql.Date;

public class TicketMain {
    public static void main(String[] args) {
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        Ticket ticket = new Ticket( new Date(System.currentTimeMillis()), true, 10, 1, 1,1, "1@gmail.com");
        ticketDao.addTicket(ticket);
    }
}
