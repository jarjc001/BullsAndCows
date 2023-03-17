package com.BullsCows.service;

import com.BullsCows.dao.BullsCowsDao;
import com.BullsCows.dto.Game;
import com.BullsCows.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BullsCowsServiceImpl implements BullsCowsService{

    /**the amount of digits in the answer number*/
    private static final int AMOUNT_OF_COWS = 4;
    /**The amount of rounds in a game*/
    public static final int AMOUNT_OF_ROUNDS = 10;

    /** Declaration of the dao */
    private BullsCowsDao dao;

    /** constructor*/
    @Autowired
    public BullsCowsServiceImpl(BullsCowsDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Integer> generateNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random rng = new Random();

        while (numbers.size()<AMOUNT_OF_COWS) {      //will create a set of size 4
            numbers.add(rng.nextInt(8)+1);
        }
        return new ArrayList<>(numbers);
    }

    @Override
    public void singleRound(Game game, List<Integer> guess) {
        Result result = new Result();
        int indexCounter = 0;

        for (int answerInt:game.getAnswerList()){
            //checks if the guess has one of the answer's numbers
            if(guess.contains(answerInt)){
                //checks if the answer is in same position as the guess
                if(guess.get(indexCounter)==answerInt){
                    result.setExact(result.getExact()+1);
                }else{
                    result.setPartial(result.getPartial()+1);
                }
            }
            // gets the next index
            indexCounter++;
        }
        game.countGuess();
        game.setGameResult(result);
    }

    /**
     * Checks to see if the game has ended, whether the user guessed correctly or ran out of guesses
     * @param game game object of current game
     * @return whether the game has ended
     */
    public GameEnd checkGameEnd(Game game){
        //get game result from the game object
        if(game.getGameResult().getExact() == AMOUNT_OF_COWS){//user guessed right
            game.setWon(true);
            return GameEnd.WIN;
        }else if (game.getNumberOfGuesses()== AMOUNT_OF_ROUNDS){
            game.setWon(false);
            return GameEnd.LOST;
        }
        return GameEnd.NOT_FINISHED;
    }

    /**
     * Adds a game's info to the Database when the game is finished
     * @param game
     */
    public void addGameToDB(Game game){
        dao.addGame(game);
    }



    //add a method display game info



    //create a method to send result object to dao


}
