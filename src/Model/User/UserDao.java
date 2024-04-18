package Model.User;


public interface UserDao {
    //Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create
    public void addUser(User user);

    // Read
    public User getUserById(int id);
    public User getUserByPseudo(String pseudo);
    public User getUserByMail(String mail);

    // Update
    public void updateUser(User user);

    // Delete
    public void deleteUserById(int id);
    public void deleteUserByPseudo(String pseudo);

    //Méthodes verifiant si un pseudo est déjà utilisé ou un mail est déjà utilisé
    public boolean DoesPseudoExist(String pseudo);
    public boolean DoesMailExist(String mail);
    public Boolean DoesPasswordExist(String mail, String password);

}
