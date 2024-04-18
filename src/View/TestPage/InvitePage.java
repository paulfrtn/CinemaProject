package View.TestPage;

import javax.swing.*;
import java.awt.*;

public class InvitePage extends JPanel{
    public InvitePage() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel messageLabel = new JLabel("Vous êtes un invité !");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(messageLabel, BorderLayout.CENTER);
    }
}
