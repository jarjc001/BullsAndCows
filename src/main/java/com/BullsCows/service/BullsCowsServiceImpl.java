package com.BullsCows.service;

import com.BullsCows.dao.BullsCowsDao;
import com.BullsCows.dao.BullsCowsDataException;
import com.BullsCows.dto.Game;
import com.BullsCows.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BullsCowsServiceImpl implements BullsCowsService{

    /** Declaration of the dao */
    private BullsCowsDao dao;

    /** constructor*/
    @Autowired
    public BullsCowsServiceImpl(BullsCowsDao dao) {
        this.dao = dao;
    }

    /**Constructor for testing*/
    public BullsCowsServiceImpl(){};

    @Override
    public List<Integer> generateNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random rng = new Random();

        while (numbers.size()<Game.AMOUNT_OF_COWS) {      //will create a set of size 4
            numbers.add(rng.nextInt(8)+1);
        }
        return new ArrayList<>(numbers);
    }


    /**takes an int input and converts it into a List array of its digits
     * @param number - int to be converted
     * @return a list array of digits
     */
    private ArrayList<Integer> convertGuessToListArray (int number){
        ArrayList<Integer> array = new ArrayList<Integer>();

        do{
            array.add(0,number % 10); //gets the smallest digit
            number /= 10;       //removes the smallest digit
        } while (number > 0);
        return array;
    }

    @Override
    public void singleRound(Game game, int guess) {
        Result result = new Result();
        int indexCounter = 0;

        ArrayList<Integer> guessArray = convertGuessToListArray(guess);

        for (int answerInt:game.getAnswerList()){
            //checks if the guess has one of the answer's numbers
            if(guessArray.contains(answerInt)){
                //checks if the answer is in same position as the guess
                if(guessArray.get(indexCounter)==answerInt){
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

    @Override
    public GameProgress checkGameEnd(Game game){
        //get game result from the game object
        if(game.getGameResult().getExact() == Game.AMOUNT_OF_COWS){//user guessed right
            game.setWon(true);
            return GameProgress.WIN;
        }else if (game.getNumberOfGuessesUsed()== Game.AMOUNT_OF_ROUNDS){//user ran out of rounds
            game.setWon(false);
            return GameProgress.LOST;
        }
        return GameProgress.NOT_FINISHED;
    }


    @Override
    public void addGameToDB(Game game){
        dao.addGame(game);
    }

    @Override
    public Game displayGameFromId (int id) throws BullsCowsDataException {
        return dao.getGameFromId(id);
    }


    @Override
    public List<Game> displayAllGames (){
        return dao.getAllGames();
    }






}
