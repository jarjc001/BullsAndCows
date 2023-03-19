import com.BullsCows.TestApplicationConfiguration;
import com.BullsCows.dao.BullsCowsDao;
import com.BullsCows.dao.BullsCowsDataException;
import com.BullsCows.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class BullsCowsDaoTest {


    @Autowired
    BullsCowsDao dao;

    @Before
    public void setUp() {

        dao.clearDatabase();
    }

    @Test
    public void testAddGame()  {

        //A game that has
        // id = 2
        // number of guess as 4
        // answer as 1234
        // Win as true
        Game game = new Game(2,4,1234,true);

        dao.addGame(game);

        //the game object from the database
        Game fromDao;

        try {
            fromDao = dao.getGameFromId(game.getId());
        } catch (BullsCowsDataException e) {
            fromDao = null;
        }

        Assertions.assertEquals(game,fromDao);

    }


}
