package dao;

import model.Game;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.List;

//@ContextConfig
public class GameDaoTest {

    @Inject
    public GameDao gameDao;

    public GameDaoTest() {
//        new ClassPathXmlApplicationContext("context.xml", GameDaoTest.class);
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
