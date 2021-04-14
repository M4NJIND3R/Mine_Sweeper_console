//location of this class in the package
package com.game.minesweeper;

//imports te Scanner class
import java.util.Scanner;

//imports the other MineField, PlayerInput and Dialogue
//classes from there declared package
import com.game.minesweeper.support.*;

/**
 *     @Author: Manjinder Singh
 *     @Student_Number: 200455485
 *     @Date: 22nd November, 2020
 *     @Time: 1:41 AM
 *     @Description: This is a Game class which Uses PlayerInput Class, MineFieldClass
 *       And Dialogue class to create a game of MINE SWEEPER. This class also uses
 *       main method to run the game. first it welcomes user then asks for player name
 *       after which dictates a story using Dialogue class. then it asks for game
 *       difficulty and stores the answer in appropriate format using PlayerInput class
 *       and Scanner class. then the actual game of mine sweeper is in while loop
 *       which runs until either player lose or win. then this this class uses static
 *       methods to display score. This class uses static function checkGameOver to
 *       determine either game is finished or not and uses score static method to
 *       display the performance of the player in mine sweeping game
 */

//Game class declaration
public class Game {
    //main method
    public static void main(String[] args){

        //Calls a static function from Dialogue class
        // to say welcome simulated like a animation
        Dialogue.greetings();

        //calls another static function to
        // display game name/heading
        Dialogue.heading();

        //Scanner object instantiation
        Scanner userInput = new Scanner(System.in);

        //Asking for Name
        System.out.print("What's your name soldier !!!!! ?? >>>>");

        //Calling PlayerInput class setter method
        // to store next string entered byt user as member variable
        PlayerInput.setPlayerName(userInput.nextLine());

        //Dialogue explaining the Game Story simulated like a animation
        Dialogue.gameStory(PlayerInput.getPlayerName());

        //asking for dame difficulty level
        System.out.print("Choose your Difficulty !! \n3 -> Hard"
                +"\n2 -> Normal\n1 -> Easy\n>>>> ");

        //until user gives a valid game difficulty checked by PlayerInput class static method
        // keep asking for it
        while(PlayerInput.setGameDifficulty(userInput.nextLine()) == 1){
            //message if user gives unacceptable/invalid difficulty value
            System.out.println("Don't push your luck KID !!!"
                    +" Just clear fields with provided difficulty!!!");
        }

        //taking game difficulty stored in Player input class member variable
        // and passing it as a argument to MineField class's static method
        // configureGame to save proper configurations of mine field
        // according to the selected difficulty
        MineField.configureGame(PlayerInput.getGameDifficulty());

        //create a mine filed using the configuration provided
        MineField.createMinefield();

        //Explain how to play simulated in a animation like effect
        Dialogue.instructions(PlayerInput.getPlayerName());

        //loop until checkGameOver static method of Game class
        // makes sure either player lost or won
        while(checkGameOver() == 0){

            //display the covered mine field with row and column index values
            // ot navigate the coordinates of a position on mine field
            MineField.getMineField_Covered();

            //prints the lives, flags and total mines on field
            System.out.println("\n\nIntel says >>>>>>>>>>>>>>>>>>>>");
            System.out.println("Mines on Field  : " + MineField.getMines());
            System.out.println("Your Lives Left : " + MineField.getLives());
            System.out.println("Flags left      : " + MineField.getFlagLimit());

            //aks for a coordinate to take action on
            System.out.println("Which coordinate you want to take action"
                    +" on? RowColumn( example A1 or a1 )");
            //loops until a valid input is given, checked by PlayerInput class static method
            while(PlayerInput.setMapCoordinate(userInput.nextLine())){
                //prints this message if input is not acceptable/invalid
                System.out.println("Soldier, You need to select"
                        +" co-ordinates from map only !!");
            }

            //asking for action to take on selected coordinate
            System.out.println("Whats your move?\nTo Flag/UnFlag a coordinate"
                    +" enter 0\nTo Reveal a coordinate enter 1...might get boom!!! ");

            //loop until a valid input is given checked by PlayerInput class static method
            while(PlayerInput.setPlayerMoveChoice(userInput.nextLine())){
                System.out.println("Are you nuts? either chose flag (0) or reveal"
                        +" (1) only. you are putting us all in danger here soldier!!!");
            }

            //calls the action static method of MineField
            // to take selected action on selected coordinates
            MineField.action(PlayerInput.getPlayerMoveChoice(),PlayerInput.getMapCoordinate());

        }//while loop ends

        //if the checkGameOver evaluates that player lost
        if(checkGameOver() == -1){
            //call lost static method of Dialogue for losing game
            Dialogue.lost();
        }
        //if the checkGameOver evaluates player won
        else if(checkGameOver() == 1){
            //call won static method of Dialogue class
            Dialogue.won();
        }

        //call score method of Game class to display final results
        score();
    }

    /**
     * static method to check weather to end game or not
     * */
    private static int checkGameOver() {
        //flag variable to return in value
        int flag = 0;

        //if the lives become less than zero
        if(MineField.getLives() < 0){
            //set flag to -1 that is the player lost the game
            flag = -1;
        }

        //if all the clear land/coordinates on minefield
        // are cleared by player
        if(MineField.getLand() == 0){
            //set flag to 1 that is player won
            flag = 1;
        }
        //return the value of flag
        return flag;
    }

     /**
      * static method to display the end results of the game
     * and how much did the player scored/cleared the mine field
     * */
    private static void score() {
        System.out.println(">>>>>>>>>>>>>>YOUR SCORE<<<<<<<<<<<<<<<<");
        System.out.println("\n*****************************************"
                //prints the number of coordinates cleaned
                +"\nYou Cleared " + (36-MineField.getLand())
                + " Coordinate/s\nAnd flagged "
                //pints the flagged numbr of mines
                +(MineField.getMines()-MineField.getFlagLimit()) + " Mines"
                +"\n*****************************************");
    }

}


