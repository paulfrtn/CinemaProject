package Model.User;

public interface UserDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addUser(User user);
    public void addAdmin(User user);

    // Read
    public User getUserById(int id);
    public User getUserByPseudo(String pseudo);
    public User getUserByMail(String mail);

    // Update
    public void updateUser(User user);

    // Delete
    public void deleteUser(User user);
    public void deleteAdmin(User user);

}
