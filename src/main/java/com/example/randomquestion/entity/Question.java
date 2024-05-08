package com.example.randomquestion.entity;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                ", correctOptionIndex=" + correctOptionIndex +
                '}';
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}