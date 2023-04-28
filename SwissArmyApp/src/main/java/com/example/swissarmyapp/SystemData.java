package com.example.swissarmyapp;

public class SystemData{
    public static String currentStyle() {
        return darkMode;


    }


    public int fontSize = 12;

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }



    public static void setDarkMode(String darkMode) {
        SystemData.darkMode = darkMode;
    }

    private static String darkMode = "/originalstyle.css";
    private static String font = "Normal";

}


