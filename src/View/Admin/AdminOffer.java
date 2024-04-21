package View.Admin;

import Controller.AddOffer.ControllerAddOffer;
import Model.Offer.Offer;
import Model.Offer.OfferDaoImpl;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;
import View.BorderRadCompenent.BorderRadPanel;
import View.Offres.PopUpAddOffer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminOffer extends JPanel {
    String couleur1;
    String couleur2;
    String couleur3;
    private JPanel mainPanel;
    private JButton btnBack;
    private JButton btnFilms;
    private JButton btnOffers;
    private JButton btnLogOut;
    private JButton btnAddOffer;
    private JButton btnDeleteOffer;
    private JPanel offersPanel;
    private OfferDaoImpl offerDao;


    public AdminOffer(List<Offer> offers, int CurrentUserId) {
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";

        offerDao = new OfferDaoImpl();

        setLayout(new BorderLayout());
        setBackground(Color.decode(couleur1));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel row1 = new JPanel(new BorderLayout());
        row1.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.01;
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.BOTH;

        ImageIcon logoIcon = new ImageIcon("src/Model/Images/logo.jpg");
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logo = new BorderRadLabel(scaledLogoIcon, 10);
        row1.add(logo, BorderLayout.WEST);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        btnBack = new BorderRadButton("Retour", 10);
        btnBack.setBackground(Color.decode(couleur2));
        btnFilms = new BorderRadButton("Films", 10);
        btnFilms.setBackground(Color.decode(couleur2));
        btnOffers = new BorderRadButton("Offres", 10);
        btnOffers.setBackground(Color.decode(couleur2));
        btnLogOut = new BorderRadButton("Déconnexion", 10);
        btnLogOut.setBackground(Color.decode(couleur2));

        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnBack, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalStrut(10));
        buttonsPanel.add(btnFilms, BorderLayout.WEST);
        buttonsPanel.add(Box.createHorizontalGlue()); // Ajout d'un espace flexible
        buttonsPanel.add(btnLogOut, BorderLayout.EAST); // Aligner le bouton "Profil" à droite
        row1.add(buttonsPanel, BorderLayout.CENTER);

        mainPanel.add(row1, gbc);

        JPanel row2 = new JPanel(new BorderLayout());
        row2.setOpaque(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.90;
        gbc.fill = GridBagConstraints.BOTH;

        row2.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        JPanel ButtonPanel = new JPanel(new BorderLayout());
        ButtonPanel.setOpaque(false);
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.1;
        gbc2.insets = new Insets(7, 7, 7, 7);
        gbc2.fill = GridBagConstraints.NONE;
        gbc2.anchor = GridBagConstraints.CENTER;

        btnAddOffer = new BorderRadButton("Ajouter une offre", 10);
        btnAddOffer.setBackground(Color.decode(couleur2));
        btnAddOffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopUpAddOffer addOffer = new PopUpAddOffer();
                ControllerAddOffer controllerAddOffer = new ControllerAddOffer(addOffer, offerDao, CurrentUserId);
                controllerAddOffer.start();
                updateOffers();
            }
        });
        btnDeleteOffer = new BorderRadButton("Supprimer une offre", 10);
        btnDeleteOffer.setBackground(Color.decode(couleur2));
        btnDeleteOffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        ButtonPanel.add(Box.createHorizontalStrut(10));
        ButtonPanel.add(btnAddOffer, BorderLayout.WEST);
        ButtonPanel.add(Box.createHorizontalStrut(10));
        ButtonPanel.add(btnDeleteOffer, BorderLayout.EAST);

        row2.add(ButtonPanel, gbc2);

        JScrollPane offersScrollPane = new JScrollPane();
        offersScrollPane.setOpaque(false);
        offersScrollPane.getViewport().setOpaque(false);
        offersScrollPane.setBorder(BorderFactory.createEmptyBorder());
        offersPanel = new JPanel();
        offersPanel.setOpaque(false);
        offersPanel.setLayout(new BoxLayout(offersPanel, BoxLayout.Y_AXIS));
        offersScrollPane.setViewportView(offersPanel);

        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.9;
        gbc2.insets = new Insets(7, 7, 7, 15);
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.anchor = GridBagConstraints.NORTH;

        for (Offer offer : offers) {
            JPanel offerPanel = new BorderRadPanel(10);
            JTextArea offerTextArea = new JTextArea(offer.getOffer_name() + " - " + offer.getOffer_description() + "\nRéduction " + offer.getOffer_discount() + "€");
            offerTextArea.setOpaque(false);
            offerTextArea.setLineWrap(true);
            offerTextArea.setWrapStyleWord(true);
            offerTextArea.setEditable(false);
            offerTextArea.setPreferredSize(new Dimension(1000, 150));
            offerPanel.add(offerTextArea);

            offerPanel.setBackground(Color.decode(couleur3));
            offersPanel.add(Box.createHorizontalStrut(10));

            offersPanel.add(offerPanel);
        }


        row2.add(offersScrollPane, gbc2);

        mainPanel.add(row2, gbc);

        add(mainPanel);
    }

    public void updateOffers() {
        // Supprimer toutes les offres actuellement affichées
        offersPanel.removeAll();

        // Récupérer la liste des offres à partir de la base de données
        List<Offer> offers = offerDao.getAllOffers();

        // Parcourir la liste des offres et les ajouter au panneau
        for (Offer offer : offers) {
            JPanel offerPanel = new BorderRadPanel(10);
            JTextArea offerTextArea = new JTextArea(offer.getOffer_name() + " - " + offer.getOffer_description() + "\nRéduction " + offer.getOffer_discount() + "€");
            offerTextArea.setOpaque(false);
            offerTextArea.setLineWrap(true);
            offerTextArea.setWrapStyleWord(true);
            offerTextArea.setEditable(false);
            offerTextArea.setPreferredSize(new Dimension(1000, 150));
            offerPanel.add(offerTextArea);

            offerPanel.setBackground(Color.decode(couleur3));
            offersPanel.add(Box.createHorizontalStrut(10));

            offersPanel.add(offerPanel);
        }

        // Mettre à jour l'affichage du panneau
        offersPanel.revalidate();
        offersPanel.repaint();
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnFilms() {
        return btnFilms;
    }

    public JButton getbtnLogOut() {
        return btnLogOut;
    }

}
