import model.Game;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.GameService;

import javax.inject.Inject;
import java.util.List;

public class GameManager {

    private static final String RESOURCES_PATH = "src/main/resources/";

    private String GAME_FILE_NAME = "games.csv";

    private String GAME_CONSOLE_FILE_NAME = "games-console.csv";


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml", GameManager.class);

        GameService gameService = (GameService)context.getBean("gameServiceHibernateImpl");

        //gameService.loadGamesInMermory();

        //gameService.addNewGame(new Game("Call of duty"));
        gameService.addNewGame(new Game("Call of duty"));

        List<Game> allGames = gameService.getAllGames();

        for (Game game : allGames) {
            System.out.println(game);
        }


    }


}
