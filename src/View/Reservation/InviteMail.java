package View.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InviteMail extends JDialog {
    private JTextField emailField;
    private JButton okButton;
    private JButton cancelButton;
    private boolean isCancelled;

    public InviteMail(Frame parent, String title) {
        super(parent, title, true);
        isCancelled = true;
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Création du champ texte pour l'email
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(Color.decode("#FDF0D5")); // Couleur de fond
        emailField.setBorder(BorderFactory.createLineBorder(Color.decode("#669BBC"))); // Couleur de bordure
        inputPanel.add(emailField);

        // Création des boutons
        okButton = new JButton("OK");
        okButton.setBackground(Color.decode("#669BBC")); // Couleur de fond
        okButton.setForeground(Color.WHITE); // Couleur du texte
        okButton.setFocusPainted(false); // Empêche l'affichage du contour lorsqu'il est en focus
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isCancelled = false;
                dispose();
            }
        });
        buttonPanel.add(okButton);

        cancelButton = new JButton("Annuler");
        cancelButton.setBackground(Color.decode("#669BBC")); // Couleur de fond
        cancelButton.setForeground(Color.WHITE); // Couleur du texte
        cancelButton.setFocusPainted(false); // Empêche l'affichage du contour lorsqu'il est en focus
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(cancelButton);

        // Ajout des composants au panel principal
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#003049")); // Couleur de fond

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public static void main(String[] args) {
        InviteMail inviteMail = new InviteMail(new JFrame(), "Inviter un ami");
    }

}
