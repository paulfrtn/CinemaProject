package Controller.SignIn;

import Controller.SignUp.Hash;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.PopUpMessage;

public class ControllerSignIn {
    public boolean onSignIn(String email, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        Hash hash = new Hash();
        PopUpMessage popUpMessage = new PopUpMessage();
        System.out.println(email+" "+password);
        boolean mailExists = userDao.DoesMailExist(email);
        boolean passwordExists = userDao.DoesPasswordExist(email,password);
        if (!mailExists) {
            popUpMessage.showErrorMessage("L'adresse e-mail n'existe pas.");
            return false; // Indiquer que la connexion a échoué
        }else{
            User user = userDao.getUserByMail(email);
            boolean passwordCorrect = hash.comparePassword(password,user.getUser_password());
            if(!passwordCorrect){
                popUpMessage.showErrorMessage("Le mot de passe est incorrect.");
                return false; // Indiquer que la connexion a échoué
            }else{
                //popUpMessage.showSuccessMessage("Connexion réussie."+user.toString());
                return true;
            }
        }

    }
}
