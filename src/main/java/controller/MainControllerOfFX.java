package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.dbController.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import animations.Shake;

import model.User;

public class MainControllerOfFX {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {

        authSignInButton.setOnAction(event ->{
            //trim - удаление пробелов в строке
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and password is empty");

        });


        loginSignUpButton.setOnAction(event -> {
            //System.out.println("Вы нажали на кнопку Войти");
            //Переход на новое окно
            openNewScene("/view/signUp.fxml");

        });
    }

    private void loginUser(String loginText, String loginPassword) {
        //Создаем обект класса БД
        ArrayList<User> users = new ArrayList<>();
        UserService.GetUsers(loginText, loginPassword, users);
        int counter = users.size();

        if(counter>=1){
            System.out.println("Success!");
            //Переход на новое окно
            openNewScene("/view/app.fxml");

        }
        else {
            //проигрывание анимации если пользователь не найден
            Shake userLoginAnim = new Shake(login_field);
            Shake userPasswordAnim = new Shake(password_field);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
        }
    }

    public void openNewScene(String window){
        //Скрыть окно
        loginSignUpButton.getScene().getWindow().hide();
        // отображаем нужное окно
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
    }
}

