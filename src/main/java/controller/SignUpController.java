package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.dbController.UserService;
import envelope.ObjectFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event ->{

            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if (signUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        CreateTestUser(firstName, lastName, userName, password, location, gender);

        //Переход на новое окно
        openNewScene("/view/sample.fxml");
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

    public void openNewScene(String window){
        //Скрыть окно
        signUpButton.getScene().getWindow().hide();
        // отображаем нужное окно
        /*
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        // Загрузка окна
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Полный путь к классу, который необходимо загрузить
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        // Показать и подождать пока загрузится
        stage.showAndWait();
        */
    }
}

