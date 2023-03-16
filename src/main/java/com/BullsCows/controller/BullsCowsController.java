package com.BullsCows.controller;

import com.BullsCows.ui.BullsCowsView;

public class BullsCowsController {

    private BullsCowsView view;


    /**Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    private int getMainMenu(){
        return view.printMainMenu();
    }



    public void runApp(){
        System.out.println("yoo");

        boolean keepRunning = true;

        while (keepRunning) {           //will loop until user exits

            int menuSelect = getMainMenu(); //main menu loaded

            switch (menuSelect){
                case 1:
                    startGame();
                    break;
                case 2:
                    makeGuess();  //undo somehow
                    break;
                case 3:
                    displayListGame();
                    break;
                case 4:
                    displaySingleGame();
                    break;
                case 5:
                    keepRunning=false;
                    break;
                default:
                    System.out.println("unknownCommand");
            }

        }
        System.out.println("Good Bye!");

    }


    /**Method starts a game of bulls and cows,
     * will set up the initial conditions for a game
     * and creates a new game object to track the info
     */
    private void startGame() {
        System.out.println("not yet ready");
    }


    /**Make a single guess for the current game.
     * It will return the result of the guess to the user.
     * If correct, will return a win result to user and database.
     * If not, will return the result to user
     * and return not win result to database if the number of guesses run out.
     */
    private void makeGuess() {
        System.out.println("not yet ready");
    }


    /**Display the results of all the games in the database
     */
    private void displayListGame() {
        System.out.println("not yet ready");
    }


    /**Display the results of a single game
     */
    private void displaySingleGame() {
        System.out.println("not yet ready");
    }


}
