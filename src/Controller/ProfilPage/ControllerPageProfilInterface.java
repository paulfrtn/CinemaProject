package Controller.ProfilPage;
import CustomExceptions.UserNotFoundException;

/**
 * Interface représentant le contrôleur de la page de profil.
 */
public interface ControllerPageProfilInterface {

    /**
     * Affiche les détails de l'utilisateur spécifié.
     *
     * @param userId l'identifiant de l'utilisateur à afficher
     * @throws UserNotFoundException si l'utilisateur n'est pas trouvé
     */
    void displayUser(int userId) throws UserNotFoundException;

    /**
     * Affiche les séances de l'utilisateur spécifié.
     *
     * @param userId l'identifiant de l'utilisateur dont les séances doivent être affichées
     */
    void displaySeanceUser(int userId);
}
