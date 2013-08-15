package dao;

import model.Game;
import model.GameConsole;
import org.fest.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static helper.CsvFileHelper.readCsvFile;

@Repository
public class GameConsoleDao {

    @Value("${ressources.path}")
    private String resourcesPath;

    @Value("${csv.game.consoles}")
    private String gameConsoleFileName;

    private final static char SEPARATOR = ';';

    public GameConsoleDao() {
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getGameConsoleFileName() {
        return gameConsoleFileName;
    }

    public void setGameConsoleFileName(String gameConsoleFileName) {
        this.gameConsoleFileName = gameConsoleFileName;
    }

    public List<GameConsole> findGameConsoles() throws FileNotFoundException {

        final List<String[]> data = readCsvFile(resourcesPath + gameConsoleFileName, SEPARATOR);

        List<GameConsole> gameConsoles = dataToGameConsoles(data);

        return gameConsoles;
    }

    @VisibleForTesting
    List<GameConsole> dataToGameConsoles(List<String[]> data) {
        List<GameConsole> gameConsoles = new ArrayList<GameConsole>();

        for (String[] oneData : data) {
            String name = oneData[0];
            gameConsoles.add(new GameConsole(name));
        }
        return gameConsoles;
    }

}
