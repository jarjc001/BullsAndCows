package com.BullsCows.ui;

import com.BullsCows.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BullsCowsView {

    /**Declaration of the UserIO*/
    private UserIO io;

    /**Constructor
     * @param io UserIOConsoleImpl */
    @Autowired
    public BullsCowsView(UserIO io) {
        this.io = io;
    }

    /**
     * Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    public int printMainMenu(){
        io.print("");
        io.print("-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-");
        io.print("<<Bulls and Cows>>");
        io.print("1. Start New game");
        io.print("2. Return list of all games");
        io.print("3. Return specific game");
        io.print("4. Quit");
        io.print("");
        io.print("-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-");

        return io.readInt("", 1, 4);

    }

    //play game

    /**display new game start
     */
    public void newGameBanner(){
        io.print("-+*+-+*+-+*+- New Game -+*+-+*+-+*+-");
    }

    /**
     * Prompts the user for a guess for the current game.
     * It will ask for a guess and say how many guesses are remaining
     * @param game the current game
     * @return the user's guess
     */
    public List<Integer> promptGuess(Game game){
        return io.readIntList("Make a Guess ("+game.getNumberOfGuessesLeft()+" guesses remaining):");
    }


    /**
     * Prints a win result to user
     * @param game current game
     */
    public void winGameResult(Game game){
        io.print("Correct!!!");
        io.print("The answer is "+game.getAnswerInt());
    }

    /**
     * Prints a lost result to user
     * @param game current game
     */
    public void lostGameResult(Game game){
        io.print("Ran Out of Guesses");
        io.print("The answer is "+game.getAnswerInt());
        io.print("Better luck next time");
    }

    /**
     * Print the result of a single round showing exact and partial matches of the guess
     * @param game current game
     */
    public void roundResult(Game game){
        io.print(game.getGameResult().toString());
    }


    //display single game

    public void getDisplaySingleGameBanner(){
        io.print("-+*+-+*+-+*+-   Search Game   -+*+-+*+-+*+-");
    }

    /**Prompts the user for the Game Id,
     * @return Game ID
     */
    public int askGameID (){
        return io.readInt("Please enter Game ID:");
    }

    /**Print details of a single Game
     * @param game game to display Game Details
     */
    public void displaySingleGameInfo(Game game){
        io.print("Game ID: "+game.getId());
        io.print("Number of Guesses: "+game.getNumberOfGuessesUsed());
        io.print("Answer: "+game.getAnswerInt());
        if(game.getIsWon()){
            io.print("Win or Lose: Win");
        }else{
            io.print("Win or Lose: Lose");
        }
    }


    //All Games

    public void getDisplayAllGamesBanner(){
        io.print("-+*+-+*+-+*+-   All Games   -+*+-+*+-+*+-");
    }


    /**Displays the info of All Games for a given list array
     * @param gameList List array of games to display
     */
    public void displayGameList(List<Game> gameList){
        for (Game game:gameList){
            io.print("-+*+-+*+-+*+-+*+-+*+-+*+-");
            displaySingleGameInfo(game);
        }
    }




    //error


    /**Prints the error message of the exception being thrown     *
     * @param errorMsg Error message from exception
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }


}
