package View.ProfilPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.net.URL;

public class ViewPageProfil extends JFrame {
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblPseudo;
    private JLabel lblRole;
    private JLabel lblBirthday;
    private JLabel lblType;

    public ViewPageProfil() {
        setTitle("Votre Profil Utilisateur");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.decode("#34495e"));

        int iconSize = 24;

        lblFirstName = new JLabel("");
        lblLastName = new JLabel("");
        lblEmail = new JLabel(" Email: ");
        lblPseudo = new JLabel(" Pseudo: ");
        lblRole = new JLabel(" Role: ");
        lblBirthday = new JLabel(" Date de naissance: ");
        lblType = new JLabel(" Type d'utilisateur: ");

        lblFirstName.setFont(new Font("Arial", Font.BOLD, 24));
        lblFirstName.setForeground(Color.decode("#FFFFFF"));
        lblLastName.setFont(new Font("Arial", Font.BOLD, 24));
        lblLastName.setForeground(Color.decode("#FFFFFF"));

        getContentPane().add(Box.createVerticalStrut(80));

        JPanel UserPicPanel = new JPanel();
        UserPicPanel.setLayout(new BoxLayout(UserPicPanel, BoxLayout.Y_AXIS));
        UserPicPanel.setBackground(Color.decode("#34495e"));
        UserPicPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        UserPicPanel.add(new JLabel(loadIcon("/user.png", 100, 100)));
        UserPicPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(UserPicPanel);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.setBackground(Color.decode("#34495e"));
        namePanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        namePanel.add(lblFirstName);
        namePanel.add(lblLastName);
        namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(namePanel);


        // Spacer
        getContentPane().add(Box.createVerticalStrut(80));

        // Ensure uniform size for all panels and adding spaces between them
        Dimension panelSize = new Dimension(500, 50);
        add(createUserInfoPanel(lblEmail, loadIcon("/email.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblPseudo, loadIcon("/nickname.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblRole, loadIcon("/role.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblBirthday, loadIcon("/calendar.png", iconSize, iconSize), panelSize));
        add(createUserInfoPanel(lblType, loadIcon("/user.png", iconSize, iconSize), panelSize));

        setVisible(true);
    }

    private JPanel createUserInfoPanel(JLabel label, ImageIcon icon, Dimension size) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Using BorderLayout to better control spacing and alignment
        panel.setPreferredSize(size);
        panel.setBackground(Color.decode("#34495e"));
        panel.setMaximumSize(size);
        panel.setBorder(new EmptyBorder(10, 60, 10, 10));

        // Create a sub-panel for the icon with a different background color
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(Color.decode("#34495e")); // Set a distinct background color for the icon panel
        iconPanel.add(new JLabel(icon));
        iconPanel.setBorder((new EmptyBorder(0, 10, 0, 10)));

        // Create a sub-panel for the description
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(Color.decode("#34495e")); // You can set this to any color that fits your design
        descriptionPanel.setBorder((new EmptyBorder(0, 20, 0, 0)));

        // Set the label's properties
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.decode("#FFFFFF"));
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
        lblEmail.setText(" Email: " + email);
        lblPseudo.setText(" Pseudo: " + pseudo);
        lblRole.setText(" Role: " + role);
        lblBirthday.setText(" Date de naissance: " + birthday);
        lblType.setText(" Type d'utilisateur: " + type);
    }
}
