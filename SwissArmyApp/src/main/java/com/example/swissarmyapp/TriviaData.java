package com.example.swissarmyapp;

import java.util.ArrayList;
import java.util.List;

public class TriviaData {
    private static List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question("Who was the first president of the United States?",
                "a) George Washington", true));
        questions.add(new Question("What was the first civilization?", "c) Egyptian Empire",
                true));
        questions.add(new Question("What was the most significant event in history?", "b) World War II",
                true));
        questions.add(new Question("Who was the first person to circumnavigate the globe?",
                "b) Ferdinand Magellan", true));
        questions.add(new Question("Who was the first woman to win a Nobel Prize?", "a) Marie Curie",
                true));
        questions.add(new Question("What was the most significant event in US history?",
                "b) The Civil War", true));
        questions.add(new Question("Who invented the telephone?", "d) Alexander Graham Bell",
                true));
        questions.add(new Question("Who wrote 'The Communist Manifesto'?",
                "c) Karl Marx and Friedrich Engels", true));
        questions.add(new Question("Who was the first person to walk on the moon?", "a) Neil Armstrong",
                true));
        questions.add(new Question("Who was the first emperor of Rome",
                "d) Augustus", true));
        questions.add(new Question("Who painted the Mona Lisa?", "b) Leonardo da Vinci", true));
        questions.add(new Question("Who wrote 'To Kill A Mockingbird'?", "a) Harper Lee", true));
        questions.add(new Question("Who was the first female prime minister of Great Britain?",
                "c) Margaret Thatcher", true));
        questions.add(new Question("Who discovered penicillin?", "b) Alexander Fleming", true));
        questions.add(new Question("What was the most significant event in Ancient Rome?",
                "d) The Roman Empire", true));
    }

    public static List<Question> getQuestions() {
        return questions;
    }
}