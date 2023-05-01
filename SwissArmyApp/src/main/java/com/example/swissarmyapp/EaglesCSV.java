package com.example.swissarmyapp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class EaglesCSV {
    private static int wins;
    private static int loss;
    private static int ties;
    private static int totYards;
    private static int passYards;
    private static int rushYards;
    private static int TO;

    public static void generateStats() throws Exception {
        int tempWins = 0;
        int tempLoss = 0;
        int tempTies = 0;
        int tempTotYards = 0;
        int tempPassYards = 0;
        int tempRushYards = 0;
        int tempTO = 0;
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
            else if (game[5].equals("T")){
                tempTies += 1;
            }
            if(!game[13].equals("TotYd")){
                    tempTotYards += Integer.parseInt(game[13]);
            }
            if(!game[14].equals("PassY")){
                tempPassYards += Integer.parseInt(game[14]);
            }
            if(!game[15].equals("RushY")){
                tempRushYards += Integer.parseInt(game[15]);
            }
            if(!game[16].equals("TO")){
                tempTO += Integer.parseInt(game[16]);
            }
        }

        setWins(tempWins);
        setLoss(tempLoss);
        setTies(tempTies);
        setTotYards(tempTotYards);
        setPassYards(tempPassYards);
        setRushYards(tempRushYards);
        setTO(tempTO);
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
    public static int getTotYards() {
        return totYards;
    }
    public static void setTotYards(int totYards) {
        EaglesCSV.totYards = totYards;
    }

    public static int getPassYards() {
        return passYards;
    }

    public static void setPassYards(int passYards) {
        EaglesCSV.passYards = passYards;
    }

    public static int getRushYards() {
        return rushYards;
    }

    public static void setRushYards(int rushYards) {
        EaglesCSV.rushYards = rushYards;
    }

    public static int getTO() {
        return TO;
    }

    public static void setTO(int TO) {
        EaglesCSV.TO = TO;
    }
}
