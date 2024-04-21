package Controller.AddOffer;

/**
 * Interface pour les contrôleurs qui gèrent l'ajout d'offres dans l'application.
 * Cette interface assure que tous les contrôleurs d'ajout d'offres implémentent les méthodes nécessaires
 * pour initialiser et afficher l'interface utilisateur correspondante.
 */
public interface ControllerAddOfferInterface {

    /**
     * Lance et affiche l'interface utilisateur associée au processus d'ajout d'offres.
     * Cette méthode doit être implémentée pour assurer que l'interface utilisateur est prête et visible
     * pour l'utilisateur final, permettant ainsi de gérer l'ajout d'offres de manière interactive.
     */
    void start();
}
