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
//        Question currentQuestion = questions.get(currentQuestionIndex);
//        if (button1.getText().equals("a) George Washington")) {
//            answerLabel.setText(currentQuestion.getAnswer());
//        }
//        if (button2.getText().equals("b) World War II")) {
//            answerLabel.setText(currentQuestion.getAnswer());
//        }
//        if (button3.getText().equals("c) Egyptian Empire")) {
//            answerLabel.setText(currentQuestion.getAnswer());
//        }
//        if (button4.getText().equals("d) Augustus ")) {
//            answerLabel.setText(currentQuestion.getAnswer());
//        }
        Question currentQuestion = questions.get(currentQuestionIndex);
        Button clickedButton = (Button) event.getSource();
        if ((clickedButton == button1 || clickedButton == button2 || clickedButton == button3 || clickedButton == button4)
                && clickedButton.getText().equals(currentQuestion.getAnswer())) {
            answerLabel.setText("That is CORRECT!!!");
        } else {
            answerLabel.setText("INCORRECT guess again");
        }
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
        String[][] texts = {{"a) George Washington", "a) Roman Empire", "a) World War I", "a) Christopher Columbus",
                "a) Marie Curie", "a) The American Revolution", "a) Alexander Graham Bell",
                "a) Karl Marx and Friedrich Engels", "a) Neil Armstrong", "a) Julius Caesar", "a) Leonardo da Vinci",
                "a) Harper Lee", "a) Margaret Thatcher", "a) Alexander Fleming"},
                {"b) Thomas Jefferson", "b) Greek Empire", "b) World War II", "b) Ferdinand Magellan",
                        "b) Rosalind Franklin", "b) The Civil War", "b) Thomas Edison", "b) Vladimir Lenin",
                        "b) Buzz Aldrin", "b) Nero", "b) Michelangelo", "b ) Ernest Hemingway",
                "b) Theresa May", "b) Louis Pasteur", "b) The Fall of Rome"},
                {"c) John Adams", "c) Egyptian Empire", "c) The Renaissance", "c) Vasco da Gama", "c) Ada Lovelace",
                        "c) The Great Depression", "c) Nikola Tesla", "c) Nikola Tesla", "c) Yuri Gagarin",
                        "c) Caligula", "c) Vincent van Gogh", "c) William Faulkner", "c) Angela Merkel",
                        "c) Robert Koch", "c) The Roman Republic"},
                {"d) Abraham Lincoln", "d) Babylonian Empire", "d) The Industrial Revolution", "d) Marco Polo",
                "d) Jane Goodall", "d) The Cold War", "d) Samuel Morse", "d) Mao Zedong", "d) Alan Shepard ",
                "d) Augustus", "d) Pablo Picasso", "d) F. Scott Fitzgerald",
                "d) Indira Gandhi", "d) Jonas Salk", "d) The Roman Empire"}};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(texts[i][currentQuestionIndex % texts[i].length]);
        }
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
