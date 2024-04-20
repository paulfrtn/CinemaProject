package View.TestPage;

import javax.swing.*;
import java.awt.*;

public class FauxAccueil extends JPanel{
    public FauxAccueil() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("Vous êtes dans le faux accueil!");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(messageLabel, BorderLayout.CENTER);
    }

}
