package game.manager;

import com.google.common.collect.Lists;
import game.manager.model.Console;
import game.manager.model.Game;
import game.manager.service.ConsoleService;
import game.manager.service.GameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GameManager {

    private static ApplicationContext applicationContext;

    private static GameService gameService;

    private static ConsoleService consoleService;

    public static void initServices() {
        gameService = (GameService) applicationContext.getBean("gameService");
        consoleService = (ConsoleService) applicationContext.getBean("consoleService");
    }

    public static void main(String[] args) {

        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        initServices();

        Console console = new Console("ps3");
        console.addGame(new Game("Call of duty"));

        consoleService.save(console);

        gameService.shutdown();
        consoleService.shutdown();

        showConsolesAndGames();

    }

    public static void showGames(List<Game> games) {
        if(games == null || games.isEmpty()) {
            return;
        }

        System.out.println("Games:");
        for (Game game : games) {
            System.out.println("\t" + game.getTitle());
        }
    }

    public static void showConsolesAndGames() {
        List<Console> consoles = consoleService.findAll();
        System.out.println("Consoles:");
        for (Console console : consoles) {
            System.out.println("\t" + console.getName());
            showGames(console.getGames()) ;
        }
    }

}
