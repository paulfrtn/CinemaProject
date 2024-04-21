package Model.Ticket;

import Model.DataBase.ConnectionDb;
import Model.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    // Read
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
            System.out.println(date);
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
