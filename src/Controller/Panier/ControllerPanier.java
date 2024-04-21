package Controller.Panier;

import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import Model.Ticket.Ticket;
import Model.Ticket.TicketDaoImpl;

import java.sql.Date;

public class ControllerPanier implements ControllerPanierInterface{

    public void addPanier(int idSeance, int idUser, int idOffer, int price, boolean status, int quantity) {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        Seance seance = seanceDao.getSeanceById(idSeance);

        Date date = seance.getSeance_date();
        idOffer = 0;
        Ticket ticket = new Ticket(date, status, price, idUser, idSeance, idOffer);

        for(int i=0; i<quantity; i++){
            ticketDao.addTicket(ticket, idUser, idSeance, idOffer);
        }
    }
}
