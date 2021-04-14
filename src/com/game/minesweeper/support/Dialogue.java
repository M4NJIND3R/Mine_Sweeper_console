//location of this class in the package
package com.game.minesweeper.support;

/**
 *     @Author: Manjinder Singh
 *     @Student_Number: 200455485
 *     @Date: 22nd November, 2020
 *     @Time: 1:41 AM
 *     @Description: This class stores dialogues which are displayed
 *      on demand.the printing process of dialogue is simulated as
 *      a animation using loop nesting
 */

//class declaration
public class Dialogue {
    /**Dialogue for welcome to game*/
    public static void greetings() {
        //string array to be displayed
        String[] greet = {"*******************************\n>>>>>>>>>",
                "W", "E", "L", "C", "O", "M","E"," ","T","O",
                "<<<<<<<<<<<\n*******************************\n"};
        //loop to access each element of array
        for (String value: greet) {
            //prints the value from array
            System.out.print(value);
            //nested loop for delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 15233703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

    /**Dialogue for game name*/
    public static void heading(){
        //string array to be displayed
        String[] heading = {"*******************************\n>>>>>>>>>",
                "M","I","N","E"," ","S","W","E","E","P","E","R",
                "<<<<<<<<<\n*******************************\n"};
        //loop to access each element of array
        for (String value: heading) {
            //prints the element
            System.out.print(value);
            //nested loop to delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 12233703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

    /**Dialogue for game story background*/
    public static void gameStory(String playerName){
        //string which will be displayed as dialogue
        String description = "> Welcome to the War "+ playerName
                +". \n> We have been held back by enemy Mine Fields !!"
                +"\n> We must cross the the land before noon."
                +"\n> You seem to have exceptional good luck "
                +"\n> Hence your are chosen to clear the path"
                +" for us through the mine field."
                +"\n> We wish you good luck\n\n";
        //converted the string to char array to access each char individually
        char[] descriptionAnim = description.toCharArray();
        //loop to access each element of array
        for (char value : descriptionAnim) {
            //prints each character from array
            System.out.print(value);
            //nested loop to cause delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 8233703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

    /**Dialogue for game instructions*/
    public static void instructions(String playerName){
        //string which will be displayed as dialogue
        String instruct = "\n\n> Here, " + playerName
                +" We have prepared a local map for you"
                +"\n> Mark out the mines if you feel them"
                +"\n> Clear the land if it feels safe."
                +"\n> We will keep check how many places"
                +" are flagged and how many are cleared\n\n";
        //converted the string to char array to access each char individually
        char[] instructAnim = instruct.toCharArray();
        //loop to access each element of array
        for (char vlaue: instructAnim) {
            //prints each character from array
            System.out.print(vlaue);
            //nested loop to cause delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 8933703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

    /**Dialogue if player loses*/
    public static void lost() {
        //string storing the dialogue to be displayed
        String youLost = "\\**************************************************\n"
                +"* Better Luck Next Time Soldier,\n"
                +"* You did your best!!\n"
                +"\\**************************************************\n";
        //string converted to char array to access each char individually
        char[] youLostArray = youLost.toCharArray();
        //loop to access each element of char array
        for (char value : youLostArray) {
            //print each element from array
            System.out.print(value);
            //nested loop to cause delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 1933703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

    /**Dialogue if player wins*/
    public static void won() {
        //sring to store dialogue
        String youWon = "\\**************************************************\n"
                +"* Congratulations Soldier!!!! \n"
                +"* you Proved your luck to be unbeatable,\n"
                +"* You Cleared it all!!!\n"
                +"\\**************************************************\n";
        //string converted to char array to access each char individually
        char[] youWonArray = youWon.toCharArray();
        //loop to access each element of array
        for (char value: youWonArray) {
            //prints each element
            System.out.print(value);
            //nested loop to cause delay
            for(int i = 0 ; i <= 7 ; i++){
                long count1 = 0;
                while(count1 < 1933703){
                    long count2 = 0 ;
                    while(count2 < 2) {
                        count2++;
                    }
                    count1++;
                }
            }
        }
        //new empty line
        System.out.println("");
    }

}//class end
