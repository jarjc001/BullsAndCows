package com.BullsCows.service;

import com.BullsCows.dao.BullsCowsDataException;
import com.BullsCows.dto.Game;

import java.util.ArrayList;
import java.util.List;

public interface BullsCowsService {


    /**
     * Creates an array list of randomly generated numbers for the user to guess,
     * The numbers are in a certain order and not repeated.
     * @return a list array of the numbers to guess
     */
    public List<Integer> generateNumbers();

    /**takes an int input and converts it into a List array of its digits
     * @param number - int to be converted
     * @return a list array of digits
     */
    public ArrayList<Integer> convertGuessToListArray (int number);

    /**
     * Does one round of the game, will compare the answer and the user's guess.
     * then will return the result, exact match and partial match
     *
     * @param game  the game object of current game
     * @param guess the user's guess
     */
    public void singleRound(Game game, int guess);

    /**
     * Checks to see if the game has ended, whether the user guessed correctly or ran out of guesses
     * @param game game object of current game
     * @return whether the game has ended
     */
    public GameProgress checkGameEnd(Game game);

    /**
     * Adds a game's info to the Database when the game is finished
     * @param game game object of current game
     */
    public void addGameToDB(Game game);


    /**
     *Gets a game object for a game saved in the database from its game id
     * @param id Game id of game wanted to how info
     * @return game object of game info
     * @throws BullsCowsDataException Exception
     */
    public Game displayGameFromId (int id) throws BullsCowsDataException;


    /**Gets a list of all game info on Database
     * @return List of game objects from the database
     */
    public List<Game> displayAllGames ();




}
