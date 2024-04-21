package Controller.SuppUser;


import Model.User.UserDaoImpl;
import View.PopUpMessage;
import View.SuppUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuppUserController implements SuppUserControllerInterface {
    private SuppUser view;
    private UserDaoImpl userDao;

    public SuppUserController() {
        view = new SuppUser();
        userDao = new UserDaoImpl();

        view.addSupprimerListener(new SupprimerListener());
    }

    private int getUserIdByEmail(String email) {
        int userId = -1;
        try {
            userId = userDao.getUserByMail(email).getUser_id();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userId;
    }

    private class SupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmail();
            if (!email.isEmpty()) {
                int userId = getUserIdByEmail(email);
                if (userId != -1) {
                    userDao.deleteUserById(userId);
                    PopUpMessage.showSuccessMessage("L'utilisateur a été supprimé avec succès !");
                } else {
                    PopUpMessage.showErrorMessage("Aucun utilisateur trouvé avec cet e-mail.");
                }
            } else {
                PopUpMessage.showErrorMessage("Veuillez saisir l'adresse e-mail de l'utilisateur.");
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
        SuppUserControllerInterface controller = new SuppUserController();
        controller.start();
    }
}

