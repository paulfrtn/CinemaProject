package View.TestPage;

import javax.swing.*;
import java.awt.*;


public class SignInTest extends JPanel{
    public SignInTest() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("Connexion");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(messageLabel, BorderLayout.CENTER);
    }
}
