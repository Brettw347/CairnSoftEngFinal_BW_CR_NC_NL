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
    private Label answerLabel;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

//  List of questions
    private List<Question> questions;

//    Index of the current question
    private int currentQuestionIndex;

//    This initializes the controller
    public void initialize() {

        // This loads questions from TriviaData class
        questions = TriviaData.getQuestions();

//      This sets the current question index to 0
        currentQuestionIndex = 0;

//      This gets the current question
        Question currentQuestion = questions.get(currentQuestionIndex);

//      This sets the question label text to the current question
        questionLabel.setText(currentQuestion.getQuestion());
    }

    public void showAnswer(ActionEvent event) {
//      This gets the current question
        Question currentQuestion = questions.get(currentQuestionIndex);

//      This gets the button that was clicked
        Button clickedButton = (Button) event.getSource();

//      This checks if the clicked button's text matches the answer to the current question
        if ((clickedButton == button1 || clickedButton == button2 || clickedButton == button3 || clickedButton == button4)
                && clickedButton.getText().equals(currentQuestion.getAnswer())) {
//          If the answer is correct, display "CORRECT!!!"
            answerLabel.setText("CORRECT!!!");
        } else {
//          If the answer is incorrect, display "Wrong Guess Again"
            answerLabel.setText("Wrong Guess Again");
        }
    }
    public void nextQuestion(ActionEvent event) {
//      This will increment the current question index
        currentQuestionIndex++;

//      If the current question index is greater than or equal to the number of questions, reset it to 0
        if (currentQuestionIndex >= questions.size()) {
            currentQuestionIndex = 0;
        }

//        This gets the current question
        Question currentQuestion = questions.get(currentQuestionIndex);

//      This sets the question label text to the current question
        questionLabel.setText(currentQuestion.getQuestion());

        // Clear answer label
        answerLabel.setText("");

//      This sets the text for each button
        Button[] buttons = {button1, button2, button3, button4};
        String[][] texts = {{"a) George Washington", "a) Roman Empire", "a) World War I", "a) Christopher Columbus",
                "a) Marie Curie", "a) The American Revolution", "a) Samuel Morse",
                "a) Joseph Stalin", "a) Neil Armstrong", "a) Julius Caesar", "a) Michelangelo",
                "a) Harper Lee", "a) Angela Merkel", "a) Louis Pasteur", "a) The Punic Wars"},
                {"b) Thomas Jefferson", "b) Greek Empire", "b) World War II", "b) Ferdinand Magellan",
                        "b) Rosalind Franklin", "b) The Civil War", "b) Thomas Edison", "b) Vladimir Lenin",
                        "b) Buzz Aldrin", "b) Nero", "b) Leonardo da Vinci", "b ) Ernest Hemingway",
                "b) Theresa May", "b) Alexander Fleming", "b) The Fall of Rome"},
                {"c) John Adams", "c) Egyptian Empire", "c) The Renaissance", "c) Vasco da Gama", "c) Ada Lovelace",
                        "c) The Great Depression", "c) Nikola Tesla", "c) Karl Marx and Friedrich Engels", "c) Yuri Gagarin",
                        "c) Caligula", "c) Vincent van Gogh", "c) William Faulkner", "c) Margaret Thatcher",
                        "c) Robert Koch", "c) The Roman Republic"},
                {"d) Abraham Lincoln", "d) Babylonian Empire", "d) The Industrial Revolution", "d) Marco Polo",
                "d) Jane Goodall", "d) The Cold War", "d) Alexander Graham Bell", "d) Mao Zedong", "d) Alan Shepard ",
                "d) Augustus", "d) Pablo Picasso", "d) F. Scott Fitzgerald",
                "d) Indira Gandhi", "d) Jonas Salk", "d) The Roman Empire"}};
        for (int i = 0; i < buttons.length; i++) {
//          This sets the text for each button
            buttons[i].setText(texts[i][currentQuestionIndex % texts[i].length]);
        }
    }
    public void Back(ActionEvent event) throws IOException {
//      Load the activity-center.fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("activity-center.fxml"));

//       Create a new scene with the loaded fxml file
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);

//      Add the current style to the scene
        scene.getStylesheets().add(HelloApplication.class.getResource(SystemData.currentStyle()).toExternalForm());

//      Get the current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//      Set the title of the stage
        stage.setTitle("Activity Center");

//      Set the scene of the stage
        stage.setScene(scene);

//      Show the stage
        stage.show();
    }

}
