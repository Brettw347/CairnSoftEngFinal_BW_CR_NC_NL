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





=======
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

    // Used to indicate if the verse has been chosen, if the value is true, selectVerse() is not supposed to run
    boolean verseChosen = false;

    @FXML
    private void initialize(){
        while(!verseChosen){
            selectVerse();
            //Needs to be commented out since the scene won't load due to the function not working.
            //selectImage();
        }
    }
    /* Selects the verse that is displayed in the Verse of the Day scene, works but will run each time the program
    goes to the scene, changing the verse.*/
    private void selectVerse() {
        int verseNum = 0;
        if (verseChosen != true) {
            Random rand = new Random();
            int randInt1 = rand.nextInt(31);
            verseNum = randInt1;
            verse.setText(Verses.verseList[randInt1]);
            reference.setText(Verses.referenceList[randInt1]);
            verseChosen = true;
        } else {
            verse.setText(Verses.verseList[verseNum]);
            reference.setText(Verses.referenceList[verseNum]);
        }
    }
    // Used to set the image that displays on the Verse of the Day scene, does not work
    private void selectImage() throws FileNotFoundException {
        Random rand = new Random();
        int randInt2 = rand.nextInt(5);
        InputStream stream = new FileInputStream("/resources/VotDImages/img" + randInt2 + ".jpg");
        Image picture = new Image(stream);
        ImageView image = new ImageView();
        image.setImage(picture);
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
