package com.example.randomquestion.service;

import com.example.randomquestion.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }

    public SceneSwitch(AnchorPane currentAnchorPane, String fxml, int width, int height) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);

        // Obtenir la scène actuelle
        Scene scene = currentAnchorPane.getScene();
        if (scene != null) {
            // Obtenir le stage actuel à partir de la scène
            Stage stage = (Stage) scene.getWindow();
            if (stage != null) {
                // Modifier la taille du stage
                stage.setWidth(width);
                stage.setHeight(height);
            }
        }
    }
}
