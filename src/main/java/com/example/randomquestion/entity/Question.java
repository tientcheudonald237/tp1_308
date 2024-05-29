package com.example.randomquestion.entity;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    private Difficulty difficulty;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public Question(String question, List<String> options, int correctOptionIndex, Difficulty difficulty) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", correctOptionIndex=" + correctOptionIndex +
                ", difficulty=" + difficulty +
                '}';
    }
}