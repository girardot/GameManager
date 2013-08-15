package game.manager.dao.impl;

import game.manager.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static game.manager.helper.CsvFileHelper.readCsvFile;

@Repository
public class GameDaoCsvImpl {

    @Value("${ressources.path}")
    private String resourcesPath;
    
    @Value("${csv.games}")
    private String gameFileName;

    private final static char SEPARATOR = ';';

    public GameDaoCsvImpl() {
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getGameFileName() {
        return gameFileName;
    }

    public void setGameFileName(String gameFileName) {
        this.gameFileName = gameFileName;
    }

    public List<Game> findGames() throws FileNotFoundException {

        final List<String[]> data = readCsvFile(resourcesPath + gameFileName, SEPARATOR);

        List<Game> games = dataToGames(data);

        return games;
    }


    public List<Game> dataToGames(List<String[]> data) {
        List<Game> games = new ArrayList<Game>();

        for (String[] oneData : data) {
            String title = oneData[0];
            games.add(new Game(title));
        }
        return games;
    }

}
