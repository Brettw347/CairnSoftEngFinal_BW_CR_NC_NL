package com.example.swissarmyapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {
    @FXML
    private ChoiceBox fontChoice;
    ObservableList<String> fontNames = FXCollections.observableArrayList("Times New Roman", "Ariel", "Comic Sans");
    @FXML
    private void initialize() {
        fontChoice.setItems(fontNames);
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
        SystemData systemdata = new SystemData();
        systemdata.darkMode = true;
    }
    public void ChangedFontSize(){
    }
}
