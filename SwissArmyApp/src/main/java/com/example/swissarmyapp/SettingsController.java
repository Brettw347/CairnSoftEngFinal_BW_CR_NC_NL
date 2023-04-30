package com.example.swissarmyapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingsController {
    @FXML
    private ChoiceBox fontChoice;
    @FXML
    private Label clock;
    @FXML
    private CheckBox twentyfour;
    @FXML
    private CheckBox dark;
    public String dateString;



    @FXML
    ObservableList<String> fontNames = FXCollections.observableArrayList("Times New Roman", "Arial", "Comic Sans");
    @FXML
    private void initialize() {
        if (SystemData.currentClock() == 0) {
            DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
            dateString = dateFormat.format(new Date()).toString();
            clock.setText(dateString);
        }
        else {
            DateFormat dateFormat = new SimpleDateFormat("hh.mm");
            dateString = dateFormat.format(new Date()).toString();
            clock.setText(dateString);
        }

        if (SystemData.currentClock() != 0) {
            twentyfour.setSelected(true);
        }
        if (SystemData.currentStyle() != "/originalstyle.css") {
            dark.setSelected(true);
        }


        fontChoice.setItems(fontNames);
        clock.setFont(Font.font(SystemData.getFont(), SystemData.fontSize));

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
    public void DarkMode(){
        if (SystemData.currentStyle() != "/originalstyle.css") {
            SystemData.setDarkMode("/darkmode.css");
        }
        else {
            SystemData.setDarkMode("/originalstyle.css");
        }
    }
    public void TwentyFour(){
        if (SystemData.currentClock() == 0) {
            SystemData.setTwentyFour(1);
        }
        else {
            SystemData.setTwentyFour(0);
        }
    }
    public void ChangedFontSize(){
    }
}
