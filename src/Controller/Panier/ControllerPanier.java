package Controller.Panier;

import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import Model.Ticket.Ticket;
import Model.Ticket.TicketDaoImpl;

import java.sql.Date;

public class ControllerPanier implements ControllerPanierInterface{

    public void addPanier(int idSeance, int idUser, int idOffer, int price, boolean status, int quantity, String mail) {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        Seance seance = seanceDao.getSeanceById(idSeance);

        Date date = seance.getSeance_date();
        idOffer = 1;
        System.out.println("Quantity: " + quantity);

        for(int i=0; i<quantity; i++){
            Ticket ticket = new Ticket(date, status, price, idUser, idSeance, idOffer, mail);
            System.out.println(ticket.toString());
            ticketDao.addTicket(ticket);
        }
    }

}
