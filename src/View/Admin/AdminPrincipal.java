package View.Admin;

import Model.Seance.SeanceDaoImpl;
import View.BandeADiffuser;
import View.BorderRadCompenent.BorderRadButton;
import View.BorderRadCompenent.BorderRadLabel;

import javax.swing.*;
import java.awt.*;

public class AdminPrincipal extends JPanel {
    String couleur;
    String couleur2;
    String couleur3;
    private JPanel mainPanel;
    private JButton btnSearch;
    private JButton btnFilms;
    private JButton btnOffers;
    private JButton btnProfile;

    public AdminPrincipal() {
        couleur = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";

        setBackground(Color.decode(couleur));
        setLayout(new GridBagLayout());

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode(couleur3));
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.gridwidth = 1;
        gbcMain.weightx = 1;
        gbcMain.weighty = 1;
        gbcMain.fill = GridBagConstraints.BOTH;

        add(mainPanel, gbcMain);

        JPanel row1 = new JPanel(new BorderLayout());
        row1.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
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
        mainPanel.add(row1, gbc);


        JPanel row2 = new JPanel(new BorderLayout());
        row2.setOpaque(false);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 0.99;
        gbc2.insets = new Insets(7, 7, 7, 7);
        gbc2.fill = GridBagConstraints.BOTH;


        mainPanel.add(row2, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Admin Principal");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new AdminPrincipal());
                frame.setSize(1200, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
