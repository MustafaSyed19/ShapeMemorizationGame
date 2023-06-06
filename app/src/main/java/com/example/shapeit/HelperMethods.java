package com.example.shapeit;

import android.widget.EditText;

import java.util.*;

    
public class HelperMethods {
    public static Player[] Leaderboard = new Player[10];
    public static Player currentPlayer=new Player("dweqweqw");
    public static Random rand = new Random();
    public static boolean canPlay = false;
    public static ArrayList<Integer> computerSequence = new ArrayList<>();
    public static ArrayList<Integer> playerSequence = new ArrayList<>();
    public static int totalDelay;

    // Verifies that a name is not already used in the leaderboard array.
    public static boolean verifyName(String name)
    {
        boolean newName=true;
        for(int x=0; x< Leaderboard.length;x++) {
            if (Leaderboard[x] == null) {
                break;
            }
            else if (Leaderboard[x].getName().equals(name)) {
                newName = false;
            }
        }
        return newName;
    }
    // Determines whether or not a player is added into the leaderboard depending on if the entries in the leaderboard are null or the same
    public static void manageLeaderBoard(Player currentPlayer) {
        Player temp;
        Player secondTemp;
        temp = currentPlayer;
        for (int x = 0; x <=Leaderboard.length; x++) {
            if (HelperMethods.Leaderboard[x] == null)
            {
                HelperMethods.Leaderboard[x]=temp;
                break;
            }
            else if (Leaderboard[x].getLevel() == currentPlayer.getLevel() && Leaderboard[x].getName() == currentPlayer.getName()) {
                break;
            } else if (Leaderboard[x].getLevel() < currentPlayer.getLevel()) {
                secondTemp = Leaderboard[x];
                Leaderboard[x]=temp;
                temp=secondTemp;
            }
        }
    }
    //Generates random integers selecting the buttons and then adds them to the array of the computer sequence
    public static void StartGame(String playerName) {
        currentPlayer = new Player(playerName);
    }

    /*
    Returns an arraylist dictating the buttons, if the game is between levels 1-10, inclusive.
    If so, it generates a random number between 1-10, which is then added to the array. This is repeated
    depending on the length of the level.
     */
    public static ArrayList<Integer> SelectButtons(int total) {
        ArrayList<Integer> Buttons = new ArrayList<>();
        int random;
        if (total > 0 && total < 10) {
            for (int x = 0; x < total; x++) {
                random = rand.nextInt(10) + 1;
                if (Buttons.contains(random)) {
                    --x;
                    continue;
                }
                Buttons.add(random);
            }
        } else {
            Buttons.add(1);
            Buttons.add(2);
            Buttons.add(3);
            Buttons.add(4);
            Buttons.add(5);
            Buttons.add(6);
            Buttons.add(7);
            Buttons.add(8);
            Buttons.add(9);
            Buttons.add(10);
        }
        return Buttons;
    }
    // Generates random numbers representing the shape of the different buttons.
    public static int RandomShapes() {
        Random rand = new Random();
        int randomShape = 0;
        randomShape = rand.nextInt(5) + 1;
        return randomShape;
    }
    // Generates each random button and returns the choice
    public static int blinkingButtons(ArrayList<Integer> selectButtons) {
        int choice;
        choice = selectButtons.get(rand.nextInt(selectButtons.size()));
        return choice;
    }
    // Controls the actions of winning or losing. If the player has won adds 1 to the level and if the player loses, it reduces the lives by -1.
    public static void winOrLoss() {
        if (verifyWinner() == true) {
            currentPlayer.setLevel(currentPlayer.getLevel() + 1);
        } else {
            currentPlayer.setLives(currentPlayer.getLives() - 1);
        }
    }
    //Checks if the current player is a winner
    public static boolean verifyWinner() {
        boolean verify = true;
        if (computerSequence.size() == 0) {
            verify = false;
        }
        for (int x = 0; x < computerSequence.size(); x++) {
            if (computerSequence.get(x) != playerSequence.get(x)) {
                verify = false;
            }
        }
        return verify;
    }
}

