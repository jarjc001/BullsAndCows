package com.BullsCows.dao;

import com.BullsCows.dto.Game;

import java.util.List;

public interface BullsCowsDao {

    /**
     * Adds a completed game to the Database,
     * it adds it answer, number of guess and if they won or not
     */
    void addGame (Game game);

    /**
     * gets the Game info from a given game id into a Game object.
     * If the game id is not in database, it will return an exception
     * @param id game id of game info want to find
     * @return the game object of given id
     */
    Game getGameFromId (int id) throws BullsCowsDataException;

    /**
     * Gets all Game info from Database into a list
     * @return List of Game objects from Database
     */
    List<Game> getAllGames();


    /**Clears the whole database, used for testing
     */
    public void clearDatabase() ;


}
