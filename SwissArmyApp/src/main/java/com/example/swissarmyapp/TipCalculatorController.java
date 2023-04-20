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
    @FXML
    private ChoiceBox percentChoice;
    ObservableList<Double> percentages = FXCollections.observableArrayList(10.00, 15.00, 20.00, 25.00);

    @FXML
    private Label tipTotal;

    @FXML
    private TextField total;

    @FXML
    private void initialize() {
        percentChoice.setItems(percentages);
    }

    @FXML
    protected void onCalculateButtonClick(){
        double percent = (double) percentChoice.getValue();
        double tip = (percent * .01) * parseDouble(total.getText());
        tip = Math.round(tip * 100.0) / 100.0;
        tipTotal.setText("$" + tip);
    }

    @FXML
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
