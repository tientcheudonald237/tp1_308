package com.example.randomquestion.service;

import com.example.randomquestion.entity.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<Question> questions;

    public Service() {
        this.questions = new ArrayList<>();
    }

    public List<Question> loadQuestionsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            String question = parts[0];
            List<String> options = new ArrayList<>();
            for (int i = 1; i < parts.length - 1; i++) {
                options.add(parts[i]);
            }
            int correctOptionIndex = Integer.parseInt(parts[parts.length - 1]);
            questions.add(new Question(question, options, correctOptionIndex));
        }
        reader.close();

        return questions ;
    }
}
