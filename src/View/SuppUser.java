package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SuppUser extends JFrame {
    private JTextField emailField;
    private JButton supprimerButton;

    public SuppUser() {
        setTitle("Suppression d'utilisateur");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(Color.decode("#2a2d43")); // Couleur de fond
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Marge intérieure

        JLabel label = new JLabel("Entrez l'adresse e-mail de l'utilisateur à supprimer : ");
        label.setForeground(Color.WHITE); // Texte en blanc
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 10));
        emailField.setBorder(BorderFactory.createLineBorder(Color.decode("#BCF4F5"))); // Bordure plus fine
        supprimerButton = new JButton("Supprimer");
        supprimerButton.setBackground(Color.decode("#BCF4F5")); // Couleur de fond bleu
        supprimerButton.setForeground(Color.BLACK); // Couleur du texte en blanc

        JPanel buttonPanel = new JPanel(); // Panel pour le bouton
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alignement milieu
        buttonPanel.setBackground(Color.decode("#2a2d43")); // Couleur de fond bleu
        buttonPanel.add(supprimerButton);

        panel.add(label);
        panel.add(emailField);
        panel.add(buttonPanel);

        supprimerButton.setPreferredSize(new Dimension(120, 30)); // Taille réduite du bouton

        add(panel);
        setVisible(true);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void addSupprimerListener(ActionListener listener) {
        supprimerButton.addActionListener(listener);
    }
}






