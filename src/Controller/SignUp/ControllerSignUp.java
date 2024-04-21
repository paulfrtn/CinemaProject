package Controller.SignUp;

import Model.User.User;
import Model.User.UserDaoImpl;
import View.PopUpMessage;
import java.sql.Date;

/**
 * Contrôleur pour la fonctionnalité d'inscription.
 */
public class ControllerSignUp implements ControllerSignUpInterface {

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
    public boolean onSignUp(String firstName, String lastName, String email, String pseudo, String password, String birthday) {
        UserDaoImpl userDao = new UserDaoImpl(); // Instance du DAO pour les utilisateurs
        PopUpMessage popUpMessage = new PopUpMessage(); // Instance de la fenêtre contextuelle pour les messages
        Boolean user_role = false; // Le rôle de l'utilisateur (par défaut à false)
        int user_type = 0; // Le type de l'utilisateur (initialisé en dehors des blocs if)

        // Vérification si l'e-mail existe déjà
        boolean mailExists = userDao.DoesMailExist(email);

        // Vérification si le pseudo existe déjà
        boolean pseudoExists = userDao.DoesPseudoExist(pseudo);

        // Instance de l'outil de hachage pour les mots de passe
        Hash hash = new Hash();
        String HashedPassword;

        // Si l'e-mail existe déjà et le pseudo n'existe pas
        if (mailExists && !pseudoExists) {
            popUpMessage.showErrorMessage("L'adresse e-mail est déjà utilisée.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Si le pseudo existe déjà et l'e-mail n'existe pas
        if (pseudoExists && !mailExists) {
            popUpMessage.showErrorMessage("Le pseudo est déjà utilisé.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Si les deux existent déjà
        if (mailExists && pseudoExists) {
            popUpMessage.showErrorMessage("L'adresse e-mail et le pseudo sont déjà utilisés.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Hashage du mot de passe
        try {
            HashedPassword = hash.hashPassword(password);
        } catch (RuntimeException e) {
            popUpMessage.showErrorMessage("Erreur lors du hashage du mot de passe.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Conversion de la date de naissance au format Date
        Date user_birthday = Date.valueOf(birthday);
        Date currentDate = new Date(System.currentTimeMillis());

        // Vérification si la date de naissance est postérieure à la date actuelle
        if (user_birthday.after(currentDate)) {
            popUpMessage.showErrorMessage("La date de naissance ne peut pas être après la date actuelle.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Calcul de l'âge de l'utilisateur
        long diffInMillies = Math.abs(currentDate.getTime() - user_birthday.getTime());
        long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365); // Convertir la différence en années

        // Vérification de l'âge de l'utilisateur
        if (diffInYears < 14) {
            popUpMessage.showErrorMessage("Vous ne pouvez pas vous inscrire avant vos 14 ans.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Détermination du type d'utilisateur en fonction de l'âge
        if (diffInYears <= 26) {
            user_type = 1;
        } else if (diffInYears > 26 && diffInYears <= 60) {
            user_type = 2;
        } else if (diffInYears > 60 && diffInYears <= 110) {
            user_type = 3;
        } else {
            popUpMessage.showErrorMessage("Veuillez entrer une date de naissance valide.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Création de l'objet User avec les informations fournies
        User user = new User(firstName, lastName, email, pseudo, HashedPassword, user_role, user_birthday, user_type);

        // Ajout de l'utilisateur à la base de données
        userDao.addUser(user);

        // Affichage d'un message de succès
        //popUpMessage.showSuccessMessage("Inscription réussie !");
        return true; // Indiquer que l'inscription a réussi
    }
}
