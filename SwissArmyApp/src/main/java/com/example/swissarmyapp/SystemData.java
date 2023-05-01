package com.example.swissarmyapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SystemData{
    public static String currentStyle() {
        return darkMode;


    }

    private static int fontSize = 12;
    public static String username = "No Name";

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SystemData.username = username;
    }


    public static void setFontSize(int f) {
       fontSize = f;
    }

    public static String getFont() {
        return font;
    }
    public static int getFontSize() {
        return fontSize;
    }
    public static void setFont(String f) {
       font = f;
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


