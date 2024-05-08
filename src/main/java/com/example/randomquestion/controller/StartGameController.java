package com.example.randomquestion.controller;

import com.example.randomquestion.entity.Question;
import com.example.randomquestion.service.DataManager;
import com.example.randomquestion.service.SceneSwitch;
import com.example.randomquestion.service.Service;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {
    @FXML
    public RadioButton questionChoice4, questionChoice3, questionChoice2, questionChoice1;
    @FXML
    public ToggleGroup questionChoice;
    public Text score;
    public Pane anchorPaneStartGame;

    private Random random;
    private int  randomNumber;
    private List<Question> listQuestion;
    @FXML
    public Text question, reponse4, reponse3, reponse2, reponse1;

    public void fonctionbuttonSuivant(ActionEvent actionEvent) throws InterruptedException, IOException {
        int selectedAnswer = 0;
        if(questionChoice1.isSelected()){
            selectedAnswer = 0;
        } else if (questionChoice2.isSelected()) {
            selectedAnswer = 1;
        } else if (questionChoice3.isSelected()) {
            selectedAnswer = 2;
        } else if (questionChoice4.isSelected()) {
            selectedAnswer = 3;
        } else {
            System.out.println("Veuillez sélectionner une réponse.");
            return;
        }

        if (selectedAnswer == listQuestion.get(randomNumber).getCorrectOptionIndex() ) {
            System.out.println("Bonne réponse !");
            afficherToastDeChargement();
            score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
        } else {
            System.out.println("Mauvaise réponse !");
            DataManager.getInstance().setSharedData(score.getText());
            new SceneSwitch((AnchorPane) anchorPaneStartGame, "end-game-view.fxml");
        }

        randomNumber = random.nextInt(listQuestion.size());
        Question firstquestion = listQuestion.get(randomNumber);
        question.setText(firstquestion.getQuestion());
        reponse1.setText(firstquestion.getOptions().get(0));
        reponse2.setText(firstquestion.getOptions().get(1));
        reponse3.setText(firstquestion.getOptions().get(2));
        reponse4.setText(firstquestion.getOptions().get(3));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Service service = new Service();
        try {
            listQuestion = service.loadQuestionsFromFile("src/main/resources/questions.txt");
            for (Question item : listQuestion ) {
                System.out.println(item);
            }
            random = new Random();
            randomNumber = random.nextInt(listQuestion.size());
            Question firstquestion = listQuestion.get(randomNumber);
            question.setText(firstquestion.getQuestion());
            reponse1.setText(firstquestion.getOptions().get(0));
            reponse2.setText(firstquestion.getOptions().get(1));
            reponse3.setText(firstquestion.getOptions().get(2));
            reponse4.setText(firstquestion.getOptions().get(3));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void afficherToastDeChargement() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chargement en cours");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez patienter...");
        alert.show();

        // Création d'un Timeline pour fermer la fenêtre de dialogue après 3 secondes
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alert.close();
            }
        }));
        timeline.setCycleCount(1); // Se déclenche une seule fois
        timeline.play();
    }
}