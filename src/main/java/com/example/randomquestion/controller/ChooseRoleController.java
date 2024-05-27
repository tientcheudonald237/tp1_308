package com.example.randomquestion.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class ChooseRoleController {
    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {
        // Initialize the ComboBox with roles
        roleComboBox.getItems().addAll("Admin", "User");
    }

    public void start_choose(ActionEvent actionEvent) {
        String selectedRole = roleComboBox.getSelectionModel().getSelectedItem();
        if (selectedRole == null) {
            // No role selected
            showAlert("Please select a role.");
            return;
        }

        // Handle role-based navigation
        if (selectedRole.equals("Admin")) {
            navigateToAdminPage();
        } else if (selectedRole.equals("User")) {
            navigateToUserPage();
        }
    }

    private void navigateToAdminPage() {
        // Code to navigate to Admin page
        showAlert("Navigating to Admin page.");
    }

    private void navigateToUserPage() {
        // Code to navigate to User page
        showAlert("Navigating to User page.");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
