package Controller.FilmSchedule;

import Model.Film.Film;
import Model.Film.FilmDaoImpl;
import Model.Seance.Seance;
import Model.Seance.SeanceDaoImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerFilmSchedule implements ControllerFilmScheduleInterface {

    private int CurrentSeanceId;

    public void onFilmSchedule() {

    }

    private ActionListener SeanceButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            CurrentSeanceId = Integer.parseInt(button.getName());
            System.out.println("CurrentSeanceId : " + CurrentSeanceId);
        }
    };

    public ActionListener getSeanceButtonListener() {
        return SeanceButtonListener;
    }

    public int getCurrentSeanceId() {
        return CurrentSeanceId;
    }

}
