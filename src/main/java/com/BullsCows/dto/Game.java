package com.BullsCows.dto;

import java.util.List;

/**GAme object to keep track of a single game of Bulls Cows
 */
public class Game {

    /**The amount of rounds in a game*/
    public static final int AMOUNT_OF_ROUNDS = 10;

    /**the amount of digits in the answer number*/
    public static final int AMOUNT_OF_COWS = 4;

    private int id;
    private List<Integer> answerList;
    private int answerInt;
    private int numberOfGuesses;
    private Result gameResult;
    private boolean isWon;

    /**
     * Constuctor for a single game of BullsCows.
     * Created at the start of a game
     * @param answer answer as  a list array
     */
    public Game(List<Integer> answer) {
        this.answerList = answer;
        this.numberOfGuesses = 0;
        this.isWon = false;
        this.gameResult = new Result();
        convertAnswerListInt();

    }

    /**Constructor for mapping Game from a data
     * @param id game id
     * @param answer answer as an int
     * @param numberOfGuesses number of guesses left
     * @param isWon did user win
     */
    public Game(int id, int numberOfGuesses, int answer, boolean isWon) {
        this.id = id;
        this.numberOfGuesses = numberOfGuesses;
        this.answerInt = answer;
        this.isWon = isWon;
    }

    //getters

    public int getId() {
        return id;
    }
    public List<Integer> getAnswerList() {
        return this.answerList;
    }
    public int getAnswerInt() {
        return answerInt;
    }
    public int getNumberOfGuessesUsed() {
        return this.numberOfGuesses;
    }
    public int getNumberOfGuessesLeft() {
        return (AMOUNT_OF_ROUNDS-this.numberOfGuesses);
    }
    public boolean getIsWon() {
        return this.isWon;
    }
    public Result getGameResult() {
        return gameResult;
    }



    //Setter
    public void setWon(boolean won) {
        isWon = won;
    }

    /** set from a result object */
    public void setGameResult(Result gameResult) {
        this.gameResult = gameResult;
    }
    /** set from exact and partial int separtly*/
    public void setGameResult(int exact, int partial) {
        this.gameResult.setExact(exact);
        this.gameResult.setPartial(partial);
    }






    /**Converts the answer Array List as a single int
     */
    public void convertAnswerListInt(){
        int res = 0;
        for (int i: this.answerList){
            res=(res*10)+i;
        }
        this.answerInt = res;
    }

    /** keeps track of guesses*/
    public void countGuess(){
        this.numberOfGuesses++;
    }


}
