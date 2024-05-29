package com.example.randomquestion.dao;

import com.example.randomquestion.DatabaseConnection;
import com.example.randomquestion.entity.Difficulty;
import com.example.randomquestion.entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {

    public void addQuestion(Question question) throws SQLException {
        String query = "INSERT INTO question (question, options, correct_option_index, difficulty) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, question.getQuestion());
            pstmt.setString(2, String.join("/", question.getOptions()));
            pstmt.setInt(3, question.getCorrectOptionIndex());
            pstmt.setString(4, question.getDifficulty().name());

            pstmt.executeUpdate();
        }
    }

    public Question getQuestionById(int id) throws SQLException {
        String query = "SELECT * FROM question WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String questionText = rs.getString("question");
                List<String> options = List.of(rs.getString("options").split("/"));
                int correctOptionIndex = rs.getInt("correct_option_index");
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                return new Question(questionText, options, correctOptionIndex, difficulty);
            }
        }
        return null;
    }

    public List<Question> getAllQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM question";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String questionText = rs.getString("question");
                List<String> options = List.of(rs.getString("options").split("/"));
                for (String o:options) {
                    System.out.println(o);
                }
                int correctOptionIndex = rs.getInt("correct_option_index");
                Difficulty difficulty = Difficulty.valueOf(rs.getString("difficulty"));
                questions.add(new Question(questionText, options, correctOptionIndex, difficulty));
            }
        }
        return questions;
    }

    public void updateQuestion(Question question, int id) throws SQLException {
        String query = "UPDATE question SET question = ?, options = ?, correct_option_index = ?, difficulty = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, question.getQuestion());
            pstmt.setString(2, String.join("/", question.getOptions()));
            pstmt.setInt(3, question.getCorrectOptionIndex());
            pstmt.setString(4, question.getDifficulty().name());
            pstmt.setInt(5, id);

            pstmt.executeUpdate();
        }
    }

    public void deleteQuestion(int id) throws SQLException {
        String query = "DELETE FROM question WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
