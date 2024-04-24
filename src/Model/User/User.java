package Model.User;

import java.sql.Date;

/**
 * Cette classe représente un utilisateur.
 */
public class User {
    private int user_id; // Identifiant unique de l'utilisateur
    private String user_firstname; // Prénom de l'utilisateur
    private String user_lastname; // Nom de famille de l'utilisateur
    private String user_mail; // Adresse e-mail de l'utilisateur
    private String user_pseudo; // Pseudo de l'utilisateur
    private String user_password; // Mot de passe de l'utilisateur
    private Boolean user_role; // Rôle de l'utilisateur (true = administrateur, false = utilisateur standard)
    private Date user_birthday; // Date de naissance de l'utilisateur
    private int user_type; // Type de l'utilisateur
    private String user_token; // Token de l'utilisateur (peut être utilisé pour l'authentification ou d'autres fins)

    /**
     * Constructeur pour créer un nouvel utilisateur.
     *
     * @param user_firstname Prénom de l'utilisateur
     * @param user_lastname  Nom de famille de l'utilisateur
     * @param user_mail      Adresse e-mail de l'utilisateur
     * @param user_pseudo    Pseudo de l'utilisateur
     * @param user_password  Mot de passe de l'utilisateur
     * @param user_role      Rôle de l'utilisateur
     * @param user_birthday  Date de naissance de l'utilisateur
     * @param user_type      Type de l'utilisateur
     */
    public User(String user_firstname, String user_lastname, String user_mail, String user_pseudo, String user_password, Boolean user_role, Date user_birthday, int user_type) {
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_mail = user_mail;
        this.user_pseudo = user_pseudo;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_birthday = user_birthday;
        this.user_type = user_type;
    }

    /**
     * Constructeur pour créer un utilisateur avec un identifiant spécifique.
     *
     * @param id             Identifiant unique de l'utilisateur
     * @param user_firstname Prénom de l'utilisateur
     * @param user_lastname  Nom de famille de l'utilisateur
     * @param user_mail      Adresse e-mail de l'utilisateur
     * @param user_pseudo    Pseudo de l'utilisateur
     * @param user_password  Mot de passe de l'utilisateur
     * @param user_role      Rôle de l'utilisateur
     * @param user_birthday  Date de naissance de l'utilisateur
     * @param user_type      Type de l'utilisateur
     */
    public User(int id, String user_firstname, String user_lastname, String user_mail, String user_pseudo, String user_password, Boolean user_role, Date user_birthday, int user_type) {
        this.user_id = id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_mail = user_mail;
        this.user_pseudo = user_pseudo;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_birthday = user_birthday;
        this.user_type = user_type;
    }

    // Getters

    /**
     * Obtient l'identifiant de l'utilisateur.
     *
     * @return L'identifiant de l'utilisateur
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Obtient le prénom de l'utilisateur.
     *
     * @return Le prénom de l'utilisateur
     */
    public String getUser_firstname() {
        return user_firstname;
    }

    /**
     * Obtient le nom de famille de l'utilisateur.
     *
     * @return Le nom de famille de l'utilisateur
     */
    public String getUser_lastname() {
        return user_lastname;
    }

    /**
     * Obtient l'adresse e-mail de l'utilisateur.
     *
     * @return L'adresse e-mail de l'utilisateur
     */
    public String getUser_mail() {
        return user_mail;
    }

    /**
     * Obtient le pseudo de l'utilisateur.
     *
     * @return Le pseudo de l'utilisateur
     */
    public String getUser_pseudo() {
        return user_pseudo;
    }

    /**
     * Obtient le mot de passe de l'utilisateur.
     *
     * @return Le mot de passe de l'utilisateur
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * Obtient le rôle de l'utilisateur.
     *
     * @return Le rôle de l'utilisateur
     */
    public Boolean getUser_role() {
        return user_role;
    }

    /**
     * Obtient la date de naissance de l'utilisateur.
     *
     * @return La date de naissance de l'utilisateur
     */
    public Date getUser_birthday() {
        return user_birthday;
    }

    /**
     * Obtient le type de l'utilisateur.
     *
     * @return Le type de l'utilisateur
     */
    public int getUser_type() {
        return user_type;
    }

    // Setters

    /**
     * Définit l'identifiant de l'utilisateur.
     *
     * @param user_id Le nouvel identifiant de l'utilisateur
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Définit le prénom de l'utilisateur.
     *
     * @param user_firstname Le nouveau prénom de l'utilisateur
     */
    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    /**
     * Définit le nom de famille de l'utilisateur.
     *
     * @param user_lastname Le nouveau nom de famille de l'utilisateur
     */
    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    /**
     * Définit l'adresse e-mail de l'utilisateur.
     *
     * @param user_mail La nouvelle adresse e-mail de l'utilisateur
     */
    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    /**
     * Définit le pseudo de l'utilisateur.
     *
     * @param user_pseudo Le nouveau pseudo de l'utilisateur
     */
    public void setUser_pseudo(String user_pseudo) {
        this.user_pseudo = user_pseudo;
    }

    /**
     * Définit le mot de passe de l'utilisateur.
     *
     * @param user_password Le nouveau mot de passe de l'utilisateur
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * Définit le rôle de l'utilisateur.
     *
     * @param user_role Le nouveau rôle de l'utilisateur
     */
    public void setUser_role(Boolean user_role) {
        this.user_role = user_role;
    }

    /**
     * Définit la date de naissance de l'utilisateur.
     *
     * @param user_birthday La nouvelle date de naissance de l'utilisateur
     */
    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    /**
     * Définit le type de l'utilisateur.
     *
     * @param user_type Le nouveau type de l'utilisateur
     */
    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    /**
     * Obtient le jeton de l'utilisateur.
     *
     * @return Le jeton de l'utilisateur
     */
    public String getUser_token() {
        return user_token;
    }

    /**
     * Définit le jeton de l'utilisateur.
     *
     * @param user_token Le nouveau jeton de l'utilisateur
     */
    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    /**
     * Retourne une représentation textuelle de l'utilisateur.
     *
     * @return Une chaîne de caractères représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", user_pseudo='" + user_pseudo + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_role=" + user_role +
                ", user_birthday=" + user_birthday +
                ", user_type=" + user_type +
                '}';
    }
}

