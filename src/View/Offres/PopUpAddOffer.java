package View.Offres;

import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PopUpAddOffer extends JFrame {
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextField startDateField;
    private JTextField endDateField;

    private JTextField discountField;
    private JTextField userTypeField;
    private JButton addButton;

    public PopUpAddOffer() {
        setTitle("Ajouter une offre");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2,2,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#2a2d43"));

        JLabel nameLabel = new JLabel("Nom de l'offre:");
        nameLabel.setForeground(Color.WHITE);
        nameField = new BorderRadTextField(10);


        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        JLabel startDateLabel = new JLabel("Date de début (yyyy-MM-dd):");
        startDateLabel.setForeground(Color.WHITE);
        startDateField = new BorderRadTextField(10);

        JLabel endDateLabel = new JLabel("Date de fin (yyyy-MM-dd):");
        endDateLabel.setForeground(Color.WHITE);
        endDateField = new BorderRadTextField(10);

        JLabel discountLabel = new JLabel("Réduction:");
        discountLabel.setForeground(Color.WHITE);
        discountField = new BorderRadTextField(10);


        JLabel userTypeLabel = new JLabel("Type d'utilisateur:");
        userTypeLabel.setForeground(Color.WHITE);
        userTypeField = new BorderRadTextField(10);

        addButton = new BorderRadButton("Ajouter",10);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descriptionLabel);
        panel.add(descriptionScrollPane);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(endDateLabel);
        panel.add(endDateField);

        panel.add(discountLabel);
        panel.add(discountField);

        panel.add(userTypeLabel);
        panel.add(userTypeField);
        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getDescriptionArea() {
        return descriptionArea.getText();
    }

    public String getStartDateField() {
        return startDateField.getText();
    }

    public String getEndDateField() {
        return endDateField.getText();
    }



    public String getDiscountField() {
        return discountField.getText();
    }



    public String getUserTypeField() {
        return userTypeField.getText();
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}

