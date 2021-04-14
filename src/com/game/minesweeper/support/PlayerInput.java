//location of this class in the package
package com.game.minesweeper.support;

/**
 *     @Author: Manjinder Singh
 *     @Student_Number: 200455485
 *     @Date: 22nd November, 2020
 *     @Time: 1:41 AM
 *     @Description: This class Formats and stores the input from user
 *      and provide access to the data on demand.
 */

//class declaration
public class PlayerInput {

    /**Stores difficulty level of the game*/
    private static int gameDifficulty;
    /**Stores player name*/
    private static String playerName;
    /**array to store the 2D co-ordinate*/
    private static int[] mapCoordinate = new int[2];
    /**Store player action choice*/
    private static int playerMoveChoice;

    /**Static getter for playerMoveChoice*/
    public static int getPlayerMoveChoice() {
        return playerMoveChoice;
    }
    /**static class to format and set the value of playerMoveChoice*/
    public static boolean setPlayerMoveChoice(String playerMoveChoice) {
        //flag to return success or failure
        boolean flag = false;

        //try bloc kto handle exception
        try{
            //if the length of argument is grater than 1 set flag to false
            if(playerMoveChoice.length() > 1) { flag = true; }

            //if the argument is either 1 or 0 then
            // set the value to member variable playerMoveChoice
            if(Integer.parseInt(playerMoveChoice) == 1 ||
                    Integer.parseInt(playerMoveChoice) == 0){
                PlayerInput.playerMoveChoice = Integer.parseInt(playerMoveChoice);
            }
            //otherwise set flag to fail
            else{
                flag = true;
            }

        //catch any exception
        }catch(Exception e){
            flag = true;
        }
        //return the flag value
        return flag;
    }

    /**static method to get the value of gameDifficulty*/
    public static int getGameDifficulty() {
        return gameDifficulty;
    }

    /**static method to validate and set the gameDifficulty*/
    public static int setGameDifficulty(String gameDifficulty) {
        //result will determine the flag value and will be returned by method
        int flag = 0;

        //try catch block
        try{
            //if argument has length greater than 1 set flag to fail
            if(gameDifficulty.length() > 1){
                flag = 1;
            }

            //temporary variable to tore the parsed value of argument
            int temp = Integer.parseInt(gameDifficulty);

            //if the value parsed is 1, 2 or 3 then
            // set he value to member variable gamDifficulty
            if(temp == 1 || temp ==2 || temp == 3){
                PlayerInput.gameDifficulty = temp;
            }
            //otherwise set flag to fai;
            else{
                flag = 1;
            }
        }
        //catch any exception
        catch (Exception e){
            flag = 1;
        }
        //return flag value
        return flag;
    }

    /**static method to get the value of member variable playerName*/
    public static String getPlayerName() {
        return playerName;
    }

    /**Static method to set the value of member variable playerName*/
    public static void setPlayerName(String playerName) {
        PlayerInput.playerName = playerName;
    }

    /**static method to get the value of member variable maCoordinates*/
    public static int[] getMapCoordinate() {
        return mapCoordinate;
    }

    /**this method takes converts the given coordinate format and
     * coverts and stores it into a usable format
     */
    public static boolean setMapCoordinate(String mapCoordinate) {
        //flag to set true if failure occurs
        boolean flag = false;
        //try catch block
        try{
            //char array to store each char of passed argument
            char[] xyAxis = mapCoordinate.toCharArray();

            //iterator for mapCoordinate array
            int i =0;
            //for loop to access each coordinate
            for (char value: xyAxis) {
                //if the coordinate value is from A-F char
                if(value >= 65 && value <= 70 ){
                    //set value from 0-5 int
                    PlayerInput.mapCoordinate[i] = ((int)value)-65;
                }//if coordinate is a-f char
                else if(value >= 97 && value <= 102){
                    //set value to 0-5 int
                    PlayerInput.mapCoordinate[i] = ((int)value)-97;
                }//if coordinate is 0-5 char
                else if(value >= 48 && value <= 53){
                    //set value to 0-5 int
                    PlayerInput.mapCoordinate[i] = ((int)value)-48;
                }//another value sets flag to fail
                else{
                    flag = true;
                }
                //increment i by 1
                i++;
            }
         //catch any exception
        }catch (Exception e){
            //if caught, set flag to fail
            flag = true;
        }
        //return flag value
        return flag;
    }
}
