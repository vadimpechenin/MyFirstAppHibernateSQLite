import controller.dbController.ProfileService;
import controller.dbController.UserService;
import envelope.ObjectFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Profile;
import model.User;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = new File("src/main/resources/view/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        //Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Мое первое приложение");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

    }



    public static void main(String[] args){
        launch(args);
        if (1==0) {
            // Проверка поиска пользователя
            String userLogin = "das";
            String password = "dsaf";

            ArrayList<User> users = new ArrayList<>();
            //UserService.GetUsers(null, password, users);
            UserService.GetUsers(userLogin, password, users);
            User user = users.get(0);
            System.out.println("Сделано");
            // Проверка добавления и удаления пользователей
            String userFirstName = "Юрий";
            String userLastName = "Долгорукий";
            String userLogin1 = "das1";
            String password1 = "dsaf1";
            String location = "Москва";
            String gender = "Мужской";

            CreateTestUser(userFirstName, userLastName, userLogin1, password1, location, gender);


            UserService.GetUsers(userLogin1, password1, users);
            User user1 = users.get(0);

            System.out.println("Сделано добавление пользователя с ID " + user1.ID);
            // Проверка обновления пользователей
            user1.FirstName = "Сергей";
            UserService.UpdateUser(user1);
            System.out.println("Сделано обновление имени пользователя с ID " + user1.ID + ", c " + userFirstName + " на " + user1.FirstName);
            DeleteTestUser(userLogin1, password1);
            System.out.println("Сделано удаление пользователя с ID " + user1.ID);
        }
        if (1==0) {
            // Проверка поиска профиля
            String userID = "3";

            ArrayList<Profile> profiles = new ArrayList<>();
            //ProfileService.GetProfilies(null, profiles);
            ProfileService.GetProfiles(userID, profiles);
            Profile profile = profiles.get(0);
            System.out.println("Найден пользователь с ID " + profile.UserID + ", c ростом " +  profile.Height + " и возрастом " + profile.Age);

            // Проверка добавления и удаления пользователей
            String userID1 = "2";
            String age = "30";
            String height = "75";

            CreateTestProfile(userID1, age, height);


            ProfileService.GetProfiles(userID1, profiles);
            Profile profile1 = profiles.get(0);

            System.out.println("Сделано добавление профиля пользователя с ID " + profile1.UserID);
            // Проверка обновления профиля
            profile1.Age = "32";
            ProfileService.UpdateProfile(profile1);
            System.out.println("Сделано обновление возраста профиля с ID " + profile1.ID + ", c " + age + " на " + profile1.Age);
            DeleteTestProfile(userID1);
            System.out.println("Сделано удаление профиля с ID " + profile1.ID);

        }

    }

    public static boolean CreateTestUser(String userFirstName, String userLastName, String userLogin, String password, String location, String gender) {
        User user = ObjectFactory.getObjectFactory().CreateUser();
        user.FirstName = userFirstName;
        user.LastName = userLastName;
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

    public static boolean CreateTestProfile(String userID, String age, String height) {
        Profile profile = ObjectFactory.getObjectFactory().CreateProfile();
        profile.UserID = userID;
        profile.Age = age;
        profile.Height = height;

        return ProfileService.CreateProfile(profile);
    }

    public static boolean DeleteTestProfile(String userID) {
        ArrayList<Profile> profiles = new ArrayList<>();
        ProfileService.GetProfiles(userID, profiles);
        Profile profile = profiles.get(0);
        return ProfileService.DeleteProfile(profile);
    }
}