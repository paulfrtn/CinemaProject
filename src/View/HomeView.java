package View;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import View.BorderRadCompenent.RoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class HomeView extends JFrame {
    private JPanel mainPanel;
    private JButton btnFilms;
    private JButton btnProfile;

    private JButton btnSearch;

    private JButton btnOffers;
    private JCarousel carouselNowShowing;
    private JCarousel carouselPremieres;
    private JCarousel carouselComingSoon;

    private JTextField searchField;



    public HomeView(List<Film> nowShowingFilms, List<Film> premieresFilms, List<Film> comingSoonFilms, int filmLimit) {
        super("Home Page");

        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800); // Définissez la taille souhaitée ici
        setResizable(false);

        mainPanel = new JPanel(new BorderLayout());
        Color bgColor = new Color(0x2a2d43);
        mainPanel.setBackground(bgColor);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(bgColor);

        ImageIcon logoIcon = new ImageIcon("src/Model/Images/logo.jpg");
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logo = new JLabel(scaledLogoIcon);

        btnFilms = new JButton("Films");
        btnFilms.setBackground(Color.decode("#7A82AB"));
        btnProfile = new JButton("Profil");
        btnProfile.setBackground(Color.decode("#7A82AB"));

        btnOffers = new JButton("Offres");
        btnOffers.setBackground(Color.decode("#7A82AB"));

        btnFilms.addActionListener(e -> {
            FilmDaoImpl filmDao = null;
            filmDao = new FilmDaoImpl();
            List<Film> films = filmDao.getAllFilms();
            StringBuilder filmList = new StringBuilder();
            for (Film film : films) {
                filmList.append(film.getFilm_title()).append("\n");
            }
            JOptionPane.showMessageDialog(this, filmList, "Liste des Films", JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel searchPanel;
        searchPanel = new JPanel(new BorderLayout());

        searchField = new JTextField(30);
        btnSearch = new JButton("Rechercher");
        btnSearch.setBackground(Color.decode("#7A82AB"));
        // Ajoutez le champ de texte et le bouton de recherche au panneau de recherche
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(btnSearch, BorderLayout.EAST);
// Ajoutez le panneau de recherche à topPanel
        topPanel.add(searchPanel, BorderLayout.EAST);



        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(btnSearch, BorderLayout.EAST);
        searchPanel.setVisible(false);

        btnSearch.addActionListener(e -> {
            // Afficher une boîte de dialogue pour saisir le texte de recherche
            String searchText = JOptionPane.showInputDialog(this, "Entrez le titre du film à rechercher:");

            if (searchText != null && !searchText.trim().isEmpty()) {
                FilmDaoImpl filmDao;
                filmDao = new FilmDaoImpl();
                Film film = filmDao.getFilmByTitle(searchText.trim());
                if (film != null) {
                    JOptionPane.showMessageDialog(this, "Film trouvé : " + film.getFilm_title() +
                            "\nRéalisateur: " + film.getFilm_director() +
                            "\nGenre: " + film.getFilm_genre(), "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Aucun film trouvé avec ce titre.", "Résultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "La recherche ne peut être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });


        topPanel.add(searchPanel, BorderLayout.EAST);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(logo);
        leftPanel.add(btnFilms);
        leftPanel.add(btnSearch);
        leftPanel.add(btnOffers);
        leftPanel.setBackground(bgColor);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(btnProfile);
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        rightPanel.setBackground(bgColor);

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        carouselNowShowing = new JCarousel("Now Showing", nowShowingFilms.subList(0, Math.min(nowShowingFilms.size(), filmLimit)));

        carouselPremieres = new JCarousel("Premieres", premieresFilms.subList(0, Math.min(premieresFilms.size(), filmLimit)));
        carouselComingSoon = new JCarousel("Coming Soon", comingSoonFilms.subList(0, Math.min(comingSoonFilms.size(), filmLimit)));

        JPanel carouselPanel = new JPanel(new GridLayout(3, 1));
        carouselPanel.add(carouselNowShowing);
        carouselPanel.add(carouselPremieres);
        carouselPanel.add(carouselComingSoon);

        mainPanel.add(carouselPanel, BorderLayout.CENTER);
        this.add(mainPanel);



        //pack();
        add(mainPanel);
        setSize(1200, 800);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);
    }



}

// Classe JCarousel pour les panneaux de carrousel
class JCarousel extends JPanel {
    private JPanel filmsPanel;

    public JCarousel(String category, List<Film> films) {



        setLayout(new BorderLayout());
        JLabel label = new JLabel(category);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        label.setBackground(Color.decode("#7A82AB"));
        label.setOpaque(true);
        add(label, BorderLayout.NORTH);

        JButton btnPrevious = new RoundButton("<");
        btnPrevious.setBackground(Color.decode("#7A82AB"));
        btnPrevious.setPreferredSize(new Dimension(50, 50));

        JButton btnNext = new RoundButton(">");
        btnNext.setBackground(Color.decode("#7A82AB"));
        btnNext.setPreferredSize(new Dimension(50, 50));

        JPanel previousPanel = new JPanel(new GridBagLayout());
        previousPanel.add(btnPrevious);
        previousPanel.setBackground(new Color(0x2a2d43));

        JPanel nextPanel = new JPanel(new GridBagLayout());
        nextPanel.add(btnNext);
        nextPanel.setBackground(new Color(0x2a2d43));

        // Utiliser un FlowLayout pour permettre aux films de s'afficher côte à côte
        // Dans votre JCarousel, quand vous initialisez filmsPanel
        filmsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        filmsPanel.setBackground(new Color(0x2a2d43));

        for (Film film : films) {
            addFilm(film);
        }

        JScrollPane scrollPane = new JScrollPane(filmsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(0x2a2d43));
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
                Graphics2D g2d = (Graphics2D) g;

                int x = (this.getWidth() - scaledIcon.getIconWidth()) / 2;
                int y = (this.getHeight() - scaledIcon.getIconHeight()) / 2;

                float borderWidth = 3.0f;
                g2d.setStroke(new BasicStroke(borderWidth));
                scaledIcon.paintIcon(this, g2d, x, y);


                // Dessiner une bordure noire autour de l'image
                g.setColor(Color.BLACK);
                g.drawRect(x, y, scaledIcon.getIconWidth() - 1, scaledIcon.getIconHeight() - 1);
            }
        };


        int borderWidth = 3; // Doit correspondre à la valeur de borderWidth dans paintComponent
        lblImage.setPreferredSize(new Dimension(scaledIcon.getIconWidth() + borderWidth, scaledIcon.getIconHeight() + borderWidth));


        // Créer un JLabel pour le titre avec un texte HTML pour forcer le retour à la ligne
        JLabel lblTitle = new JLabel("<html><center>" + film.getFilm_title() + "</center></html>");
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

        Color bgColor = new Color(0x2a2d43);
        filmPanel.setBackground(bgColor);

        filmPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(filmPanel, "Film ID: " + film.getFilm_id());
            }
        });


        filmsPanel.add(filmPanel);
        filmsPanel.revalidate();
        filmsPanel.repaint();

    }



}
