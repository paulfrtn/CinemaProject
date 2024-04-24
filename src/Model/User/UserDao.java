package Model.User;

/**
 * Cette interface définit les opérations CRUD (Create, Read, Update, Delete) pour les utilisateurs.
 */
public interface UserDao {
    // Nous allons réaliser le CRUD (Create, Read, Update, Delete)

    // Create

    /**
     * Ajoute un nouvel utilisateur à la base de données.
     *
     * @param user L'utilisateur à ajouter
     */
    public void addUser(User user);

    // Read

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à récupérer
     * @return L'utilisateur correspondant à l'identifiant spécifié
     */
    public User getUserById(int id);

    /**
     * Récupère un utilisateur par son pseudo.
     *
     * @param pseudo Le pseudo de l'utilisateur à récupérer
     * @return L'utilisateur correspondant au pseudo spécifié
     */
    public User getUserByPseudo(String pseudo);

    /**
     * Récupère un utilisateur par son adresse e-mail.
     *
     * @param mail L'adresse e-mail de l'utilisateur à récupérer
     * @return L'utilisateur correspondant à l'adresse e-mail spécifiée
     */
    public User getUserByMail(String mail);

    // Update

    /**
     * Met à jour les informations d'un utilisateur dans la base de données.
     *
     * @param user L'utilisateur à mettre à jour
     */
    public void updateUser(User user);

    // Delete

    /**
     * Supprime un utilisateur de la base de données par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à supprimer
     */
    public void deleteUserById(int id);

    /**
     * Supprime un utilisateur de la base de données par son pseudo.
     *
     * @param pseudo Le pseudo de l'utilisateur à supprimer
     */
    public void deleteUserByPseudo(String pseudo);

    // Méthodes vérifiant si un pseudo ou un mail est déjà utilisé

    /**
     * Vérifie si un pseudo est déjà utilisé dans la base de données.
     *
     * @param pseudo Le pseudo à vérifier
     * @return true si le pseudo est déjà utilisé, sinon false
     */
    public boolean DoesPseudoExist(String pseudo);

    /**
     * Vérifie si une adresse e-mail est déjà utilisée dans la base de données.
     *
     * @param mail L'adresse e-mail à vérifier
     * @return true si l'adresse e-mail est déjà utilisée, sinon false
     */
    public boolean DoesMailExist(String mail);

    /**
     * Vérifie si un mot de passe correspond à une adresse e-mail dans la base de données.
     *
     * @param mail     L'adresse e-mail de l'utilisateur
     * @param password Le mot de passe à vérifier
     * @return true si le mot de passe correspond à l'adresse e-mail, sinon false
     */
    public Boolean DoesPasswordExist(String mail, String password);
}
