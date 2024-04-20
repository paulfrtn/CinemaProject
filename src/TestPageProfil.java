import Controller.ProfilPage.ControllerPageProfil;
import CustomExceptions.UserNotFoundException;
import Model.User.UserDaoImpl;
import View.ProfilPage.ViewPageProfil;
import java.util.*;

public class TestPageProfil{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ViewPageProfil view = new ViewPageProfil();
        UserDaoImpl model = new UserDaoImpl();
        ControllerPageProfil controller = new ControllerPageProfil(view, model);
        int userId;
        System.out.println("Enter the user ID: ");
        userId = sc.nextInt();

        try{
            controller.displayUser(userId);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
