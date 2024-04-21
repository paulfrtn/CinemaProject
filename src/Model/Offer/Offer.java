package Model.Offer;


import java.sql.Date;

public class Offer {

    private int offer_id;
    private String offer_name;
    private String offer_description;
    private Date offer_start_date;
    private Date offer_end_date;
    private float offer_price; // Peut être null
    private float offer_discount; //Peut être null
    private int offer_limit; //Peut être null

    private int offer_user_type; //Peut être null
    private Boolean offer_status;
    private int id_user;

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
    public int getOffer_id() {
        return offer_id;
    }

    public String getOffer_name() {
        return offer_name;
    }

    public String getOffer_description() {
        return offer_description;
    }

    public Date getOffer_start_date() {
        return offer_start_date;
    }

    public Date getOffer_end_date() {
        return offer_end_date;
    }

    public float getOffer_price() {
        return offer_price;
    }

    public float getOffer_discount() {
        return offer_discount;
    }

    public int getOffer_limit() {
        return offer_limit;
    }

    public int getOffer_user_type() {
        return offer_user_type;
    }

    public Boolean getOffer_status() {
        return offer_status;
    }

    // Setters
    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    public void setOffer_start_date(Date offer_start_date) {
        this.offer_start_date = offer_start_date;
    }

    public void setOffer_end_date(Date offer_end_date) {
        this.offer_end_date = offer_end_date;
    }

    public void setOffer_price(float offer_price) {
        this.offer_price = offer_price;
    }

    public void setOffer_discount(float offer_discount) {
        this.offer_discount = offer_discount;
    }

    public void setOffer_limit(int offer_limit) {
        this.offer_limit = offer_limit;
    }

    public void setOffer_user_type(int offer_user_type) {
        this.offer_user_type = offer_user_type;
    }

    public void setOffer_status(Boolean offer_status) {
        this.offer_status = offer_status;
    }

    @Override
    public String toString() {
        return "Offer{" + "offer_id=" + offer_id + ", offer_name=" + offer_name + ", offer_description=" + offer_description + ", offer_start_date=" + offer_start_date + ", offer_end_date=" + offer_end_date + ", offer_price=" + offer_price + ", offer_discount=" + offer_discount + ", offer_limit=" + offer_limit + ", offer_status=" + offer_status + '}';
    }

}

