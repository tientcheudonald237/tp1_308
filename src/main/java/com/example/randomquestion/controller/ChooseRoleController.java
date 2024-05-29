package com.example.randomquestion.controller;

import com.example.randomquestion.helper.Alert;
import com.example.randomquestion.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ChooseRoleController {
    public AnchorPane anchorPaneTypeUser;
    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        // Initialize the ComboBox with roles
        roleComboBox.getItems().addAll("Admin", "User");
    }

    public void start_choose(ActionEvent actionEvent) throws IOException {
        String selectedRole = roleComboBox.getSelectionModel().getSelectedItem();
        if (selectedRole == null) {
            // No role selected
            Alert.showAlert("Please select a role.");
            return;
        }

        // Handle role-based navigation
        if (selectedRole.equals("Admin")) {
            new SceneSwitch(anchorPaneTypeUser, "sign-in-view.fxml");
        } else if (selectedRole.equals("User")) {
            new SceneSwitch(anchorPaneTypeUser, "start-game-view.fxml", 1305, 762);
        }
    }


}
