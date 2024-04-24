package Controller.SuppUser;

import Model.User.UserDaoImpl;
import View.PopUpMessage.PopUpMessage;
import View.AddThings.SuppUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur pour la fonctionnalité de suppression d'utilisateur.
 */
public class SuppUserController implements SuppUserControllerInterface {
    private SuppUser view; // Vue pour la suppression d'utilisateur
    private UserDaoImpl userDao; // DAO pour les utilisateurs

    /**
     * Constructeur par défaut.
     */
    public SuppUserController() {
        view = new SuppUser(); // Initialisation de la vue
        userDao = new UserDaoImpl(); // Initialisation du DAO des utilisateurs

        // Ajout d'un écouteur pour le bouton de suppression dans la vue
        view.addSupprimerListener(new SupprimerListener());
    }

    /**
     * Obtient l'identifiant de l'utilisateur en fonction de son adresse e-mail.
     *
     * @param email l'adresse e-mail de l'utilisateur
     * @return l'identifiant de l'utilisateur, ou -1 si aucun utilisateur n'est trouvé
     */
    private int getUserIdByEmail(String email) {
        int userId = -1;
        try {
            userId = userDao.getUserByMail(email).getUser_id(); // Récupération de l'identifiant de l'utilisateur par son e-mail
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userId;
    }

    /**
     * Écouteur pour le bouton de suppression dans la vue.
     */
    private class SupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail(); // Obtention de l'e-mail à partir de la vue
            if (!email.isEmpty()) {
                int userId = getUserIdByEmail(email); // Obtention de l'identifiant de l'utilisateur par son e-mail
                if (userId != -1) {
                    userDao.deleteUserById(userId); // Suppression de l'utilisateur de la base de données
                    PopUpMessage.showSuccessMessage("L'utilisateur a été supprimé avec succès !"); // Affichage d'un message de succès
                } else {
                    PopUpMessage.showErrorMessage("Aucun utilisateur trouvé avec cet e-mail."); // Affichage d'un message d'erreur si aucun utilisateur n'est trouvé
                }
            } else {
                PopUpMessage.showErrorMessage("Veuillez saisir l'adresse e-mail de l'utilisateur."); // Affichage d'un message d'erreur si aucun e-mail n'est saisi
            }
        }
    }

    /**
     * Lance la fonctionnalité de suppression d'utilisateur.
     */
    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true); // Affichage de la vue dans l'EDT
        });
    }

    /**
     * Méthode principale pour lancer le contrôleur.
     */
    public static void main(String[] args) {
        SuppUserControllerInterface controller = new SuppUserController(); // Création du contrôleur
        controller.start(); // Lancement de la fonctionnalité de suppression d'utilisateur
    }
}
