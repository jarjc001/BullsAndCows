package com.BullsCows.service;

import com.BullsCows.dto.Result;

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
     * @param answer the answer to guess
     * @param guess the user's guess
     * @return result
     */
    public Result singleRound(List<Integer> answer, List<Integer> guess);




}
