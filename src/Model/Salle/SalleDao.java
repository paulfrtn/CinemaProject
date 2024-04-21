package Model.Salle;

/**
 * Interface définissant les opérations CRUD (Create, Read, Update, Delete) pour les salles.
 */
public interface SalleDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute une nouvelle salle.
     * @param salle La salle à ajouter.
     */
    public void addSalle(Salle salle);

    // Read

    /*public Salle getSalleById(int id);*/

    /**
     * Récupère une salle par son numéro.
     * @param number Le numéro de la salle à récupérer.
     * @return La salle correspondant au numéro spécifié, null si aucune salle trouvée.
     */
    public Salle getSalleByNumber(int number);

    // Update

    /**
     * Met à jour les informations d'une salle.
     * @param salle La salle avec les nouvelles informations.
     */
    public void updateSalle(Salle salle);

    // Delete

    /**
     * Supprime une salle en fonction de son numéro.
     * @param number Le numéro de la salle à supprimer.
     */
    public void deleteSalleByNumber(int number);
}
