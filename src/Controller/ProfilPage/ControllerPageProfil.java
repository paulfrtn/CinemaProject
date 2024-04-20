package Controller.ProfilPage;

import Model.User.*;
import View.ProfilPage.ViewPageProfil;
import CustomExceptions.UserNotFoundException;
import javax.swing.*;

public class ControllerPageProfil {
    private ViewPageProfil view;
    private UserDaoImpl model;

    public ControllerPageProfil(ViewPageProfil view, UserDaoImpl model) {
        this.view = view;
        this.model = model;
    }

    public void displayUser(int userId) throws UserNotFoundException{
        try {
            User user = model.getUserById(userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }
            view.setUserProfile(user.getUser_firstname(), user.getUser_lastname(), user.getUser_mail(),
                    user.getUser_pseudo(), user.getUser_role(), user.getUser_birthday().toString(),
                    String.valueOf(user.getUser_type()));
        } catch (UserNotFoundException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void displaySeanceUser(int userId) throws UserNotFoundException{
        try {
            User user = model.getUserById(userId);
            if (user == null) {
                throw new UserNotFoundException("User not found with ID: " + userId);
            }

        } catch (UserNotFoundException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}
