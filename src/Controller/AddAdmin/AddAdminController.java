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

/**
 * Contrôleur pour ajouter un administrateur dans l'application.
 * Gère l'interaction entre la vue et le modèle pour l'ajout d'administrateurs.
 */
public class AddAdminController implements AddAdminControllerInterface {
    private AddAdmin view;
    private UserDaoImpl userDao;

    /**
     * Constructeur pour initialiser la vue et le modèle.
     */
    public AddAdminController() {
        view = new AddAdmin();
        userDao = new UserDaoImpl();
        view.addAddAdminListener(new AddAdminListener());
    }

    /**
     * Classe interne pour gérer les actions de l'interface utilisateur.
     */
    private class AddAdminListener implements ActionListener {
        /**
         * Méthode appelée lorsqu'une action est effectuée (ex : bouton cliqué).
         * Gère l'ajout d'un nouvel administrateur à la base de données.
         *
         * @param e Événement d'action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstname = view.getFirstName();
            String lastname = view.getLastName();
            String mail = view.getMail();
            String pseudo = view.getPseudo();
            String password = view.getPassword();
            Date birthday = view.getBirthday();
            PopUpMessage popUpMessage = new PopUpMessage();

            // Vérification et gestion des champs vides et de l'unicité des informations
            if (fieldsAreEmpty(firstname, lastname, mail, pseudo, password, birthday)) {
                popUpMessage.showErrorMessage("Veuillez remplir tous les champs.");
                return;
            }

            // Vérifie l'unicité de l'email et du pseudo
            if (checkUniqueness(mail, pseudo, popUpMessage)) return;

            // Hashage et ajout de l'administrateur
            if (!processAdminAddition(firstname, lastname, mail, pseudo, password, birthday, popUpMessage)) return;

            // Affichage du message de succès
            popUpMessage.showSuccessMessage("L'administrateur a été ajouté avec succès !");
        }

        private boolean fieldsAreEmpty(String firstname, String lastname, String mail, String pseudo, String password, Date birthday) {
            return firstname.isEmpty() || lastname.isEmpty() || mail.isEmpty() || pseudo.isEmpty() || password.isEmpty() || birthday == null;
        }

        private boolean checkUniqueness(String mail, String pseudo, PopUpMessage popUpMessage) {
            boolean mailExists = userDao.DoesMailExist(mail);
            boolean pseudoExists = userDao.DoesPseudoExist(pseudo);
            if (handleExistingCredentials(mailExists, pseudoExists, popUpMessage)) {
                return true;
            }
            return false;
        }

        private boolean handleExistingCredentials(boolean mailExists, boolean pseudoExists, PopUpMessage popUpMessage) {
            if (mailExists || pseudoExists) {
                if (mailExists) popUpMessage.showErrorMessage("L'adresse e-mail est déjà utilisée.");
                if (pseudoExists) popUpMessage.showErrorMessage("Le pseudo est déjà utilisé.");
                return true;
            }
            return false;
        }

        private boolean processAdminAddition(String firstname, String lastname, String mail, String pseudo, String password, Date birthday, PopUpMessage popUpMessage) {
            Hash hash = new Hash();
            String hashedPassword;
            try {
                hashedPassword = hash.hashPassword(password);
            } catch (RuntimeException ex) {
                popUpMessage.showErrorMessage("Erreur lors du hashage du mot de passe.");
                return false;
            }
            User admin = new User(firstname, lastname, mail, pseudo, hashedPassword, true, birthday, 0);
            userDao.addUser(admin);
            return true;
        }
    }

    /**
     * Lance l'interface graphique dans le thread d'interface utilisateur.
     */
    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    /**
     * Point d'entrée principal pour tester le contrôleur.
     *
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        AddAdminControllerInterface controller = new AddAdminController();
        controller.start();
    }
}