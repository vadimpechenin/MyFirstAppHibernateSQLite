import controller.UserService;
import envelope.ObjectFactory;
import model.User;

import javax.persistence.Column;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){

        // Проверка поиска пользователя
        String userLogin = "das";
        String password = "dsaf";

        ArrayList<User> users = new ArrayList<>();
        //UserService.GetUsers(null, password, users);
        UserService.GetUsers(userLogin, password, users);
        User user = users.get(0);
        System.out.println("Сделано");
        // Проверка добавления и удаления пользователей
        String userFirstName= "Юрий";
        String UserLastName= "Долгорукий";
        String userLogin1 = "das1";
        String password1 = "dsaf1";
        String location = "Москва";
        String gender = "Мужской";

        CreateTestUser(userFirstName, UserLastName, userLogin1, password1, location, gender);


        UserService.GetUsers(userLogin, password, users);
        User user1 = users.get(0);

        System.out.println("Сделано добавление пользователя с ID " + user1.ID);

        DeleteTestUser(userLogin1, password1);
        System.out.println("Сделано удаление пользователя с ID " + user1.ID);

    }

    public static boolean CreateTestUser(String userFirstName, String UserLastName, String userLogin, String password, String location, String gender) {
        User user = ObjectFactory.getObjectFactory().CreateUser();
        user.FirstName = userFirstName;
        user.LastName = UserLastName;
        user.UserName = userLogin;
        user.Password = password;
        user.Location = location;
        user.Gender = gender;
        return UserService.CreateUser(user);
    }

    public static boolean DeleteTestUser(String userLogin, String password) {
        ArrayList<User> users = new ArrayList<>();
        UserService.GetUsers(userLogin, password, users);
        User user = users.get(0);
        return UserService.DeleteUser(user);
    }

}