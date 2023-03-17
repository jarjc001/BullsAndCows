package com.BullsCows.dto;

import java.util.List;

/**GAme object to keep track of a single game of Bulls Cows
 */
public class Game {

    private int id;
    private List<Integer> answerList;
    private int answerInt;
    private int numberOfGuesses;
    private Result gameResult;
    private boolean isWon;

    /**
     * Constuctor for a single game of BullsCows.
     * Created at the start of a game
     * @param answer the generated answer for the
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
     * @param answer answer
     * @param numberOfGuesses number of guesses
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
    public int getNumberOfGuesses() {
        return this.numberOfGuesses;
    }
    public boolean getIsWon() {
        return this.isWon;
    }
    public Result getGameResult() {
        return gameResult;
    }


    //Setter

    public void setId(int id) {
        this.id = id;
    }
    public void setAnswerInt(int answerInt) {
        this.answerInt = answerInt;
    }
    public void setWon(boolean won) {
        isWon = won;
    }
    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
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
            res=res*10+i;
        }
        this.answerInt = res;
    }

    public void countGuess(){
        this.numberOfGuesses++;
    }


}
