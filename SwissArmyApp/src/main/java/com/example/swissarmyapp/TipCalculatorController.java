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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Double.parseDouble;

public class TipCalculatorController {
    @FXML
    private ChoiceBox percentChoice;
    //Creates the list of percentages for the user to choose to calculate the tip from
    ObservableList<Double> percentages = FXCollections.observableArrayList(10.00, 15.00, 20.00, 25.00);

    @FXML
    private Label tipTotal;
    //Forces tipTotal to print with two decimal places, even if it can be rounded to one
    DecimalFormat df = new DecimalFormat("#.00");

    @FXML
    private TextField total;
    @FXML
    private Label clock;

    public String dateString;



   //Initializes the percentChoice ChoiceBox in the tip calculator
    @FXML
    private void initialize() {
        percentChoice.setItems(percentages);
        if (SystemData.currentClock() == 0) {
            DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
            dateString = dateFormat.format(new Date()).toString();
            clock.setText(dateString);
        }
        else {
            DateFormat dateFormat = new SimpleDateFormat("HH.mm");
            dateString = dateFormat.format(new Date()).toString();
            clock.setText(dateString);
        }
    }

    //Takes in the users total and chosen tip percentage and outputs how much the tip will cost
    @FXML
    protected void onCalculateButtonClick(){
        double percent = (double) percentChoice.getValue();
        double tip = (percent * .01) * parseDouble(total.getText());
        tipTotal.setText("$" + df.format(tip));
    }

    //Returns the user to the Activity Center page
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
