package com.example.randomquestion.controller;

import com.example.randomquestion.dao.QuestionDao;
import com.example.randomquestion.entity.Question;
import com.example.randomquestion.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public ListView<String> listQuestion;
    public String currentQuestion;
    public Text questionAffiche;
    public TextField correctOptionIndexUpdate;
    public TextField option1Update;
    public TextField option4Update;
    public TextField option3Update;
    public TextField option2Update;
    public TextArea questionUpdate;
    List<Question> listQuestionFile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuestionDao questionDao = new QuestionDao();

        try {
            listQuestionFile = questionDao.getAllQuestions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Initialiser une liste pour stocker les questions sous forme de String
        List<String> questionStrings = new ArrayList<>();
        for (Question q : listQuestionFile) {
            // Transformer chaque question en String et l'ajouter à la liste
            questionStrings.add(q.getQuestion()); // Vous pouvez aussi personnaliser l'affichage si nécessaire
        }

        // Convertir la liste en un tableau de String
        String[] questions = questionStrings.toArray(new String[0]);

        // Mettre à jour la ListView
        listQuestion.getItems().setAll(questions);

        listQuestion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                currentQuestion = newValue;
                questionAffiche.setText(currentQuestion);
                Question currentQuestionObject = getQuestionObject(newValue);
                questionUpdate.setText(currentQuestionObject.getQuestion());
                correctOptionIndexUpdate.setText(String.valueOf(currentQuestionObject.getCorrectOptionIndex() + 1));
                option1Update.setText(currentQuestionObject.getOptions().get(0));
                option2Update.setText(currentQuestionObject.getOptions().get(1));
                option3Update.setText(currentQuestionObject.getOptions().get(2));
                option4Update.setText(currentQuestionObject.getOptions().get(3));

            }
        });
    }
    public void updateAction(ActionEvent actionEvent) {

    }

    private Question getQuestionObject(String questionString) {
        for (Question q : listQuestionFile) {
            if (q.getQuestion().equals(questionString)) {
                return q;
            }
        }
        return null;
    }
}
