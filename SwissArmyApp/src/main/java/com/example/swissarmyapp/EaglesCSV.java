package com.example.swissarmyapp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class EaglesCSV {
    private static int wins;
    private static int loss;
    private static int ties;

    public static void generateStats() throws Exception {
        int tempWins = 0;
        int tempLoss = 0;
        int tempTies = 0;
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader("SwissArmyApp/src/main/resources/EaglesStats.csv"));
        while ((line = br.readLine()) != null) {
            String[] game = line.split(",");

            if (game[5].equals("W")) {
                tempWins += 1;
            }
            else if (game[5].equals("L")){
                tempLoss += 1;
            }
            else{
                tempTies += 1;
            }
        }

        setWins(tempWins);
        setLoss(tempLoss);
        setTies(tempTies);
    }

    public static int getWins() {
        return wins;
    }

    public static void setWins(int wins) {
        EaglesCSV.wins = wins;
    }

    public static int getLoss() {
        return loss;
    }

    public static void setLoss(int loss) {
        EaglesCSV.loss = loss;
    }

    public static int getTies() {
        return ties;
    }

    public static void setTies(int ties) {
        EaglesCSV.ties = ties;
    }
}
