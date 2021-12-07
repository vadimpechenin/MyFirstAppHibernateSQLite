package controller;

import java.net.URL;
import java.util.ResourceBundle;

import controller.dbController.UserService;
import envelope.ObjectFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
}

