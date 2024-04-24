package View.ProfilPage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Cette classe représente la fenêtre des statistiques pour un utilisateur.
 */
public class Stat extends JFrame {

    /**
     * Constructeur de la classe Stat.
     *
     * @param title          Le titre de la fenêtre
     * @param CurrentUserId  L'ID de l'utilisateur actuel
     */
    public Stat(String title, int CurrentUserId) {
        super(title);

        // Connexion à la base de données
        Connection conn = null;
        PreparedStatement stmt1 = null, stmt2 = null, stmt3 = null;
        ResultSet rs1 = null, rs2 = null, rs3 = null;
        Color backgroundColor = Color.decode("#669BBC");
        int goalDuration = 500;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/Cinema", "root", "password");

            // Requête SQL pour la somme des durées des films vues par un utilisateur
            String sql1 = "SELECT SUM(film_duration) AS total_duree_vue FROM ticket " +
                    "JOIN Seance ON ticket.seance_id = Seance.seance_id " +
                    "JOIN film ON Seance.film_id = film.film_id " +
                    "WHERE ticket.user_id = ?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1, CurrentUserId);
            rs1 = stmt1.executeQuery();

            int totalDuration = 0;
            if (rs1.next()) {
                totalDuration = rs1.getInt("total_duree_vue");
            }

            DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
            dataset1.addValue(totalDuration, "Durée Réalisée", "Total durée vue");
            dataset1.addValue(goalDuration, "Objectif", "Total durée vue");

            JFreeChart chart1 = ChartFactory.createBarChart(
                    "Durée totale des films vus (Objectif: 500h)",
                    "Catégorie",
                    "Durée (en heures)",
                    dataset1,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            // Requête SQL pour la durée des films par genre
            String sql2 = "SELECT film_genre, SUM(film_duration) AS total_duree_genre " +
                    "FROM ticket " +
                    "JOIN Seance ON ticket.seance_id = Seance.seance_id " +
                    "JOIN film ON Seance.film_id = film.film_id " +
                    "WHERE ticket.user_id = ? " +
                    "GROUP BY film_genre";
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, CurrentUserId);
            rs2 = stmt2.executeQuery();

            DefaultPieDataset dataset2 = new DefaultPieDataset();
            while (rs2.next()) {
                String genre = rs2.getString("film_genre");
                int totalGenreDuration = rs2.getInt("total_duree_genre");
                dataset2.setValue(genre, totalGenreDuration);
            }

            JFreeChart chart2 = ChartFactory.createRingChart(
                    "Genre des films",
                    dataset2,
                    true,
                    true,
                    false);

            // Requête SQL pour les réservations mensuelles des 3 derniers mois
            String sql3 = "SELECT EXTRACT(YEAR FROM ticket_date) AS year, EXTRACT(MONTH FROM ticket_date) AS month, COUNT(*) AS total_reservations " +
                    "FROM ticket WHERE ticket.user_id = ? AND ticket_date BETWEEN ? AND ? GROUP BY year, month ORDER BY year, month";
            stmt3 = conn.prepareStatement(sql3);
            stmt3.setInt(1, CurrentUserId);
            LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
            stmt3.setDate(2, Date.valueOf(threeMonthsAgo));
            stmt3.setDate(3, Date.valueOf(LocalDate.now()));
            rs3 = stmt3.executeQuery();

            DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

            while (rs3.next()) {
                String monthYear = formatter.format(LocalDate.of(rs3.getInt("year"), rs3.getInt("month"), 1));
                int totalReservations = rs3.getInt("total_reservations");
                dataset3.addValue(totalReservations, "Reservations", monthYear);
            }

            JFreeChart chart3 = ChartFactory.createBarChart(
                    "Réservations des 3 derniers mois",
                    "Mois",
                    "Nbr de réservations",
                    dataset3);

            // Configuration des panneaux de graphiques
            ChartPanel chartPanel1 = new ChartPanel(chart1);
            chart1.setBackgroundPaint(backgroundColor);
            chart1.getPlot().setBackgroundPaint(backgroundColor);
            chart1.getPlot().setOutlineVisible(false);
            chartPanel1.setBackground(backgroundColor);
            chartPanel1.setBounds(0, 0, 600, 400); // Réglé pour occuper la moitié de la largeur en haut

            ChartPanel chartPanel2 = new ChartPanel(chart2);
            chart2.setBackgroundPaint(backgroundColor);
            chart2.getPlot().setBackgroundPaint(backgroundColor);
            chart2.getPlot().setOutlineVisible(false);
            chartPanel2.setBackground(backgroundColor);
            chartPanel2.setBounds(600, 0, 600, 400); // Réglé pour occuper l'autre moitié de la largeur en haut

            ChartPanel chartPanel3 = new ChartPanel(chart3);
            chart3.setBackgroundPaint(backgroundColor);
            chart3.getPlot().setBackgroundPaint(backgroundColor);
            chart3.getPlot().setOutlineVisible(false);
            chartPanel3.setBackground(backgroundColor);
            chartPanel3.setBounds(0, 400, 1200, 350); // Réglé pour occuper

            // Panneau global pour afficher les graphiques
            JPanel panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    setBackground(backgroundColor); // Couleur de fond pour le panneau global
                }
            };

            panel.setLayout(null);
            panel.add(chartPanel1);
            panel.add(chartPanel2);
            panel.add(chartPanel3);

            setContentPane(panel);
            setSize(1200, 800); // Taille de la fenêtre
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                // Fermeture des ressources
                if (rs1 != null) rs1.close();
                if (rs2 != null) rs2.close();
                if (rs3 != null) rs3.close();
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (stmt3 != null) stmt3.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la fermeture des ressources : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
