package com.example.swissarmyapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Double.parseDouble;

public class TipCalculatorController {
    //ObservableList<String> percentages = FXCollections.observableArrayList("10", "15", "20", "25");
    @FXML
    private ChoiceBox percentChoice;
    ObservableList<Integer> percentages = FXCollections.observableArrayList(10, 15, 20, 25);

    @FXML
    private Label tipTotal;

    @FXML
    private TextField total;



    @FXML
    private void initialize() {
        percentChoice.setItems(percentages);
    }

    @FXML
    protected double onCalculateButtonClick(){
        double value = (double) percentChoice.getValue();
        double tip = (value * .01) * parseDouble(total.getText());
        return tip;
    }

    @FXML
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("activity-center.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Activity Center");
        stage.setScene(scene);
        stage.show();
    }
}
