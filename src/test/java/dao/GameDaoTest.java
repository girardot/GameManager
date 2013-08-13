package dao;

import com.sun.xml.internal.ws.policy.AssertionSet;
import model.Game;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.util.List;

public class GameDaoTest {

    public GameDao gameDao;

    public GameDaoTest() {
    }

    @Before
    public void setUp() throws Exception {
        gameDao = new GameDao();
    }

    @Test
    public void should_() {
        // When
        List<Game> games = null;
        try {
            games = gameDao.findGames();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // Then
        Assertions.assertThat(games.size()).isEqualTo(3);
    }

}
