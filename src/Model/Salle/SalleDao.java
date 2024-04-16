package Model.Salle;

public interface SalleDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addSalle(Salle salle);

    // Read
    /*public Salle getSalleById(int id);*/

    public Salle getSalleByNumber(int number);

    // Update
    public void updateSalle(Salle salle);

    // Delete
    public void deleteSalle(Salle salle);
}
