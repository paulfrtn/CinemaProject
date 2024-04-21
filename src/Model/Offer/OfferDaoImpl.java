package Model.Offer;

import Model.DataBase.ConnectionDb;
import Model.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface OfferDao pour les opérations CRUD sur les offres dans la base de données.
 */
public class OfferDaoImpl implements OfferDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    @Override
    public void addOffer(Offer offer, int user_id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "INSERT INTO offer (offer_name, offer_description, offer_start_date, offer_end_date, offer_price, offer_discount, offer_limit, offer_user_type, offer_status, user_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, offer.getOffer_name()); // Nom de l'offre
            ps.setString(2, offer.getOffer_description()); // Description de l'offre
            ps.setDate(3, (Date) offer.getOffer_start_date()); // Date de début de l'offre
            ps.setDate(4, (Date) offer.getOffer_end_date()); // Date de fin de l'offre
            ps.setFloat(5, offer.getOffer_price()); // Prix de l'offre
            ps.setFloat(6, offer.getOffer_discount()); // Réduction de l'offre
            ps.setInt(7, offer.getOffer_limit()); // Limite de l'offre
            ps.setInt(8, offer.getOffer_user_type()); // Type d'utilisateur pour l'offre
            ps.setBoolean(9, offer.getOffer_status()); // Statut de l'offre
            ps.setInt(10, user_id); // ID de l'utilisateur associé à l'offre
            ps.executeUpdate();
            System.out.println("Offre ajoutée avec succès !");
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

    // Read
    @Override
    public Offer getOfferById(int id) {
        // Code pour récupérer une offre par son id
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Offer offer = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM offer WHERE offer_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Création de l'objet Offer à partir des données récupérées de la base de données
                offer = new Offer(rs.getInt("offer_id"), rs.getString("offer_name"), rs.getString("offer_description"), rs.getDate("offer_start_date"), rs.getDate("offer_end_date"), rs.getFloat("offer_price"), rs.getFloat("offer_discount"), rs.getInt("offer_limit"), rs.getInt("offer_user_type"), rs.getBoolean("offer_status"));
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
        return offer;
    }

    @Override
    public Offer getOfferByName(String name) {
        // Code pour récupérer une offre par son nom
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Offer offer = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM offer WHERE offer_name = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Création de l'objet Offer à partir des données récupérées de la base de données
                offer = new Offer(rs.getInt("offer_id"), rs.getString("offer_name"), rs.getString("offer_description"), rs.getDate("offer_start_date"), rs.getDate("offer_end_date"), rs.getFloat("offer_price"), rs.getFloat("offer_discount"), rs.getInt("offer_limit"), rs.getInt("offer_user_type"), rs.getBoolean("offer_status"));
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
        return offer;
    }

    // Update
    @Override
    public void updateOffer(Offer offer) {
        // Code pour mettre à jour une offre
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "UPDATE offer SET offer_name = ?, offer_description = ?, offer_start_date = ?, offer_end_date = ?, offer_price = ?, offer_discount = ?, offer_limit = ?, offer_status = ? WHERE offer_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, offer.getOffer_name());
            ps.setString(2, offer.getOffer_description());
            ps.setDate(3, (Date) offer.getOffer_start_date());
            ps.setDate(4, (Date) offer.getOffer_end_date());
            ps.setFloat(5, offer.getOffer_price());
            ps.setFloat(6, offer.getOffer_discount());
            ps.setInt(7, offer.getOffer_limit());
            ps.setBoolean(8, offer.getOffer_status());
            ps.setInt(9, offer.getOffer_id());
            ps.executeUpdate();
            System.out.println("Offre mise à jour avec succès !");
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
    @Override
    public void deleteOfferbyId(int id) {
        // Code pour supprimer une offre
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM offer WHERE offer_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Offre supprimée avec succès !");
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

    @Override
    public void deleteOfferByName(String name) {
        // Code pour supprimer une offre par son nom
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDb.getConnection();
            String query = "DELETE FROM offer WHERE offer_name = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            System.out.println("Offre supprimée avec succès !");
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

    public List<Offer> getAllOffers() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Offer> offers = new ArrayList<>();

        try {
            con = ConnectionDb.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM offer");
            while (rs.next()) {
                Offer offer = new Offer(rs.getInt("offer_id"), rs.getString("offer_name"), rs.getString("offer_description"), rs.getDate("offer_start_date"), rs.getDate("offer_end_date"), rs.getFloat("offer_price"), rs.getFloat("offer_discount"), rs.getInt("offer_limit"), rs.getInt("offer_user_type"), rs.getBoolean("offer_status"));
                offers.add(offer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return offers;
    }

    public List<Offer> getOffersByUserType(int user_type) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Offer> offers = new ArrayList<>();

        try {
            con = ConnectionDb.getConnection();
            String query = "SELECT * FROM offer WHERE offer_user_type = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, user_type);
            rs = ps.executeQuery();
            while (rs.next()) {
                Offer offer = new Offer(rs.getInt("offer_id"), rs.getString("offer_name"), rs.getString("offer_description"), rs.getDate("offer_start_date"), rs.getDate("offer_end_date"), rs.getFloat("offer_price"), rs.getFloat("offer_discount"), rs.getInt("offer_limit"), rs.getInt("offer_user_type"), rs.getBoolean("offer_status"));
                offers.add(offer);
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
        return offers;
    }
}
