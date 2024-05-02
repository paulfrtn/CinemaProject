package Model.Ticket;

import Model.DataBase.ConnectionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe implémente l'interface TicketDao et fournit les opérations CRUD pour les tickets.
 */
public class TicketDaoImpl {
    // Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute un nouveau ticket à la base de données.
     *
     * @param ticket Le ticket à ajouter
     */
    public void addTicket(Ticket ticket) {
        Connection connection = null;
        try {
            connection = ConnectionDb.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ticket (ticket_date, ticket_status, ticket_price, user_id, seance_id, offer_id, mail) VALUES (?, ?, ?, ?, ?, ?,?)");
            ps.setDate(1, (Date) ticket.getTicket_date());
            ps.setBoolean(2, ticket.getTicket_status());
            ps.setInt(3, ticket.getTicket_price());
            ps.setInt(4, ticket.getUser_id());
            ps.setInt(5, ticket.getSeance_id());
            ps.setInt(6, ticket.getOffer_id());
            ps.setString(7, ticket.getMail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void addTicket2(Ticket ticket) {
        Connection connection = null;
        try {
            connection = ConnectionDb.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ticket (ticket_date, ticket_status, ticket_price, seance_id, user_id, mail) VALUES (?, ?, ?, ?, ?,?)");
            ps.setDate(1, (Date) ticket.getTicket_date());
            ps.setBoolean(2, ticket.getTicket_status());
            ps.setInt(3, ticket.getTicket_price());
            ps.setInt(4, ticket.getSeance_id());
            ps.setInt(5, ticket.getUser_id());
            ps.setString(6, ticket.getMail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addTicket3(Ticket ticket) {
        Connection connection = null;
        try {
            connection = ConnectionDb.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ticket (ticket_date, ticket_status, ticket_price, seance_id, mail) VALUES (?, ?, ?, ?, ?)");
            ps.setDate(1, (Date) ticket.getTicket_date());
            ps.setBoolean(2, ticket.getTicket_status());
            ps.setInt(3, ticket.getTicket_price());
            ps.setInt(4, ticket.getSeance_id());
            ps.setString(5, ticket.getMail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Read

    /**
     * Récupère un ticket par son identifiant.
     *
     * @param id L'identifiant du ticket à récupérer
     * @return Le ticket correspondant à l'identifiant spécifié
     */
    public Ticket getTicketById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ticket ticket = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM ticket WHERE ticket_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ticket = new Ticket(rs.getInt("ticket_id"), rs.getDate("ticket_date"), rs.getBoolean("ticket_status"), rs.getInt("ticket_price"), rs.getInt("user_id"), rs.getInt("seance_id"), rs.getInt("offer_id"), rs.getString("mail"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ticket;
    }

    /**
     * Récupère une liste de tickets pour un utilisateur donné.
     *
     * @param userId L'identifiant de l'utilisateur pour lequel récupérer les tickets
     * @return Une liste de tickets pour l'utilisateur spécifié
     */
    public List<Ticket> getTicketsByUserId(int userId) {
        List<Ticket> tickets = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM ticket WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("ticket_id"),
                        rs.getDate("ticket_date"),
                        rs.getBoolean("ticket_status"),
                        rs.getInt("ticket_price"),
                        rs.getInt("user_id"),
                        rs.getInt("seance_id"),
                        rs.getInt("offer_id"),
                        rs.getString("mail")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tickets;
    }

    /**
     * Récupère une liste de tickets pour une date donnée.
     *
     * @param date La date pour laquelle récupérer les tickets
     * @return Une liste de tickets pour la date spécifiée
     */
    public List<Ticket> getTicketByDate(Date date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Ticket> tickets = new ArrayList<>();
        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM ticket WHERE ticket_date = ?";
            ps = con.prepareStatement(query);
            ps.setDate(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getInt("ticket_id"), rs.getDate("ticket_date"), rs.getBoolean("ticket_status"), rs.getInt("ticket_price"), rs.getInt("user_id"), rs.getInt("seance_id"), rs.getInt("offer_id"), rs.getString("mail"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tickets;
    }

    // Update

    /**
     * Met à jour les informations d'un ticket dans la base de données.
     *
     * @param ticket Le ticket à mettre à jour
     */
    public void updateTicket(Ticket ticket) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "UPDATE ticket SET ticket_date = ?, ticket_status = ?, ticket_price = ?, user_id = ?, seance_id = ?, offer_id = ? WHERE ticket_id = ?";
            ps = con.prepareStatement(query);
            ps.setDate(1, (Date) ticket.getTicket_date());
            ps.setBoolean(2, ticket.getTicket_status());
            ps.setInt(3, ticket.getTicket_price());
            ps.setInt(4, ticket.getUser_id());
            ps.setInt(5, ticket.getSeance_id());
            ps.setInt(6, ticket.getOffer_id());
            ps.setInt(7, ticket.getTicket_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Delete

    /**
     * Supprime un ticket de la base de données.
     *
     * @param id L'identifiant du ticket à supprimer
     */
    public void deleteTicketById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM ticket WHERE ticket_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

