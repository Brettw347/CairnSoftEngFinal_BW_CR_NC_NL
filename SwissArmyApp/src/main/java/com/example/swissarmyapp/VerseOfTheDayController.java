package com.example.swissarmyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.io.IOException;


public class VerseOfTheDayController {
    @FXML
    private Label clock;

    public String dateString;


    @FXML
    private Label reference;
    @FXML
    private Label verse;
    @FXML
    private ImageView image;

    @FXML
    private void initialize(){
        Random rand = new Random();
        int randInt1 = rand.nextInt(31);
        int randInt2 = rand.nextInt(5);
        verse.setText(Verses.verseList[randInt1]);
        reference.setText(Verses.referenceList[randInt1]);

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
    }

    //Returns the user to the Activity Center page
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
