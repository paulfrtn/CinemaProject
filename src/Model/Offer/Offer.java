package Model.Offer;

import java.sql.Date;

/**
 * Représente une offre.
 */
public class Offer {

    private int offer_id; // Identifiant de l'offre
    private String offer_name; // Nom de l'offre
    private String offer_description; // Description de l'offre
    private Date offer_start_date; // Date de début de l'offre
    private Date offer_end_date; // Date de fin de l'offre
    private float offer_price; // Prix de l'offre (peut être null)
    private float offer_discount; // Réduction de l'offre (peut être null)
    private int offer_limit; // Limite de l'offre (peut être null)
    private int offer_user_type; // Type d'utilisateur associé à l'offre (peut être null)
    private Boolean offer_status; // Statut de l'offre
    private int id_user; // Identifiant de l'utilisateur associé à l'offre

    /**
     * Constructeur de l'offre avec tous les détails.
     */
    public Offer(int offer_id, String offer_name, String offer_description, Date offer_start_date, Date offer_end_date, float offer_price, float offer_discount, int offer_limit, int offer_user_type, Boolean offer_status) {
        this.offer_id = offer_id;
        this.offer_name = offer_name;
        this.offer_description = offer_description;
        this.offer_start_date = offer_start_date;
        this.offer_end_date = offer_end_date;
        this.offer_price = offer_price;
        this.offer_discount = offer_discount;
        this.offer_limit = offer_limit;
        this.offer_user_type = offer_user_type;
        this.offer_status = offer_status;
    }

    /**
     * Constructeur de l'offre avec certains détails.
     */
    public Offer(String offer_name, String offer_description, Date offer_start_date, Date offer_end_date, float offer_price, float offer_discount, int offer_limit, int offer_user_type, Boolean offer_status, int id_user) {
        this.offer_name = offer_name;
        this.offer_description = offer_description;
        this.offer_start_date = offer_start_date;
        this.offer_end_date = offer_end_date;
        this.offer_price = offer_price;
        this.offer_discount = offer_discount;
        this.offer_limit = offer_limit;
        this.offer_user_type = offer_user_type;
        this.offer_status = offer_status;
        this.id_user = id_user;
    }

    // Getters

    /**
     * Obtient l'identifiant de l'offre.
     */
    public int getOffer_id() {
        return offer_id;
    }

    /**
     * Obtient le nom de l'offre.
     */
    public String getOffer_name() {
        return offer_name;
    }

    /**
     * Obtient la description de l'offre.
     */
    public String getOffer_description() {
        return offer_description;
    }

    /**
     * Obtient la date de début de l'offre.
     */
    public Date getOffer_start_date() {
        return offer_start_date;
    }

    /**
     * Obtient la date de fin de l'offre.
     */
    public Date getOffer_end_date() {
        return offer_end_date;
    }

    /**
     * Obtient le prix de l'offre.
     */
    public float getOffer_price() {
        return offer_price;
    }

    /**
     * Obtient la réduction de l'offre.
     */
    public float getOffer_discount() {
        return offer_discount;
    }

    /**
     * Obtient la limite de l'offre.
     */
    public int getOffer_limit() {
        return offer_limit;
    }

    /**
     * Obtient le type d'utilisateur associé à l'offre.
     */
    public int getOffer_user_type() {
        return offer_user_type;
    }

    /**
     * Obtient le statut de l'offre.
     */
    public Boolean getOffer_status() {
        return offer_status;
    }

    // Setters

    /**
     * Définit l'identifiant de l'offre.
     */
    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    /**
     * Définit le nom de l'offre.
     */
    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    /**
     * Définit la description de l'offre.
     */
    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    /**
     * Définit la date de début de l'offre.
     */
    public void setOffer_start_date(Date offer_start_date) {
        this.offer_start_date = offer_start_date;
    }

    /**
     * Définit la date de fin de l'offre.
     */
    public void setOffer_end_date(Date offer_end_date) {
        this.offer_end_date = offer_end_date;
    }

    /**
     * Définit le prix de l'offre.
     */
    public void setOffer_price(float offer_price) {
        this.offer_price = offer_price;
    }

    /**
     * Définit la réduction de l'offre.
     */
    public void setOffer_discount(float offer_discount) {
        this.offer_discount = offer_discount;
    }

    /**
     * Définit la limite de l'offre.
     */
    public void setOffer_limit(int offer_limit) {
        this.offer_limit = offer_limit;
    }

    /**
     * Définit le type d'utilisateur associé à l'offre.
     */
    public void setOffer_user_type(int offer_user_type) {
        this.offer_user_type = offer_user_type;
    }

    /**
     * Définit le statut de l'offre.
     */
    public void setOffer_status(Boolean offer_status) {
        this.offer_status = offer_status;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", offer_name='" + offer_name + '\'' +
                ", offer_description='" + offer_description + '\'' +
                ", offer_start_date=" + offer_start_date +
                ", offer_end_date=" + offer_end_date +
                ", offer_price=" + offer_price +
                ", offer_discount=" + offer_discount +
                ", offer_limit=" + offer_limit +
                ", offer_status=" + offer_status +
                '}';
    }
}
