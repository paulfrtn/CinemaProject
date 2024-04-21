package Controller.Panier;

import java.sql.Date;

/**
 * Interface for controllers that manage the shopping cart functionality within the application.
 * This interface defines the necessary method for adding tickets to a user's shopping cart.
 */
public interface ControllerPanierInterface {

    /**
     * Adds tickets for a specified seance to a user's shopping cart, potentially applying an offer.
     *
     * @param idSeance The ID of the seance for which tickets are being added.
     * @param idUser The ID of the user who is adding tickets to their cart.
     * @param idOffer The ID of the offer to be applied to these tickets, if any.
     * @param price The price per ticket.
     * @param status The activation status of the tickets (true if active, false otherwise).
     * @param quantity The number of tickets to be added to the cart.
     * @param mail The email address of the user, used for sending ticket confirmation or notifications.
     */
    void addPanier(int idSeance, int idUser, int idOffer, int price, boolean status, int quantity, String mail);
}
