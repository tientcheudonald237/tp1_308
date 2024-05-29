package com.example.randomquestion.controller;

import com.example.randomquestion.helper.Alert;
import com.example.randomquestion.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SIgnInController {
    public TextField user_name;
    public TextField password;
    public AnchorPane anchorPaneLogin;

    public void login(ActionEvent actionEvent) throws IOException {
        if(Objects.equals(user_name.getText(), "") || Objects.equals(password.getText(), "")) {
            Alert.showAlert("Entrer de valeurs valides");
            return;
        }
        if(Objects.equals(user_name.getText(), "admin") || Objects.equals(password.getText(), "admin")) {
            new SceneSwitch(anchorPaneLogin, "admin-game-view.fxml", 846, 606);
        }
        Alert.showAlert("Valeurs Incorrectes");
    }
}
