package com.example.swissarmyapp;

public class Question {
    private String question;
    private String answer;
    private boolean correctAnswer;

    public Question(String question, String answer, boolean correctAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}
