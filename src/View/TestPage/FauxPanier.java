package View.TestPage;

import javax.swing.*;
import java.awt.*;

public class FauxPanier extends JPanel{
    public FauxPanier(int SeanceId) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel(SeanceId + " a été ajouté au panier !");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(messageLabel, BorderLayout.CENTER);
    }
}
