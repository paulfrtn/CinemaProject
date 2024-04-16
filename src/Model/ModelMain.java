package Model;

import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ModelMain {
    public static void main(String[] args) {
        SeanceDaoImpl seanceDao = new SeanceDaoImpl();

        // Créer un nouvel objet Seance
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 16, 19, 30); // Date et heure arbitraires pour la séance
        Date seanceDate = calendar.getTime();
        Time seanceTime = new Time(calendar.getTimeInMillis());

        Seance newSeance = new Seance(0, seanceDate, seanceTime, "Français", 0, 5, 1); // Remplacez les ID de film et de salle par des valeurs réelles

        // Ajouter la séance dans la base de données
        seanceDao.addSeance(newSeance);
        System.out.println("Séance ajoutée à la base de données.");

        // Récupérer la séance par son ID
        Seance fetchedSeance = seanceDao.getSeanceById(4); // Remplacez par l'ID réel après l'insertion
        Seance fetchedSeance2 = seanceDao.getSeanceById(7);
        if (fetchedSeance != null) {
            System.out.println("Séance récupérée : " + fetchedSeance.toString());
        }

        // Mettre à jour la séance
        if (fetchedSeance2 != null) {
            fetchedSeance2.setSeance_nb_reservation(10000); // Mettre à jour le nombre de réservations
            seanceDao.updateSeance(fetchedSeance2);
            System.out.println("Séance mise à jour.");
        }

        // Supprimer la séance
        if (fetchedSeance != null) {
            seanceDao.deleteSeance(fetchedSeance);
            System.out.println("Séance supprimée.");
        }
    }
}
