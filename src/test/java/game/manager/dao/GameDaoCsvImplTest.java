package game.manager.dao;

import game.manager.dao.impl.GameDaoCsvImpl;
import game.manager.model.Game;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"applicationContext-test.xml"})
public class GameDaoCsvImplTest {

    public GameDaoCsvImpl gameDao;

    public static final String RESSOURCES_PATH = "src/test/resources/";

    public static final String GAME_FILE_NAME = "games.csv";


    public GameDaoCsvImplTest() {
    }

    @Before
    public void setUp() throws Exception {
        gameDao = new GameDaoCsvImpl();
        gameDao.setResourcesPath(RESSOURCES_PATH);
        gameDao.setGameFileName(GAME_FILE_NAME);
    }

    @Test
    public void should_find_all_games() throws FileNotFoundException {
        // Given
        List<Game> games;

        // When
        games = gameDao.findGames();

        // Then
        Assertions.assertThat(games.size()).isEqualTo(4);
    }

    @Test
    public void should_convert_data_to_games() {
        // Given
        List<Game> games;
        List<String[]>  data = new ArrayList<String[]>();

        data.add(new String[]{"titre-jeux1"});
        data.add(new String[]{"titre-jeux2"});
        data.add(new String[]{"titre-jeux3"});

        // When
        games = gameDao.dataToGames(data);

        // Then
        Assertions.assertThat(games.size()).isEqualTo(3);
    }


}
