package View.Reservation;

import Controller.MainFrame;
import View.BorderRadCompenent.BorderRadButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paiement extends JDialog {
    private JTextField cardHolderNameField;
    private JTextField cardNumberField;
    private JTextField ccvField;
    private JTextField expirationDateField;
    private JButton validerButton;
    private MainFrame controller;
    private int price;
    private int quantity;
    private int id_offer;
    private String couleur1;
    private String couleur2;
    private String couleur3;

    public Paiement(MainFrame controller) {
        this.controller = controller;

        couleur1 = "#2a2d43";
        couleur2 = "#7A82AB";
        couleur3 = "#BCF4F5";
        // Créer les composants
        cardHolderNameField = new JTextField(20);
        cardNumberField = new JTextField(20);
        ccvField = new JTextField(5);
        expirationDateField = new JTextField(7);

        // Créer le bouton Valider
        validerButton = new BorderRadButton("Valider",10);
        buttonListener(controller.getPaiementButtonListener());


        // Créer le layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.setBackground(Color.decode(couleur1));
        JLabel cardHolderLabel = new JLabel("Titulaire de la carte:");
        cardHolderLabel.setForeground(Color.WHITE); // Texte en blanc
        panel.add(cardHolderLabel, gbc);
        gbc.gridx = 1;
        panel.add(cardHolderNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel cardNumberLabel = new JLabel("Numéro de carte:");
        cardNumberLabel.setForeground(Color.WHITE); // Texte en blanc
        panel.add(cardNumberLabel, gbc);
        gbc.gridx = 1;
        panel.add(cardNumberField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel ccvLabel = new JLabel("CCV:");
        ccvLabel.setForeground(Color.WHITE); // Texte en blanc
        panel.add(ccvLabel, gbc);
        gbc.gridx = 1;
        panel.add(ccvField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel expirationDateLabel = new JLabel("Date d'expiration (mm/aa):");
        expirationDateLabel.setForeground(Color.WHITE); // Texte en blanc
        panel.add(expirationDateLabel, gbc);
        gbc.gridx = 1;
        panel.add(expirationDateField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(validerButton, gbc);

        // Ajouter le panel à la fenêtre modale
        getContentPane().add(panel);
        pack();
        setPreferredSize(new Dimension(300, 250));
    }

    private boolean validerInformations() {
        // Vérifier le numéro de carte
        String cardNumber = cardNumberField.getText().trim();
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return false;
        }

        // Vérifier le CCV
        String ccv = ccvField.getText().trim();
        if (ccv.length() != 3 || !ccv.matches("\\d+")) {
            return false;
        }

        // Vérifier la date d'expiration
        String expirationDate = expirationDateField.getText().trim();
        if (!expirationDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }

        // Si toutes les validations réussissent, retourner true
        return true;
    }

    public JButton getValiderButton() {
        return validerButton;
    }

    public Boolean getValiderInformation() {
        return validerInformations();
    }

    public void buttonListener(ActionListener listener) {
        validerButton.addActionListener(listener);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIdOffer(int id_offer) {
        this.id_offer = id_offer;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdOffer() {
        return id_offer;
    }


}




