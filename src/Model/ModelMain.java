package Model;

import Model.DataBase.ConnectionDb;
import Model.User.User;
import Model.User.UserDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ModelMain {
    public static void main(String[] args) {
        try (Connection connection = ConnectionDb.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                User user = new User("John", "Doe", "JohnDoe@mail.fr", "JohnDoe", "password", true, java.sql.Date.valueOf("1990-01-01"), 1);
                UserDaoImpl userDao = new UserDaoImpl();
                //userDao.addUser(user);
                User user2 = userDao.getUserById(1);
                userDao.deleteUserById(1);
                userDao.deleteUserByPseudo("JohnDoe");
                System.out.println(user2.toString());

            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
