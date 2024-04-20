package Model.Seance;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface SeanceDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addSeance(Seance seance);

    // Read
    public Seance getSeanceById(int id);

    public List<Seance> getSeanceByDateNFilmId(Date date, int film_id);

    public Seance getSeanceByTimeNFilmIdNDate(Time time, int film_id, Date date);

    // Update
    public void updateSeance(Seance seance);

    // Delete
    public void deleteSeance(Seance seance);
}
