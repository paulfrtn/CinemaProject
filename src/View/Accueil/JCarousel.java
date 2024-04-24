package View.Accueil;

import Controller.MainFrame;
import Model.Film.Film;
import View.BorderRadCompenent.BorderRadButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

/**
 * La classe JCarousel est une représentation de l'affichage en carrousel de films.
 */
public class JCarousel extends JPanel{
    private JPanel filmsPanel;
    private MainFrame controller;
    private ActionListener listener;
    private String couleur1;
    private String couleur2;
    private String couleur3;

    /**
     * Crée une instance de la classe JCarousel.
     * @param controller Le contrôleur de l'application.
     * @param category La catégorie des films à afficher.
     * @param films La liste des films à afficher dans le carrousel.
     */
    public JCarousel(MainFrame controller, String category, List<Film> films) {

        this.controller = controller;
        this.listener = controller.getFilmButtonListener();
        couleur1 = "#003049";
        couleur2 = "#669BBC";
        couleur3 = "#FDF0D5";


        setLayout(new BorderLayout());
        JLabel label = new JLabel(category);
        label.setOpaque(false);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        label.setBackground(Color.decode(couleur1));
        label.setOpaque(true);
        add(label, BorderLayout.NORTH);

        JButton btnPrevious = new BorderRadButton("<",50);
        btnPrevious.setBackground(Color.decode(couleur2));
        btnPrevious.setPreferredSize(new Dimension(50, 50));

        JButton btnNext = new BorderRadButton(">",50);
        btnNext.setBackground(Color.decode(couleur2));
        btnNext.setPreferredSize(new Dimension(50, 50));

        JPanel previousPanel = new JPanel(new GridBagLayout());
        //previousPanel.setOpaque(false);
        previousPanel.add(btnPrevious);
        previousPanel.setBackground(Color.decode(couleur1));

        JPanel nextPanel = new JPanel(new GridBagLayout());
        //nextPanel.setOpaque(false);
        nextPanel.add(btnNext);
        nextPanel.setBackground(Color.decode(couleur1));

        // Utiliser un FlowLayout pour permettre aux films de s'afficher côte à côte
        filmsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, (5), 10));
        filmsPanel.setBackground(Color.decode(couleur1));

        for (Film film : films) {
            addFilm(film);
        }

        JScrollPane scrollPane = new JScrollPane(filmsPanel);
        scrollPane.setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(Color.decode(couleur1));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());


        // Action listeners pour les boutons de navigation
        btnPrevious.addActionListener(e -> {
            // Code pour déplacer la vue du JScrollPane vers la gauche
            Rectangle visible = scrollPane.getViewport().getViewRect();
            visible.x = Math.max(visible.x - visible.width, 0);
            filmsPanel.scrollRectToVisible(visible);
        });

        btnNext.addActionListener(e -> {
            // Code pour déplacer la vue du JScrollPane vers la droite
            Rectangle visible = scrollPane.getViewport().getViewRect();
            visible.x = Math.min(visible.x + visible.width, filmsPanel.getPreferredSize().width - visible.width);
            filmsPanel.scrollRectToVisible(visible);
        });

        add(previousPanel, BorderLayout.WEST);
        add(nextPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);
        add(label, BorderLayout.NORTH);
    }

    private void addFilm(Film film) {
        ImageIcon originalIcon = new ImageIcon(film.getFilm_poster());
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 150, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);


        JLabel lblImage = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                int x = (this.getWidth() - scaledIcon.getIconWidth()) / 2;
                int y = (this.getHeight() - scaledIcon.getIconHeight()) / 2;
                int width = scaledIcon.getIconWidth();
                int height = scaledIcon.getIconHeight();

                float borderWidth = 3.0f;
                g2d.setStroke(new BasicStroke(borderWidth));
                g2d.setColor(Color.BLACK);

                // Définir le clip pour éviter que l'image ne dépasse la bordure
                g2d.setClip(new RoundRectangle2D.Double(x, y, width, height, 10, 10));
                scaledIcon.paintIcon(this, g2d, x, y);

                // Dessiner une bordure arrondie autour de l'image
                g2d.drawRoundRect(x, y, width - 1, height - 1, 10, 10);
                g2d.dispose();
            }
        };

        int borderWidth = 3;// Doit correspondre à la valeur de borderWidth dans paintComponent
        lblImage.setPreferredSize(new Dimension(scaledIcon.getIconWidth() + borderWidth, scaledIcon.getIconHeight() + borderWidth));


        // Créer un JLabel pour le titre avec un texte HTML pour forcer le retour à la ligne
        JLabel lblTitle = new JLabel("<html><center>" + film.getFilm_title() + "</center></html>");
        lblTitle.setOpaque(false);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(UIManager.getFont("Label.font"));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);


        lblTitle.setMaximumSize(new Dimension(200, 60));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));
        titlePanel.add(Box.createVerticalGlue()); // Ajouter un espace avant le titre
        titlePanel.add(lblTitle); // Ajouter le label au panel
        titlePanel.add(Box.createVerticalGlue()); // Ajouter un espace après le titre
        titlePanel.setOpaque(false);

        JPanel filmPanel = new JPanel(new BorderLayout());
        filmPanel.add(lblImage, BorderLayout.CENTER);
        filmPanel.add(titlePanel, BorderLayout.SOUTH);
        filmPanel.setName(String.valueOf(film.getFilm_id()));

        Color bgColor = Color.decode(couleur1);
        filmPanel.setBackground(bgColor);

        filmsPanel.add(filmPanel);
        addFilmListener();


        filmsPanel.revalidate();
        filmsPanel.repaint();

    }

    /**
     * Ajoute un ActionListener aux films du carrousel.
     */
    public void addFilmListener() {
        for (Component component : filmsPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel filmPanel = (JPanel) component;
                // Retirer tous les MouseListeners existants
                for (MouseListener listener : filmPanel.getMouseListeners()) {
                    filmPanel.removeMouseListener(listener);
                }
                // Ajouter un nouveau MouseListener
                filmPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (controller.getFilmButtonListener() != null) {
                            controller.getFilmButtonListener().actionPerformed(new ActionEvent(filmPanel, ActionEvent.ACTION_PERFORMED, null));
                        }
                    }
                });
            }
        }
    }

    /**
     * Définit l'ActionListener pour les films du carrousel.
     * @param listener L'ActionListener à définir.
     */
    public void setFilmButtonListener(ActionListener listener) {
        this.listener = listener;
    }

}
