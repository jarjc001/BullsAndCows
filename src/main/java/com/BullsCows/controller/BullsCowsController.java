package com.BullsCows.controller;

import com.BullsCows.dao.BullsCowsDataException;
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
        view.newGameBanner();
        boolean gameFinished = false;

//        //generate a new game
//        Game currentGame = new Game(service.generateNumbers());

        //for testing
        List<Integer> testGame = List.of(1,3,5,7);
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


    /**Display the results of all the games in the database
     */
    private void displayListGame() {
        view.getDisplayAllGamesBanner();
        view.displayGameList(service.displayAllGames());
    }


    /**Asks user for a game id,
     * then will print the game details of that id.
     * If no game exist for that id, it will display an error message
     * and return user to main menu
     */
    private void displaySingleGame() {
        view.getDisplaySingleGameBanner();

        try {
            int searchGameID = view.askGameID();
            Game game = service.displayGameFromId(searchGameID);
            view.displaySingleGameInfo(game);

        }catch (BullsCowsDataException e){
            view.displayErrorMessage(e.getMessage());
        }

    }


}
