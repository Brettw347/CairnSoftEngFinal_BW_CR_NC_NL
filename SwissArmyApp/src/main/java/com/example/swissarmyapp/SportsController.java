package com.example.swissarmyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;


public class SportsController extends EaglesCSV{
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("activity-center.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        scene.getStylesheets().add(HelloApplication.class.getResource(SystemData.currentStyle()).toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Activity Center");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label record;

    @FXML
    private Label quickStats;

    @FXML
    private void initialize() throws Exception {
        com.example.swissarmyapp.EaglesCSV.generateStats();
        record.setText("2023 Record (" + getWins() + "-" + getLoss() + "-" + getTies() + ")");
        quickStats.setText("Stat Summary: \n"+"Total yards gained: "+getTotYards()+"\n"+"Passing yards: "+
                getPassYards()+"\n"+"Rushing yards: "+getRushYards()+"\n"+"Caused turnovers: "+getTO());
    }

}
