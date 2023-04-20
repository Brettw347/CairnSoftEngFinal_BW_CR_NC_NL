package com.example.swissarmyapp;

import java.util.ArrayList;
import java.util.List;

public class TriviaData {
    private static List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question("Who was the first president to live in the White House?",
                "THAT IS CORRECT!!!", true));
        questions.add(new Question("This is the second question?", "A) hello", true));
        questions.add(new Question("This is the third question?", "C) yurrr",
                true));
    }

    public static List<Question> getQuestions() {
        return questions;
    }
}