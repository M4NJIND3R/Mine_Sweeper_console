//location of this class in the package
package com.game.minesweeper.support;

import java.util.Random;

/**
 *     @Author: Manjinder Singh
 *     @Student_Number: 200455485
 *     @Date: 22nd November, 2020
 *     @Time: 1:41 AM
 *     @Description: this class creates a minefield and allows user to
 *      interact with it. user can flag, un-flag or revealed a coordinate
 *      on mine filed. player is provided with a visual representation
 *      of a mine field to chose moves precisely
 */

//class declaration
public class MineField {

    /**Stores number of mines on field*/
    private static int mines;
    /**total land area of field*/
    private static int land = 36;
    /**stores player lives*/
    private static int lives;
    /**Limit of flag to set*/
    private static int flagLimit;
    /**Array to mimic the map of filed with all mine locations shown*/
    private static String[][] mineField_Uncovered = new String[6][6];
    /**array to mimic  the map of field ith all mines hidden*/
    private static String[][] mineField_Covered = new String[6][6];

    /**static method to get the value of land*/
    public static int getLand() {
        return land;
    }

    /**static method to get the flag limit value*/
    public static int getFlagLimit() {
        return flagLimit;
    }
    /**static method to get number of mine on filed*/
    public static int getMines() {
        return mines;
    }
    /**static method to get number of lives left*/
    public static int getLives() {
        return lives;
    }

    /**
     * decides the number of mines and lives of player
     * based on difficulty selected
     */
    public static void configureGame(int toughness){
        //switch argument
        switch(toughness){
            //if toughness is 1
            case 1:
                //set configuration to this
                mines = 7;
                lives = 3;
                flagLimit = 7;
                break;
            //if toughness is 2
            case 2:
                //set configuration to this
                mines = 10;
                lives = 2;
                flagLimit = 10;
                break;
            //if toughness is 3
            case 3:
                //set configuration to this
                mines = 12;
                lives = 0;
                flagLimit = 12;
                break;
        }
    }

    /**This method sets mines on the mine field 2D array*/
    public static void createMinefield(){
        //iterates rows of array
        int row;

        //iterates columns of 2d array
        int col;

        //loop 6 times
        for (int i = 0; i < 6; i++) {

            //nested loop 6 times
            for (int j = 0; j < 6; j++) {
                //set each element of both covered
                // and uncovered field array to [?]
                mineField_Uncovered[i][j] = "[?]";
                mineField_Covered[i][j] = "[?]";
            }
        }
        //Random object instantiation
        Random randNum = new Random();

        //counter to limit while loop
        int count=0;
        while (count < mines) {
            //get two random ints b/w 0-5
            row = randNum.nextInt(6);
            col = randNum.nextInt(6);
            //use these ints to set mines at random places on map
            // if there is no mine there already
            if(mineField_Uncovered[row][col].equals("[?]")){
                mineField_Uncovered[row][col] = "[X]";
                count++;
            }
        }
    }

    /**Shows the map of filed in a pictorial form on console*/
    public static void getMineField_Covered(){

        //prints heading
        System.out.println("\n----------|| M A P ||----------");

        //char to show Row value of each printed row
        char row = 'A';

        //prints out column indexes
        System.out.println("   0   1   2   3   4   5");

        //nested loop to print each row and row alphabetic index
        for (int i = 0; i < 6; i++) {
            System.out.print(row++ + " ");
            for (int j = 0; j < 6; j++) {
                System.out.print(mineField_Covered[i][j] + " ");
            }
            //new line after each row
            System.out.println("");
        }
    }

    /**Takes action of either flagging a coordinate or uncovering a coordinate*/
    public static void action(int action,int[] coordinates) {
        //if action chosen to flag coordinate
        if(action == 0){

            //if there is already a flag remove it
            if(mineField_Covered[coordinates[0]][coordinates[1]].equals(" * ")){
                mineField_Covered[coordinates[0]][coordinates[1]] = "[?]";
                flagLimit += 1;
            }
            //set flag [*] at the coordinate if flag limit not reaches to zero
            else if(flagLimit > 0){
                mineField_Covered[coordinates[0]][coordinates[1]] = " * ";
                flagLimit -= 1;
            }
            //if flag limit reached, say it out loud
            else {
                System.out.println("Soldier do some real PREDICTION,"
                        +" \nCan't put flags on all of them!!");
            }
        }
        //if action chosen was to revel the coordinate
        else{
            //check for blasts  by calling checkBoom() static method
            checkBoom(coordinates);
        }
    }
    /**Checks if the coordinate is revealed will it blast or is it safe*/
    private static void checkBoom(int[] coordinates) {
        //if the coordinate value has mine
        if(mineField_Uncovered[coordinates[0]][coordinates[1]].equals("[X]")){
            //decrement live by one
            lives -= 1;
        }
        else {
            //if there was no mine decrement covered land by one
            // and set the cleared are to [ ]
            mineField_Covered[coordinates[0]][coordinates[1]] = "   ";
            land -=1;
        }
    }
}
