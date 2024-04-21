package Controller.SignIn;

/**
 * Interface pour le contrôleur de la fonctionnalité de connexion.
 */
public interface ControllerSignInInterface {

    /**
     * Tente de connecter l'utilisateur avec l'adresse e-mail et le mot de passe fournis.
     *
     * @param email    l'adresse e-mail de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return true si la connexion est réussie, sinon false
     */
    boolean onSignIn(String email, String password);
}
