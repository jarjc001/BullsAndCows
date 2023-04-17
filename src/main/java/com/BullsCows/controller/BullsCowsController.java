package com.BullsCows.controller;

import com.BullsCows.dao.BullsCowsDataException;
import com.BullsCows.dto.Game;
import com.BullsCows.service.BullsCowsService;
import com.BullsCows.ui.BullsCowsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bullscows")
public class BullsCowsController {

    /**Game Object of the current game in progress*/
    Game currentGame;


    /** Declaration of the View */
    private final BullsCowsView view;
    /** Declaration of the Service */
    private final BullsCowsService service;

    /** constructor*/
    @Autowired
    public BullsCowsController(BullsCowsView view, BullsCowsService service) {
        this.view = view;
        this.service = service;
        //this.run();                   //<- remove comment to allow app to work from console only
        //System.exit(0);
    }



    /**Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    private int getMainMenu(){
        return view.printMainMenu();
    }


    /**
     *The main run method to start the app
     */
    @GetMapping()
    public void run(){


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
        System.exit(0);


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

        startNewGame();

        while (!gameFinished){
            //prompt user for guess
            int userGuess = view.promptGuess(currentGame);

            playSingleRound(userGuess);

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


    //put in service

    /**Starts a new game by initialing a new game object for the class currentGame object
     */
    @PostMapping("/startNewGame")
    @ResponseStatus(HttpStatus.CREATED)
    private Game startNewGame(){
        List<Integer> testNumbers = service.generateNumbers();

        currentGame = new Game(testNumbers);
        return currentGame;
    }

    /** Makes a single guess for the current game object, and returns the result of the guess as a string
     * @param userGuess the guess as an int
     * @return the string result of the guess
     */
    @PostMapping("/makeGuess")
    private String playSingleRound(int userGuess){
        service.singleRound(currentGame,userGuess);
        return currentGame.getGameResult().toString();

    }



    /**
     * Display the results of all the games in the database
     * @return the list of all the games
     */
    @GetMapping("/allGames")
    private List<Game> displayListGame() {
        view.getDisplayAllGamesBanner();
        view.displayGameList(service.displayAllGames());
        return service.displayAllGames();
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
            Game game = showSinlgeGame(searchGameID);

        }catch (BullsCowsDataException e){
            view.displayErrorMessage(e.getMessage());
        }
    }


    /**From a game id, will get the game from the Data base
     * @param id id of game wanted to get
     * @return the game
     */
    @GetMapping("/getSingleGame/{id}")
    private Game showSinlgeGame (@PathVariable int id) throws BullsCowsDataException {
        Game game = service.displayGameFromId(id);
        view.displaySingleGameInfo(game);
        return game;
    }





}
