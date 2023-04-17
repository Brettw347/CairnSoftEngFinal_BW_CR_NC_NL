package com.example.swissarmyapp;
import java.io.BufferedReader;
import java.io.FileReader;

public class EaglesCSV {
    private static int wins;

    public static void generateStats() throws Exception {
        int tempWins = 0;
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/EaglesStats.csv"));

        while ((line = br.readLine()) != null) {
            String[] game = line.split(",");

            if (game[5].equals("W")) {
                tempWins += 1;
            }
        }

        setWins(tempWins);
    }

    public static int getWins() {
        return wins;
    }

    public static void setWins(int wins) {
        EaglesCSV.wins = wins;
    }

}
