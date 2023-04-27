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

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import java.io.IOException;

public class VerseOfTheDayController {

    @FXML
    private static Label reference;
    @FXML
    private static Label verse;
    @FXML
    private static ImageView image;

    public static void selectVerse() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Verses.csv"));
        //Random rand = new Random();
        int randInt = 3;
        //rand.nextInt(31);
        int i = 0;
        String line = "";
        while((line = br.readLine()) != null && i != randInt){
            String[] verseOption = line.split(",");
            if(i == randInt){
                verse.setText(verseOption[0]);
                reference.setText(verseOption[1]);
                return;
            }else{
                i++;
            }
        }
    }

    public static void selectImage(){
        Random rand = new Random();
        int randInt = 0;
        // rand.nextInt(5);
        if(randInt == 0);
            Image picture = new Image(VerseOfTheDayController.class.getResourceAsStream("src/main/resources/VotD Images/img1.jpg"));
            image.setImage(picture);
    }

    VerseOfTheDayController.selectVerse();
        VerseOfTheDayController.selectImage();

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
