package Controller.Panier;

import java.sql.Date;

public interface ControllerPanierInterface {
    void addPanier(int idSeance, int idUser, int idOffer, int price,  boolean status, int quantity, String mail);
}
