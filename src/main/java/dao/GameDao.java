package dao;

import model.Game;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static helper.CsvFileHelper.readCsvFile;

@Repository
public class GameDao {

    private final static String RESOURCES_PATH = "src/main/resources/";

    private final static String ELEVES_FILE_NAME = "games.csv";

    private final static char SEPARATOR = ';';

    public List<Game> findGames() throws FileNotFoundException {

        final List<String[]> data = readCsvFile(RESOURCES_PATH + ELEVES_FILE_NAME, SEPARATOR);

        List<Game> games = dataToGames(data);

        return games;
    }

    private List<Game> dataToGames(List<String[]> data) {
        List<Game> games = new ArrayList<Game>();

        for (String[] oneData : data) {
            String title = oneData[0];
            games.add(new Game(title));
        }
        return games;
    }

}
