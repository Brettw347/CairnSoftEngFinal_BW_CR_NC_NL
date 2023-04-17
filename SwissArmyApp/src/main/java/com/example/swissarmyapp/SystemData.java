package com.example.swissarmyapp;

public class SystemData{
    public static String currentStyle() {
        //if (darkMode = false) {
            return "/originalstyle.css";//}
        //else {
        //return "/darkmode.css";
        //}

    }


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

    public boolean darkMode =false;
    private String font = "Normal";

}


