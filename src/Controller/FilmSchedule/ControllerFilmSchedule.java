package Controller.FilmSchedule;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for managing the film schedule within the application.
 * This controller handles interactions related to scheduling and selecting seances for films.
 */
public class ControllerFilmSchedule implements ControllerFilmScheduleInterface {

    private int CurrentSeanceId;

    /**
     * Method to perform actions related to the film scheduling. Currently not implemented.
     */
    public void onFilmSchedule() {
        // Currently empty, placeholder for future implementation
    }

    /**
     * Action listener for seance selection buttons. Each button is associated with a seance.
     * When a button is pressed, this listener updates the current seance ID based on the button's name attribute,
     * which should correspond to the seance's ID.
     */
    private ActionListener SeanceButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            CurrentSeanceId = Integer.parseInt(button.getName());
        }
    };

    /**
     * Getter for the action listener that handles seance button clicks.
     * @return An instance of ActionListener that can be attached to seance buttons.
     */
    public ActionListener getSeanceButtonListener() {
        return SeanceButtonListener;
    }

    /**
     * Getter for the current seance ID that has been selected.
     * @return the ID of the currently selected seance.
     */
    public int getCurrentSeanceId() {
        return CurrentSeanceId;
    }

}
