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

public class ControllerAddOffer implements ControllerAddOfferInterface {
    private PopUpAddOffer view;
    private OfferDaoImpl offerDao;
    private int current_user;

    public ControllerAddOffer(PopUpAddOffer view, OfferDaoImpl offerDao, int current_user) {
        this.view = view;
        this.offerDao = offerDao;
        this.current_user = current_user;
        this.view.addAddButtonListener(new AddButtonListener());
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Récupérer les données de la vue
            String name = view.getNameField();
            String description = view.getDescriptionArea();
            Date startDate = Date.valueOf(view.getStartDateField());
            Date endDate = Date.valueOf(view.getEndDateField());
            float discount = Float.parseFloat(view.getDiscountField());
            int userType = Integer.parseInt(view.getUserTypeField());
            boolean status = true; // Valeur par défaut pour le statut de l'offre

            // Créer un objet Offre
            Offer offer = new Offer(name, description, startDate, endDate, 0, discount, 0, userType, status, current_user);

            // Ajouter l'offre à la base de données
            offerDao.addOffer(offer, userType);

            // Afficher un message de succès
            JOptionPane.showMessageDialog(view, "L'offre a été ajoutée avec succès !");
        }
    }

    public static void main(String[] args) {
        // Créer une instance de la vue
        PopUpAddOffer view = new PopUpAddOffer();
        // Créer une instance du DAO des offres
        OfferDaoImpl offerDao = new OfferDaoImpl();
        // Créer une instance du contrôleur
        ControllerAddOffer controller = new ControllerAddOffer(view, offerDao, 5);
        // Démarrer l'interface utilisateur
        controller.start();
    }
}
