import controller.UserService;
import model.User;

import java.util.ArrayList;

public class Test{
    public static void main(String[] args){
        String userLogin = "das";
        String password = "dsaf";

        ArrayList<User> users = new ArrayList<>();
        UserService.GetUsers(userLogin, password, users);
        User user = users.get(0);

       System.out.println("Сделано");
    }
}