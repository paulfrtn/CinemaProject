package Model.Seance;

public interface SeanceDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addSeance(Seance seance);

    // Read
    public Seance getSeanceById(int id);
    // Update
    public void updateSeance(Seance seance);

    // Delete
    public void deleteSeance(Seance seance);
}
