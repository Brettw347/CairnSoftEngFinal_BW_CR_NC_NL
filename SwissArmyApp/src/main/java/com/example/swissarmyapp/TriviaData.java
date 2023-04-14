package com.example.swissarmyapp;

public class TriviaData {
    private static String question = "Who was the first president to live in the White House?";

    private static String answer = "A) John Adams";

    private static boolean CorrectAnswer = true;

    public static String getQuestion() {
        return question;
    }

    public static void setQuestion(String question) {
        TriviaData.question = question;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void setAnswer(String answer) {
        TriviaData.answer = answer;
    }

    public static boolean isCorrectAnswer() {
        return CorrectAnswer;
    }

    public static void setCorrectAnswer(boolean correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
