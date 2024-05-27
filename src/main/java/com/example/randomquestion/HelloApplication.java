package com.example.randomquestion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("choose-role-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1305, 762);
        Scene scene = new Scene(fxmlLoader.load(), 706, 472);
        stage.setTitle("Random Question Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}