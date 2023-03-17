import com.BullsCows.dto.Game;
import com.BullsCows.dto.Result;
import com.BullsCows.service.BullsCowsServiceImpl;
import com.BullsCows.service.GameProgress;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BullsCowsServiceTest {

    BullsCowsServiceImpl testService = new BullsCowsServiceImpl();


    public BullsCowsServiceTest() {
    }


    @Test
    public void testSingleRound() {
        //create an answer of 1357
        List<Integer> testAnswer = List.of(1,3,5,7);

        //creates fresh game with the test answer
        Game testGame = new Game(testAnswer);


        //test when answer is fully wrong


        // a guess that is fully wrong
        List<Integer> testGuessFullyWrong = List.of(2,4,6,8);
        testService.singleRound(testGame,testGuessFullyWrong);

        Result fullyWrong = testGame.getGameResult();

        Assertions.assertEquals(0,fullyWrong.getExact(),"Check if exact match is 0");
        Assertions.assertEquals(0,fullyWrong.getPartial(),"Check if partial match is 0");

        Assertions.assertEquals(testService.checkGameEnd(testGame), GameProgress.NOT_FINISHED,"Checking if it says the game has not finished");


        //test when answer is Partially wrong

        //a guess that is Partially Wrong should have 1 exact match and 2 partial matches
        List<Integer> testGuessPartialWrong = List.of(1,5,7,8);
        testService.singleRound(testGame,testGuessPartialWrong);

        Result PartiallyWrong = testGame.getGameResult();

        Assertions.assertEquals(1,PartiallyWrong.getExact(),"Check if exact match is 1");
        Assertions.assertEquals(2,PartiallyWrong.getPartial(),"Check if partial match is 2");

        Assertions.assertEquals(testService.checkGameEnd(testGame), GameProgress.NOT_FINISHED,"Checking if it says the game has not finished");

    }


    @Test
    public void testWin() {
        //create an answer of 1357
        List<Integer> testAnswer = List.of(1,3,5,7);

        //creates fresh game with the test answer
        Game testGame = new Game(testAnswer);

        //Guesses with the answer
        testService.singleRound(testGame,testAnswer);

        Result correct = testGame.getGameResult();

        Assertions.assertEquals(4,correct.getExact(),"Check if exact match is 1");
        Assertions.assertEquals(0,correct.getPartial(),"Check if partial match is 2");

        Assertions.assertEquals(testService.checkGameEnd(testGame), GameProgress.WIN,"Checking if it says user has won");

    }




}
