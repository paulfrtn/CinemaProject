package Controller.SignUp;

import Model.User.User;
import Model.User.UserDaoImpl;
import View.PopUpMessage;
import java.sql.Date;

public class ControllerSignUp implements ControllerSignUpInterface {
    public boolean onSignUp(String firstName, String lastName, String email, String pseudo, String password, String birthday) {
        UserDaoImpl userDao = new UserDaoImpl();
        PopUpMessage popUpMessage = new PopUpMessage();
        Boolean user_role= false;
        int user_type = 0; // Initialisation de user_type en dehors des blocs if
        // Vérifiez si le mail existe
        boolean mailExists = userDao.DoesMailExist(email);
        // Vérifiez si le pseudo existe
        boolean pseudoExists = userDao.DoesPseudoExist(pseudo);

        // Si le mail existe
        if (mailExists && !pseudoExists) {
            popUpMessage.showErrorMessage("L'adresse e-mail est déjà utilisée.");
            return false; // Indiquer que l'inscription a échoué
        }
        // Si le pseudo existe
        if (pseudoExists && !mailExists) {
            popUpMessage.showErrorMessage("Le pseudo est déjà utilisé.");
            return false; // Indiquer que l'inscription a échoué
        }
        // Si les deux existent
        if (mailExists && pseudoExists) {
            popUpMessage.showErrorMessage("L'adresse e-mail et le pseudo sont déjà utilisés.");
            return false; // Indiquer que l'inscription a échoué
        }

        Date user_birthday = Date.valueOf(birthday);
        Date currentDate = new Date(System.currentTimeMillis());
        if (user_birthday.after(currentDate)) {
            popUpMessage.showErrorMessage("La date de naissance ne peut pas être après la date actuelle.");
            return false; // Indiquer que l'inscription a échoué
        }
        long diffInMillies = Math.abs(currentDate.getTime() - user_birthday.getTime());
        long diffInYears = diffInMillies / (1000L * 60 * 60 * 24 * 365); // Convertir la différence en années
        if(diffInYears < 14){
            popUpMessage.showErrorMessage("Vous ne pouvez pas vous inscrire avant vos 14 ans.");
            return false; // Indiquer que l'inscription a échoué
        }
        if (diffInYears <= 26) {
            user_type = 1;
        }
        if(diffInYears > 26 && diffInYears <= 60){
            user_type = 2;
        }
        if(diffInYears > 60 && diffInYears <= 110){
            user_type = 3;
        }
        if(diffInYears > 110){
            popUpMessage.showErrorMessage("Veuillez entrer une date de naissance valide.");
            return false; // Indiquer que l'inscription a échoué
        }

        // Après avoir déterminé le user_type, créez l'objet User
        User user = new User(firstName, lastName, email, pseudo, password, user_role, user_birthday, user_type);
        userDao.addUser(user);

        //popUpMessage.showSuccessMessage("Inscription réussie !");
        return true; // Indiquer que l'inscription a réussi
    }
}
