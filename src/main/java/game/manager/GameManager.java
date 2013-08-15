package game.manager;

import game.manager.model.Game;
import game.manager.service.GameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GameManager {

    private static ApplicationContext applicationContext;

    private static GameService gameService;


    public static void main(String[] args) {

        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        gameService = (GameService) applicationContext.getBean("gameService");

        showGames();
        addGame("Call of duty");
        showGames();

    }

    public static void addGame(String title) {
        gameService.save(new Game("Call of duty"));
    }

    public static void showGames() {
        List<Game> games = gameService.findAll();
        System.out.println("Customers:");
        for (Game game : games) {
            System.out.println("\t" + game.getTitle());
        }
    }


}
