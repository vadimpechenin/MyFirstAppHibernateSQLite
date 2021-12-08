package controller;

import animations.Shake;
import controller.dbController.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.util.ArrayList;

public class HomeController {

    @FXML
    private AnchorPane imageButtonHome;

    @FXML
    private Button exitButton;


    @FXML
    void initialize() {


        exitButton.setOnAction(event -> {
            //System.out.println("Вы нажали на кнопку Войти");
            //Переход на новое окно
            openNewScene("/view/sample.fxml");

        });
    }

    public void openNewScene(String window){
        //Скрыть окно
        exitButton.getScene().getWindow().hide();
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
