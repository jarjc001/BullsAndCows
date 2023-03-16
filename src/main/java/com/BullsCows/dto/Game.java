package com.BullsCows.dto;

import java.util.List;

/**GAme object to keep track of a single game of Bulls Cows
 */
public class Game {

    private int id;
    private List<Integer> answer;
    private int numberOfGuesses;
    private boolean isWon;

    /**
     * Constuctor for a single game of BullsCows.
     * Created at the start of a game
     * @param answer the generated answer for the
     */
    public Game(List<Integer> answer) {
        this.answer = answer;
        this.numberOfGuesses = 0;
        this.isWon = false;
    }

    /**Basic Constructor
     * @param id game id
     * @param answer answer
     * @param numberOfGuesses number of guesses
     * @param isWon did user win
     */
    public Game(int id, List<Integer> answer, int numberOfGuesses, boolean isWon) {
        this.id = id;
        this.answer = answer;
        this.numberOfGuesses = numberOfGuesses;
        this.isWon = isWon;
    }

    //getters

    public int getId() {
        return id;
    }
    public List<Integer> getAnswer() {
        return this.answer;
    }
    public int getNumberOfGuesses() {
        return this.numberOfGuesses;
    }
    public boolean isWon() {
        return this.isWon;
    }


    //Setter
    public void setWon(boolean won) {
        isWon = won;
    }

    /**Gets the answer Array as a single int
     * @return answer as a single array
     */
    public int getAnswerInt(){
        int res = 0;
        for (int i: this.answer){
            res=res*10+i;
        }
        return res;
    }

    public void countGuess(){
        this.numberOfGuesses++;
    }


}
