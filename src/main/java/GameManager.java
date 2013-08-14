import model.Game;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.GameService;

import javax.inject.Inject;
import java.util.List;

public class GameManager {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml", GameManager.class);

        GameService gameService = (GameService)context.getBean("gameServiceImpl");

        gameService.loadGamesInMermory();
        List<Game> allGames = gameService.getAllGames();

        for (Game game : allGames) {
            System.out.println(game);
        }

    }


}
