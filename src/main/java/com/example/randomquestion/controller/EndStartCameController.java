package com.example.randomquestion.controller;

import com.example.randomquestion.service.DataManager;
import com.example.randomquestion.service.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndStartCameController implements Initializable {
    public AnchorPane anchorPaneEndGame;
    public Text scoreFinal;

    public void nouvellePartie(ActionEvent actionEvent) throws IOException {
        Object anchorPaneStartGame;
        new SceneSwitch((AnchorPane) anchorPaneEndGame, "start-game-view.fxml");
    }

    public void fermerLeJeu(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sharedData = DataManager.getInstance().getSharedData();
        scoreFinal.setText(sharedData);
    }
}
