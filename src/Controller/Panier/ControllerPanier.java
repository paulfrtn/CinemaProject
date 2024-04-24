package Controller.Panier;

import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;
import Model.Ticket.Ticket;
import Model.Ticket.TicketDaoImpl;

import java.sql.Date;

/**
 * Controller for managing the shopping cart functionalities in the application.
 * This controller handles the addition of tickets to the shopping cart based on user selections.
 */
public class ControllerPanier implements ControllerPanierInterface {

    /**
     * Adds a specified quantity of tickets for a given seance to the shopping cart, associated with a user and potentially an offer.
     *
     * @param idSeance The ID of the seance for which tickets are being added.
     * @param idUser The ID of the user adding tickets to their cart.
     * @param idOffer The ID of any offer applied to these tickets (default is 1, indicating no specific offer).
     * @param price The price of each ticket.
     * @param status The status of the ticket (e.g., active or inactive).
     * @param quantity The number of tickets to add.
     * @param mail The email address associated with the user for ticket confirmation.
     */
    public void addPanier(int idSeance, int idUser, int idOffer, int price, boolean status, int quantity, String mail) {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        Seance seance = seanceDao.getSeanceById(idSeance);

        Date date = seance.getSeance_date();

        for (int i = 0; i < quantity; i++) {
            Ticket ticket = new Ticket(date, status, price, idUser, idSeance, idOffer, mail);
            ticketDao.addTicket(ticket);
        }
    }
}
