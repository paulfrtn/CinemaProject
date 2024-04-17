package Model.Offer;

public interface OfferDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addOffer(Offer offer, int user_id);

    // Read
    public Offer getOfferById(int id);
    public Offer getOfferByName(String name);

    // Update
    public void updateOffer(Offer offer);

    // Delete
    public void deleteOfferbyId(int id);

    public void deleteOfferByName(String name);
}
