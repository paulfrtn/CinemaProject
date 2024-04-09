package Model;

import Model.DataBase.ConnectionDb;

import java.sql.Connection;
import java.sql.SQLException;

public class ModelMain {
    public static void main(String[] args) {
        try (Connection connection = ConnectionDb.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
