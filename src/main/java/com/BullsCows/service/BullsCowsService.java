package com.BullsCows.service;

import com.BullsCows.dto.Game;

import java.util.List;

public interface BullsCowsService {


    /**
     * Creates an array list of randomly generated numbers for the user to guess,
     * The numbers are in a certain order and not repeated.
     * @return a list array of the numbers to guess
     */
    public List<Integer> generateNumbers();

    /**
     * Does one round of the game, will compare the answer and the user's guess.
     * then will return the result, exact match and partial match
     *
     * @param game  the game object of current game
     * @param guess the user's guess
     */
    public void singleRound(Game game, List<Integer> guess);




}
