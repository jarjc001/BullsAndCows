package com.BullsCows.service;

import com.BullsCows.dto.Result;

import java.util.*;

public class BullsCowsServiceImpl implements BullsCowsService{

    private static final int AMOUNT_OF_COWS = 4;
    private static final int AMOUNT_OF_ROUNDS = 10;






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
    public Result singleRound(List<Integer> answer, List<Integer> guess) {
        Result result = new Result();
        int indexCounter = 0;

        for (int answerI:answer){
            //checks if the guess has one of the answer's numbers
            if(guess.contains(answerI)){
                //checks if the answer is in same position as the guess
                if(guess.get(indexCounter)==answerI){
                    result.setExact(result.getExact()+1);
                }else{
                    result.setPartial(result.getPartial()+1);
                }
            }
            // gets the next index
            indexCounter++;
        }
        return result;
    }


}
