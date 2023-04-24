package com.example.swissarmyapp;

//
public class Question {
//    The question
    private String question;

//    The answer
    private String answer;

//    Whether the answer is correct or not
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
