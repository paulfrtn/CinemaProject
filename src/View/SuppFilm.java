package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SuppFilm extends JFrame {
    private JTextField filmTitleField;
    private JButton deleteButton;

    public SuppFilm() {
        setTitle("Supprimer un film");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(Color.decode("#2a2d43"));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Nom du film à supprimer : ");
        titleLabel.setForeground(Color.WHITE);
        filmTitleField = new JTextField();
        filmTitleField.setBorder(BorderFactory.createLineBorder(Color.decode("#BCF4F5"))); // Bordure plus fine

        deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(Color.decode("#BCF4F5"));
        JPanel buttonPanel = new JPanel(); // Panel pour le bouton
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alignement milieu
        buttonPanel.setBackground(Color.decode("#2a2d43")); // Couleur de fond bleu
        buttonPanel.add(deleteButton);

        panel.add(titleLabel);
        panel.add(filmTitleField);
        panel.add(buttonPanel);

        deleteButton.setPreferredSize(new Dimension(120, 30)); // Taille réduite du bouton

        add(panel);
    }

    public String getFilmTitle() {
        return filmTitleField.getText();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }
}

