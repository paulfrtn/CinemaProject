package Model.Offer;

/**
 * Interface définissant les opérations CRUD (Create, Read, Update, Delete) pour les offres.
 */
public interface OfferDao {

    // Create

    /**
     * Ajoute une nouvelle offre à la base de données.
     * @param offer L'offre à ajouter.
     * @param user_id L'identifiant de l'utilisateur associé à l'offre.
     */
    public void addOffer(Offer offer, int user_id);

    // Read

    /**
     * Récupère une offre par son identifiant.
     * @param id L'identifiant de l'offre.
     * @return L'offre correspondante, ou null si aucune offre correspondante n'est trouvée.
     */
    public Offer getOfferById(int id);

    /**
     * Récupère une offre par son nom.
     * @param name Le nom de l'offre.
     * @return L'offre correspondante, ou null si aucune offre correspondante n'est trouvée.
     */
    public Offer getOfferByName(String name);

    // Update

    /**
     * Met à jour les informations d'une offre dans la base de données.
     * @param offer L'offre à mettre à jour.
     */
    public void updateOffer(Offer offer);

    // Delete

    /**
     * Supprime une offre de la base de données par son identifiant.
     * @param id L'identifiant de l'offre à supprimer.
     */
    public void deleteOfferbyId(int id);

    /**
     * Supprime une offre de la base de données par son nom.
     * @param name Le nom de l'offre à supprimer.
     */
    public void deleteOfferByName(String name);
}
