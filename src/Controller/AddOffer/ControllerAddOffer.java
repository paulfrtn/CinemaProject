package Controller.AddOffer;

import Model.Offer.Offer;
import Model.Offer.OfferDaoImpl;
import View.Offres.PopUpAddOffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Contrôleur pour l'ajout d'offres spéciales dans l'application.
 * Ce contrôleur gère l'interaction entre la vue d'ajout d'offres et le modèle de données pour les offres.
 */
public class ControllerAddOffer implements ControllerAddOfferInterface {
    private PopUpAddOffer view;
    private OfferDaoImpl offerDao;
    private int current_user;

    /**
     * Constructeur pour initialiser la vue, le modèle DAO, et l'identifiant de l'utilisateur actuel.
     *
     * @param view       La fenêtre popup pour l'ajout d'offres.
     * @param offerDao   L'implémentation DAO pour les opérations sur les offres.
     * @param current_user L'identifiant de l'utilisateur qui crée l'offre.
     */
    public ControllerAddOffer(PopUpAddOffer view, OfferDaoImpl offerDao, int current_user) {
        this.view = view;
        this.offerDao = offerDao;
        this.current_user = current_user;
        this.view.addAddButtonListener(new AddButtonListener());
    }

    /**
     * Affiche la vue dans le thread d'interface utilisateur Swing.
     */
    public void start() {
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    /**
     * Classe interne pour écouter et gérer les actions sur le bouton d'ajout d'offre.
     */
    private class AddButtonListener implements ActionListener {
        /**
         * Méthode appelée lors du clic sur le bouton d'ajout d'offre.
         * Elle extrait les informations du formulaire, crée une nouvelle offre et la stocke dans la base de données.
         *
         * @param e Événement d'action déclenché par le clic sur le bouton.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Récupérer les données de la vue
                String name = view.getNameField();
                String description = view.getDescriptionArea();
                Date startDate = Date.valueOf(view.getStartDateField());
                Date endDate = Date.valueOf(view.getEndDateField());
                float discount = Float.parseFloat(view.getDiscountField());
                int userType = Integer.parseInt(view.getUserTypeField());

                // Création de l'objet Offre
                Offer offer = new Offer(name, description, startDate, endDate, 0, discount, 0, userType, true, current_user);

                // Ajouter l'offre à la base de données
                offerDao.addOffer(offer, userType);

                // Afficher un message de succès
                JOptionPane.showMessageDialog(view, "L'offre a été ajoutée avec succès !");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erreur lors de l'ajout de l'offre : " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Créer et configurer les composants nécessaires pour le contrôleur
        PopUpAddOffer view = new PopUpAddOffer();
        OfferDaoImpl offerDao = new OfferDaoImpl();
        ControllerAddOffer controller = new ControllerAddOffer(view, offerDao, 5);
        controller.start();
    }
}
