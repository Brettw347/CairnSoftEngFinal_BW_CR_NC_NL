package com.example.swissarmyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class TriviaController {
    @FXML
    private Label questionLabel;

    @FXML
    private Button answerButton;

    @FXML
    private Label answerLabel;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;


    private List<Question> questions;
    private int currentQuestionIndex;
    private boolean clicked = false;
    private String[][] previousTexts = new String[4][4];

    public void initialize() {
        // Load questions from TriviaData class
        questions = TriviaData.getQuestions();

        // Display first question
        currentQuestionIndex = 0;
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestion());
    }

    public void showAnswer(ActionEvent event) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        answerLabel.setText(currentQuestion.getAnswer());
    }

    public void nextQuestion(ActionEvent event) {
        // Move to next question
        currentQuestionIndex++;
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
        }

        // Display new question
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionLabel.setText(currentQuestion.getQuestion());

        // Clear answer label
        answerLabel.setText("");

        Button[] buttons = {button1, button2, button3, button4};
        String[][] texts = {{"New Text 1", "Different Text 1", "Third Text 1", "4th text 1"},
                {"New Text 2", "Different Text 2", "Third Text 2", "4th text 2"},
                {"New Text 3", "Different Text 3", "Third Text 3", "4th text 3"},
                {"New Text 4", "Different Text 4", "Third Text 4", "4th text 4"}};
        for (int i = 0; i < buttons.length; i++) {
            int index = clicked ? i + 1 : i;
            if (clicked && index == texts[i].length) {
                index = 0;
            }
            buttons[i].setText(texts[i][index]);
        }
        clicked = !clicked;
    }
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("activity-center.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        scene.getStylesheets().add(HelloApplication.class.getResource(SystemData.currentStyle()).toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Activity Center");
        stage.setScene(scene);
        stage.show();
    }

}
