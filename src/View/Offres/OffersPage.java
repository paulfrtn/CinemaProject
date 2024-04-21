package View.Offres;

import Controller.MainFrame;
import Model.DataBase.ConnectionDb;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OffersPage extends JPanel {
    private JPanel mainPanel;
    private JButton btnFilms, btnProfile, btnBack;

    public OffersPage(int userType) {
        initializeUI();
    }

    private void initializeUI() {
        mainPanel = new JPanel(new BorderLayout());
        Color bgColor = new Color(0x003049); // Couleur bleu marine
        mainPanel.setBackground(bgColor);

        // Panel for navigation buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(bgColor);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(bgColor);

        btnFilms = new JButton("Films");
        btnProfile = new JButton("Profil");

        btnFilms.setBackground(bgColor);
        btnFilms.setForeground(Color.WHITE);
        btnProfile.setBackground(bgColor);
        btnProfile.setForeground(Color.WHITE);

        btnFilms.addActionListener(e -> navigateToHomeView());

        btnProfile.addActionListener(e -> navigateToProfileView());

        leftPanel.add(btnFilms);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(bgColor);
        rightPanel.add(btnProfile);

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Panel to display offers
        JPanel offersListPanel = new JPanel();
        offersListPanel.setLayout(new BoxLayout(offersListPanel, BoxLayout.Y_AXIS));
        offersListPanel.setBackground(bgColor);
        loadOffersFromDatabase(offersListPanel);

        JScrollPane scrollPane = new JScrollPane(offersListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(bgColor);
        scrollPane.getViewport().setBackground(bgColor);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);

        // Apply background color recursively to all components
        applyBackgroundColor(this, bgColor);

    }

    private void applyBackgroundColor(Component component, Color bgColor) {
        component.setBackground(bgColor);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                applyBackgroundColor(child, bgColor);
            }
        }
    }


    private void navigateToHomeView() {
        // Traverse the parent hierarchy to find an instance of MainFrame
        Container parent = this.getParent();
        while (parent != null && !(parent instanceof MainFrame)) {
            parent = parent.getParent();
        }

        // If we found the MainFrame, we can invoke a method to switch views
        if (parent != null) {
            MainFrame mainFrame = (MainFrame) parent;
            mainFrame.showAccueilView(); // Call the method that will show the Accueil view
        } else {
            // Handle error - MainFrame was not found in the hierarchy
            JOptionPane.showMessageDialog(this, "Navigation error: MainFrame not found.", "Navigation Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void navigateToProfileView() {
        // Méthode pour naviguer vers la page de profil
    }

    private void loadOffersFromDatabase(JPanel offersListPanel) {
        Color bgColor = new Color(0x2a2d43); // Couleur bleu marine

        try (Connection connection = ConnectionDb.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT \n" +
                     "    MIN(offer_id) AS offer_id,\n" +
                     "    MIN(offer_name) AS offer_name,\n" +
                     "    GROUP_CONCAT(offer_description SEPARATOR '<br>') AS descriptions,\n" +
                     "    offer_user_type\n" +
                     "FROM \n" +
                     "    offer\n" +
                     "GROUP BY \n" +
                     "    offer_user_type\n" +
                     "ORDER BY \n" +
                     "    offer_user_type;\n")) {

            while (rs.next()) {
                JPanel userTypePanel = new JPanel();
                userTypePanel.setLayout(new BorderLayout()); // Utilisation d'un layout BorderLayout pour centrer le titre
                userTypePanel.setBackground(bgColor);
                userTypePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure autour de la case


                userTypePanel.setMaximumSize(new Dimension(800, 150)); // Par exemple, 800 de large et 150 de haut

                JLabel userTypeLabel = new JLabel("<html><b><font size='5' color='white'>" + rs.getString("offer_name") + "</font></b></html>", SwingConstants.CENTER);
                userTypeLabel.setForeground(Color.WHITE);
                userTypePanel.add(userTypeLabel, BorderLayout.NORTH); // Ajout du titre au nord du panneau

                JPanel userOffersPanel = new JPanel();
                userOffersPanel.setLayout(new BoxLayout(userOffersPanel, BoxLayout.Y_AXIS));
                userOffersPanel.setBackground(bgColor);

                                JLabel offerDescription = new JLabel("<html><b>" + rs.getString("descriptions") + "</b></html>");

                offerDescription.setForeground(Color.WHITE);

                userTypeLabel.setForeground(Color.WHITE);

                userOffersPanel.add(userTypeLabel);
                userOffersPanel.add(offerDescription);

                userTypePanel.add(userOffersPanel, BorderLayout.CENTER); // Ajout des offres au centre du panneau utilisateur

                offersListPanel.add(userTypePanel);

                offersListPanel.add(Box.createVerticalStrut(10)); // Espace entre les cases
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des offres: " + e.getMessage(), "Erreur de Base de Données", JOptionPane.ERROR_MESSAGE);
        }

        offersListPanel.revalidate();
        offersListPanel.repaint();

    }



}

