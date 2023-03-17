package com.BullsCows.controller;

import com.BullsCows.service.BullsCowsService;
import com.BullsCows.ui.BullsCowsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BullsCowsController {

    /** Declaration of the View */
    private BullsCowsView view;
    /** Declaration of the Service */
    private BullsCowsService service;

    /** constructor*/
    @Autowired
    public BullsCowsController(BullsCowsView view, BullsCowsService service) {
        this.view = view;
        this.service = service;
        this.runApp();
    }



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
        //have a game object out side the runapp class, this will hold the info for the game
        //create a new game object
        //set answer to the random number gen from service with the start constructor
    }


    /**Make a single guess for the current game.
     * It will return the result of the guess to the user.
     * If correct, will return a win result to user and database.
     * If not, will return the result to user
     * and return not win result to database if the number of guesses run out.
     */
    private void makeGuess() {
        System.out.println("not yet ready");
        //print number of rounds left
        //promt user for a input int -- use int list from io and view
        //do the single test method from service
        //do the check if rounds end from service -- if so, return result to database
    }


    /**Display the results of all the games in the database
     */
    private void displayListGame() {
        System.out.println("not yet ready");
        //from dao and service, get the list of all games
    }


    /**Display the results of a single game
     */
    private void displaySingleGame() {
        System.out.println("not yet ready");
        //promt user for either date or game id
        //get lsit from dao
    }


}
