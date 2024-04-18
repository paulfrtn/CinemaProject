package View.TestPage;

import javax.swing.*;
import java.awt.*;

public class SignUp2 extends JPanel {

    public SignUp2() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("Vous êtes bien inscrit !");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(messageLabel, BorderLayout.CENTER);
    }
}
