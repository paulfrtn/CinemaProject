package Model.User;


import java.sql.Date;
public class User {
    private int user_id;
    private String user_firstname;
    private String user_lastname;
    private String user_mail;
    private String user_pseudo;
    private String user_password;
    private Boolean user_role;
    private Date user_birthdate;
    private int user_type;

    public User(int user_id, String user_firstname, String user_lastname, String user_mail, String user_pseudo, String user_password, Boolean user_role, Date user_birthdate, int user_type) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_mail = user_mail;
        this.user_pseudo = user_pseudo;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_birthdate = user_birthdate;
        this.user_type = user_type;
    }

    // Getters
    public int getUser_id() {
        return user_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_pseudo() {
        return user_pseudo;
    }

    public String getUser_password() {
        return user_password;
    }

    public Boolean getUser_role() {
        return user_role;
    }

    public Date getUser_birthdate() {
        return user_birthdate;
    }

    public int getUser_type() {
        return user_type;
    }

    // Setters

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_pseudo(String user_pseudo) {
        this.user_pseudo = user_pseudo;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_role(Boolean user_role) {
        this.user_role = user_role;
    }

    public void setUser_birthdate(Date user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

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
                ", user_birthdate=" + user_birthdate +
                ", user_type=" + user_type +
                '}';
    }
}
