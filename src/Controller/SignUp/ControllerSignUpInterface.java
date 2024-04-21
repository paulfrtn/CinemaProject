package Controller.SignUp;

/**
 * Interface pour le contrôleur de la fonctionnalité d'inscription.
 */
public interface ControllerSignUpInterface {

    /**
     * Tente d'inscrire un nouvel utilisateur avec les informations fournies.
     *
     * @param firstName le prénom de l'utilisateur
     * @param lastName  le nom de famille de l'utilisateur
     * @param email     l'adresse e-mail de l'utilisateur
     * @param pseudo    le pseudo de l'utilisateur
     * @param password  le mot de passe de l'utilisateur
     * @param birthday  la date de naissance de l'utilisateur au format "yyyy-mm-dd"
     * @return true si l'inscription est réussie, sinon false
     */
    boolean onSignUp(String firstName, String lastName, String email, String pseudo, String password, String birthday);
}
