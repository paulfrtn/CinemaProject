package View.ProfilPage;

import Controller.ProfilPage.SeanceDetails;
import View.BorderRadCompenent.BorderRadLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.List;

public class ViewPageProfil extends JFrame {
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblPseudo;
    private JLabel lblRole;
    private JLabel lblBirthday;
    private JLabel lblType;
    private JLabel lblFilm;
    private JLabel lblDateSeance;
    private JLabel lblLanguageFilm;
    private ImageIcon Poster;

    private String couleur1;
    private String couleur2;
    private String couleur3;

    public ViewPageProfil() {
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";

        setTitle("Votre Profil Utilisateur");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.decode(couleur1));

        lblFirstName = new JLabel("");
        lblLastName = new JLabel("");
        lblEmail = new JLabel(" Email: ");
        lblPseudo = new JLabel(" Pseudo: ");
        lblRole = new JLabel(" Role: ");
        lblBirthday = new JLabel(" Date de naissance: ");
        lblType = new JLabel(" Type d'utilisateur: ");
        lblFilm = new JLabel(" Film: ");
        lblDateSeance = new JLabel(" Date de la séance: ");
        lblLanguageFilm = new JLabel(" Langue du film: ");
        Poster = new ImageIcon();

        lblFirstName.setFont(new Font("Arial", Font.BOLD, 24));
        lblFirstName.setForeground(Color.decode(couleur3));
        lblLastName.setFont(new Font("Arial", Font.BOLD, 24));
        lblLastName.setForeground(Color.decode(couleur3));

        int iconSize = 24;

        getContentPane().add(Box.createVerticalStrut(40));

        JPanel UserPicPanel = new JPanel();
        UserPicPanel.setLayout(new BoxLayout(UserPicPanel, BoxLayout.Y_AXIS));
        UserPicPanel.setBackground(Color.decode(couleur1));
        UserPicPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        UserPicPanel.add(new JLabel(loadIcon("/user.png", 100, 100)));
        UserPicPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(UserPicPanel);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.setBackground(Color.decode(couleur1));
        namePanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        namePanel.add(lblFirstName);
        namePanel.add(lblLastName);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(namePanel);


        // Spacer
        getContentPane().add(Box.createVerticalStrut(20));

        // Ensure uniform size for all panels and adding spaces between them
        Dimension panelSize = new Dimension(500, 50);
        add(createUserInfoPanel(lblPseudo, loadIcon("/nickname.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblEmail, loadIcon("/email.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblBirthday, loadIcon("/calendar.png", iconSize, iconSize), panelSize));
        getContentPane().add(Box.createVerticalStrut(30));

        setVisible(true);
    }

    public void DisplaySeances(List<SeanceDetails> seanceDetails){
        JPanel SeancePanel = new JPanel();
        Dimension panelSeanceSize = new Dimension(1000, 300);
        SeancePanel.setLayout(new BorderLayout());
        SeancePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        SeancePanel.setBackground(Color.decode(couleur1));
        SeancePanel.setPreferredSize(panelSeanceSize);
        SeancePanel.setMaximumSize(panelSeanceSize);
        getContentPane().add(SeancePanel);

        JPanel SeancePanelHeader = new JPanel();
        SeancePanelHeader.setLayout(new BoxLayout(SeancePanelHeader, BoxLayout.Y_AXIS));
        SeancePanelHeader.setBackground(Color.decode(couleur1));
        JLabel SeanceHeader = new JLabel("Vos séances à venir :");
        SeanceHeader.setFont(new Font("Arial", Font.BOLD, 20));
        SeanceHeader.setForeground(Color.decode(couleur3));

        JPanel SeancePanelBody = new JPanel();
        SeancePanelBody.setLayout(new BoxLayout(SeancePanelBody, BoxLayout.X_AXIS));
        SeancePanelBody.setBackground(Color.decode(couleur1));
        SeancePanelBody.setBorder(new EmptyBorder(30, 10, 10, 10));

        SeancePanel.add(SeancePanelHeader, BorderLayout.NORTH);
        SeancePanel.add(SeancePanelBody, BorderLayout.CENTER);

        SeancePanelHeader.add(SeanceHeader);

        for(SeanceDetails seance : seanceDetails){

            JLabel lblFilm = new JLabel("<html><div style='text-align: center;'>" + seance.getTitreFilm() + "</div></html>");
            JLabel lblDateSeance = new JLabel(seance.getDateSeance().toString());
            JLabel lblLanguageFilm = new JLabel(seance.getLangage());

            JPanel CardSeance = new JPanel();
            CardSeance.setLayout(new BorderLayout());
            CardSeance.setBackground(Color.decode(couleur1));
            CardSeance.setPreferredSize(new Dimension(140, 300));
            CardSeance.setMaximumSize(new Dimension(140, 300));

            JLabel posterLabel = new JLabel(Poster);
            CardSeance.add(posterLabel, BorderLayout.NORTH);
            try {
                BufferedImage posterImage = ImageIO.read(new File(seance.getPosterFilm()));
                Image resizedImage = posterImage.getScaledInstance(100, 120, Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(resizedImage);
                JLabel imageLabel = new JLabel(icon);
                CardSeance.add(imageLabel, BorderLayout.NORTH);
            }catch (Exception e){
                System.err.println("Échec du chargement de l'image pour le poster : " + seance.getPosterFilm());
            }

            JPanel SeanceInfo = new JPanel();
            SeanceInfo.setLayout(new BoxLayout(SeanceInfo, BoxLayout.Y_AXIS));
            SeanceInfo.setBackground(Color.decode(couleur1));

            CardSeance.add(SeanceInfo, BorderLayout.CENTER);
            SeanceInfo.add(Box.createVerticalStrut(10));
            SeanceInfo.add(createUserSeancePanelTitle(lblFilm, panelSeanceSize), BorderLayout.CENTER);
            SeanceInfo.add(Box.createVerticalStrut(10));
            SeanceInfo.add(createUserSeancePanelInfo(lblDateSeance, panelSeanceSize), BorderLayout.CENTER);
            SeanceInfo.add(createUserSeancePanelInfo(lblLanguageFilm, panelSeanceSize), BorderLayout.CENTER);

            SeancePanelBody.add(CardSeance);
        }

    }

    private JPanel createUserSeancePanelInfo(JLabel label, Dimension size){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.decode(couleur1));
        panel.add(label, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(Color.decode(couleur3));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return panel;
    }

    private JPanel createUserSeancePanelTitle(JLabel label, Dimension size){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.decode(couleur1));
        panel.add(label, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.decode(couleur3));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return panel;
    }

    private JPanel createUserInfoPanel(JLabel label, ImageIcon icon, Dimension size) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Using BorderLayout to better control spacing and alignment
        panel.setPreferredSize(size);
        panel.setBackground(Color.decode(couleur1));
        panel.setMaximumSize(size);
        panel.setBorder(new EmptyBorder(10, 60, 10, 10));

        // Create a sub-panel for the icon with a different background color
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(Color.decode(couleur1)); // Set a distinct background color for the icon panel
        iconPanel.add(new JLabel(icon));
        iconPanel.setBorder((new EmptyBorder(0, 10, 0, 10)));

        // Create a sub-panel for the description
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(Color.decode(couleur1)); // You can set this to any color that fits your design
        descriptionPanel.setBorder((new EmptyBorder(0, 20, 0, 0)));

        // Set the label's properties
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.decode(couleur3));
        descriptionPanel.add(label, BorderLayout.CENTER); // Add the label to the description panel

        // Adding components to the main panel
        panel.add(iconPanel, BorderLayout.WEST);
        panel.add(descriptionPanel, BorderLayout.CENTER);

        getContentPane().add(Box.createVerticalStrut(10));

        return panel;
    }



    private ImageIcon loadIcon(String iconPath, int width, int height) {
        URL imageUrl = getClass().getResource(iconPath);
        if (imageUrl == null) {
            System.err.println("L'icône n'a pas été trouvée au chemin : " + iconPath);
            return null;
        }
        ImageIcon icon = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return icon;
    }

    public void setUserProfile(String firstName, String lastName, String email, String pseudo, Boolean role, String birthday, String type) {
        lblFirstName.setText(firstName+" ");
        lblLastName.setText(lastName);
        lblPseudo.setText(" Pseudo: " + pseudo);
        lblEmail.setText(" Email: " + email);
        lblBirthday.setText(" Date de naissance: " + birthday);
    }
}
