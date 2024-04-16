package Model;

import Model.DataBase.ConnectionDb;
import Model.Salle.Salle;
import Model.Salle.SalleDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ModelMain {
    public static void main(String[] args) {
        try (Connection connection = ConnectionDb.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                Salle salle = new Salle (1,150, true);
                SalleDaoImpl salleDao = new SalleDaoImpl();
                salleDao.addSalle(salle);
                salleDao.updateSalle(salle);

                Salle salle2 = salleDao.getSalleByNumber(1);
                System.out.println(salle2.toString());

            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
