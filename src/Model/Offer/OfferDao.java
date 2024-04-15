package Model.Offer;

public interface OfferDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addOffer(Offer offer);

    // Read
    public Offer getOfferById(int id);
    public Offer getOfferByName(String name);

    // Update
    public void updateOffer(Offer offer);

    // Delete
    public void deleteOffer(Offer offer);
}
