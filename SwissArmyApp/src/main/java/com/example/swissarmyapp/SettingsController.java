package com.example.swissarmyapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SettingsController {
    @FXML
    private Label clock;
    @FXML
    private CheckBox twentyfour;
    @FXML
    private CheckBox dark;
    @FXML
    private CheckBox old;
    public String dateString;
    @FXML
    public ScrollBar fontsize;

    @FXML
    private TextField newusername;
    String[] nameList = {"Nate",
            "Gelar Adams",
            "Elsea Anderson",
            "Juliann Brown",
            "Alle Shaw" ,
            "Jomarie Adams",
            "Jondy Mitchell",
            "Ciji Murphy" ,
            "Adde Jones" ,
            "Jomarie James" ,
            "Joylyn Adams" ,
            "Julij Evans" ,
            "Isla Rogers" ,
            "Auton Thomas" ,
            "Himar Mason" ,
            "Grace Price" ,
            "Juliano Davies" ,
            "Jomarie Mitchell" ,
            "Avgoustinos Miller" ,
            "Jonathen Nguyen" ,
            "Daryllyn James" ,
            "Laniyah Wood" ,
            "Aimo Carter" ,
            "Charlotte Wood" ,
            "Harwill Marshall" ,
            "Bassett Edwards" ,
            "Jinelle Ward" ,
            "Ava Chapman" ,
            "Charlotte Robertson" ,
            "Juin Richardson" ,
            "Jinadath Webb" ,
            "Joyelle Harris" ,
            "Daryllyn Marshall" ,
            "Jomarie Green" ,
            "Juan Elliott" ,
            "Allirea Baker" ,
            "Harper Clarke" ,
            "Bassett Clark" ,
            "Aayla Matthews" ,
            "Julietta Phillips" ,
            "Hastie Clarke" ,
            "Celyse Matthews",
            "Alyne Johnson" ,
            "Halena Matthews",
            "Jimmie Cooper" ,
            "Alisah Clarke" ,
            "Brak Hughes" ,
            "Harwell Pearce",
            "Jondi Simpson" ,
            "Cra Hughes" ,
            "Jimm Campbell",
            "Jono Jackson" ,
            "Alle Kennedy" ,
            "Gon Collins" ,
            "Gelar Kumar" ,
            "Harper Thompson",
            "Bastiaan Davies" ,
            "Luu Johnson" ,
            "Himyar Adams" ,
            "Bayram Morris" ,
            "Cra James" ,
            "Hastie Tran",
            "Halena Wright" ,
            "Julietta Thomas" ,
            "Dainen Mills" ,
            "Dainen Jones" ,
            "Harwill Moore" ,
            "Joyelle Richardson",
            "Harwill Fisher" ,
            "Lucas King" ,
            "Julietta Graham",
            "Ghy Ross" ,
            "Halena Bailey",
            "Gie Robertson" ,
            "Adde Wright" ,
            "Himar Walsh" ,
            "Juliann Matthews" ,
            "Ethan Taylor" ,
            "Ciji Blackman" ,
            "Harwill Corbyn" ,
            "Gon Shaw" ,
            "Jula Kelly",
            "Denaye Hamilton" ,
            "Jimme Campbell" ,
            "Centaine James" ,
            "Jonila Thomas" ,
            "Alisah Fisher" ,
            "Ilina White" ,
            "Juin Evans" ,
            "Aayla Ward" ,
            "Halena Collins",
            "Laniyah Murray" ,
            "Daymion Parker" ,
            "Himyar Cox" ,
            "Daynan Harvey",
            "Cra Morris" ,
            "Danian Kelly",
            "Julieth McDonald",
            "Daynan Johnson" ,
            "Adami Matthews",
            "Nico Cione",
            "Caleb Rudloff",
            "Brett Williams",
            "Mergie Castro " ,
            "Nico Cione the Legend" ,
            "Caroline Conrad" ,
            "Samuel Douglass " ,
            "Christopher Eelman" ,
            "Rachel Ferrence " ,
            "Jack Fiacco" ,
            "Yunn Kang" ,
            "Mark Kim Karomo" ,
            "Elizaveta Kim" ,
            "Artur Kondratyuk" ,
            "Nathaniel Lofgren" ,
            "Dave Ng'ang'a" ,
            "Laina Nguyen" ,
            "Brandon Petcaugh" ,
            "Nancy Rivera" ,
            "Cool Caleb " ,
            "Garrett Seidel " ,
            "Brett 'the boss' Williams" ,
            "Dawei Zhao"

    };
    @FXML
    private void initialize() {
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

        if (SystemData.currentClock() != 0) {
            twentyfour.setSelected(true);
        }
        if (SystemData.currentStyle() == "/darkmode.css") {
            dark.setSelected(true);
        }
        if (SystemData.currentStyle() == "/oldstyle.css") {
            old.setSelected(true);
        }
        double d = SystemData.getFontSize();
        fontsize.setValue(d);

        clock.setFont(Font.font(SystemData.getFont(), SystemData.getFontSize()));

    }
    @FXML
    public void Back(ActionEvent event) throws IOException {

        int i =  (int)(fontsize.getValue());
        SystemData.setFontSize(i);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("activity-center.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        scene.getStylesheets().add(HelloApplication.class.getResource(SystemData.currentStyle()).toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Activity Center");
        stage.setScene(scene);
        stage.show();
    }
    public void DarkMode(){
        if (SystemData.currentStyle() != "/darkmode.css") {
            SystemData.setDarkMode("/darkmode.css");
        }
        else {
            SystemData.setDarkMode("/originalstyle.css");
        }
    }
    public void NostalgiaMode(){
        if (SystemData.currentStyle() != "/oldstyle.css") {
            SystemData.setDarkMode("/oldstyle.css");
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

    @FXML
    public void ChangeUserName() {
        SystemData.setUsername(newusername.getText());
    }
    @FXML
    public void RandomUserName(){
        Random rand = new Random();
        int randInt1 = rand.nextInt(122);
        SystemData.setUsername(nameList[randInt1]);
        newusername.setText(nameList[randInt1]);
    }
}
