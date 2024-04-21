package Controller.AddAdmin;
import Controller.SignUp.Hash;
import Model.User.User;
import Model.User.UserDaoImpl;
import View.AddAdmin;
import View.PopUpMessage;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddAdminController implements AddAdminControllerInterface {
    private AddAdmin view;
    private UserDaoImpl userDao;

    public AddAdminController() {
        view = new AddAdmin();
        userDao = new UserDaoImpl();

        view.addAddAdminListener(new AddAdminListener());
    }

    private class AddAdminListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstname = view.getFirstName();
            String lastname = view.getLastName();
            String mail = view.getMail();
            String pseudo = view.getPseudo();
            String password = view.getPassword();
            Date birthday = view.getBirthday();
            PopUpMessage popUpMessage = new PopUpMessage();

            // Vérification des champs vides
            if (firstname.isEmpty() || lastname.isEmpty() || mail.isEmpty() || pseudo.isEmpty() || password.isEmpty() || birthday == null) {
                popUpMessage.showErrorMessage("Veuillez remplir tous les champs.");
            } else {
                // Vérification de l'unicité du mail et du pseudo
                boolean mailExists = userDao.DoesMailExist(mail);
                // Vérifiez si le pseudo existe
                boolean pseudoExists = userDao.DoesPseudoExist(pseudo);

                // Si le mail existe
                if (mailExists && !pseudoExists) {
                    popUpMessage.showErrorMessage("L'adresse e-mail est déjà utilisée.");
                    return; // Indiquer que l'ajout a échoué
                }
                // Si le pseudo existe
                if (pseudoExists && !mailExists) {
                    popUpMessage.showErrorMessage("Le pseudo est déjà utilisé.");
                    return; // Indiquer que l'ajout a échoué
                }
                // Si les deux existent
                if (mailExists && pseudoExists) {
                    popUpMessage.showErrorMessage("L'adresse e-mail et le pseudo sont déjà utilisés.");
                    return; // Indiquer que l'ajout a échoué
                }

                // Hashage du mot de passe
                Hash hash = new Hash();
                String hashedPassword;
                try {
                    hashedPassword = hash.hashPassword(password);
                } catch (RuntimeException ex) {
                    popUpMessage.showErrorMessage("Erreur lors du hashage du mot de passe.");
                    return; // Indiquer que l'ajout a échoué
                }

                // Création de l'utilisateur admin
                User admin = new User(firstname, lastname, mail, pseudo, hashedPassword, true, birthday, 0);

                // Ajout de l'administrateur dans la base de données
                userDao.addUser(admin);

                // Affichage d'un message de confirmation
                popUpMessage.showSuccessMessage("L'administrateur a été ajouté avec succès !");
            }
        }
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    public static void main(String[] args) {
        AddAdminControllerInterface controller = new AddAdminController();
        controller.start();
    }
}
