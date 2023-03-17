package com.BullsCows.controller;

import com.BullsCows.dto.Game;
import com.BullsCows.service.BullsCowsService;
import com.BullsCows.ui.BullsCowsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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


        boolean keepRunning = true;

        while (keepRunning) {           //will loop until user exits

            int menuSelect = getMainMenu(); //main menu loaded

            switch (menuSelect){
                case 1:
                    startGame();
                    break;
                case 2:
                    displayListGame();
                    break;
                case 3:
                    displaySingleGame();
                    break;
                case 4:
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
     * and creates a new game object to track the info.
     * Then it will go through each round of the game,
     * It will return the result of the guess to the user.
     * If correct, will return a win result to user and database.
     * otherwise, will return the result to user and do another round.
     * If the user runs out of rounds,
     * it will return not win result to database if the number of guesses run out.
     */
    private void startGame() {
        System.out.println("not yet ready");

        view.newGameBanner();

        boolean gameFinished = false;

//        //generate a new game
//        Game currentGame = new Game(service.generateNumbers());

        //for testing
        List<Integer> testGame = new ArrayList<>();
        testGame.add(1);
        testGame.add(3);
        testGame.add(5);
        testGame.add(7);
        Game currentGame = new Game(testGame);

        while (!gameFinished){
            //prompt user for guess
            List<Integer> userGuess = view.promptGuess(currentGame);

            service.singleRound(currentGame,userGuess);

            switch (service.checkGameEnd(currentGame)){
                case WIN:
                    view.winGameResult(currentGame);
                    service.addGameToDB(currentGame);
                    gameFinished =true;
                    break;
                case LOST:
                    view.lostGameResult(currentGame);
                    service.addGameToDB(currentGame);
                    gameFinished =true;
                    break;
                case NOT_FINISHED:
                    view.roundResult(currentGame);
                    break;
            }

        }











    }


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
