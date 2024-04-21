package Controller.AddSeance;

/**
 * Interface pour les contrôleurs qui gèrent l'ajout de séances de films dans l'application.
 * Définit les opérations essentielles que chaque contrôleur d'ajout de séance doit être capable de réaliser.
 */
public interface ControllerAddSeanceInterface {

    /**
     * Méthode pour ajouter une nouvelle séance de film.
     * Doit implémenter la logique pour récupérer les données de la vue, les valider, et les persister dans la base de données.
     */
    void addSeance();

    /**
     * Lance et rend visible l'interface utilisateur associée au contrôleur.
     * Doit assurer que l'interface est prête pour que l'utilisateur puisse interagir.
     */
    void start();
}
