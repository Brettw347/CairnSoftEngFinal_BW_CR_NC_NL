package com.example.swissarmyapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public int fontSize = 12;

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    private boolean darkMode =false;
    private String font = "Normal";


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("LandingPage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }

}