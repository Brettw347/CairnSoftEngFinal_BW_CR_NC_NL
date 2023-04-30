package com.example.swissarmyapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SystemData{
    public static String currentStyle() {
        return darkMode;


    }

    public static int fontSize = 12;
    public static String username = "No Name";

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SystemData.username = username;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public static String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }



    public static void setDarkMode(String darkMode) {
        SystemData.darkMode = darkMode;
    }
    private static int twentyfour = 0;

    public static void setTwentyFour(int input) {
        twentyfour = input;
    }
    public static int currentClock() {
        return twentyfour;

    }
    private static String darkMode = "/originalstyle.css";
    private static String font = "System";

}


