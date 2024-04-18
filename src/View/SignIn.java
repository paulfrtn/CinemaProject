package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User.UserDaoImpl;

public class SignIn {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        UserDaoImpl.AuthentificationPanel authenticationPanel = new UserDaoImpl.AuthentificationPanel();
        frame.add(authenticationPanel);
        frame.setVisible(true);
    }



}
