package Controller.SignIn;

import Controller.SignUp.Hash;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.PopUpMessage;

/**
 * Contrôleur pour la fonctionnalité de connexion.
 */
public class ControllerSignIn implements ControllerSignInInterface {

    /**
     * Tente de connecter l'utilisateur avec l'adresse e-mail et le mot de passe fournis.
     *
     * @param email    l'adresse e-mail de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return true si la connexion est réussie, sinon false
     */
    public boolean onSignIn(String email, String password) {
        UserDaoImpl userDao = new UserDaoImpl(); // Instance du DAO pour les utilisateurs
        Hash hash = new Hash(); // Instance de l'outil de hachage pour les mots de passe
        PopUpMessage popUpMessage = new PopUpMessage(); // Instance de la fenêtre contextuelle pour les messages

        // Affichage de l'e-mail et du mot de passe pour le débogage
        System.out.println(email + " " + password);

        // Vérification si l'e-mail existe dans la base de données
        boolean mailExists = userDao.DoesMailExist(email);

        // Vérification si le mot de passe correspond à l'e-mail dans la base de données
        boolean passwordExists = userDao.DoesPasswordExist(email, password);

        if (!mailExists) {
            // Affichage d'un message d'erreur si l'e-mail n'existe pas
            popUpMessage.showErrorMessage("L'adresse e-mail n'existe pas.");
            return false; // Indiquer que la connexion a échoué
        } else {
            // Récupération de l'utilisateur correspondant à l'e-mail
            User user = userDao.getUserByMail(email);

            // Comparaison du mot de passe fourni avec le mot de passe de l'utilisateur récupéré
            boolean passwordCorrect = hash.comparePassword(password, user.getUser_password());

            if (!passwordCorrect) {
                // Affichage d'un message d'erreur si le mot de passe est incorrect
                popUpMessage.showErrorMessage("Le mot de passe est incorrect.");
                return false; // Indiquer que la connexion a échoué
            } else {
                // Connexion réussie
                return true;
            }
        }
    }
}
