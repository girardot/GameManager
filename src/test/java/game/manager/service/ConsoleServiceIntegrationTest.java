package game.manager.service;

import game.manager.model.Console;
import game.manager.model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.extractProperty;

public class ConsoleServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private ConsoleService consoleService;

    @Test
    public void should_add_new_console() {
        // Given
        Console console = new Console("ps3");

        // When
        consoleService.save(console);

        //Then
        List<Console> consoles = consoleService.findAll();
        Console consoleResult = consoles.get(0);
        Assertions.assertThat(consoleResult.getName()).isEqualTo("ps3");
    }

    @Test
    public void should_add_console_and_games() {
        // Given
        Console console = new Console("ps3");
        console.addGame(new Game("Call of duty"));
        console.addGame(new Game("Call of duty 2"));
        console.addGame(new Game("Call of duty 3"));

        // When
        consoleService.save(console);

        // Then
        List<Console> consoles = consoleService.findAll();
        Console console1 = consoles.get(0);

        Assertions.assertThat(extractProperty("name").from(consoles)).contains("ps3");
        Assertions.assertThat(extractProperty("title").from(console1.getGames())).contains("Call of duty", "Call of duty 2", "Call of duty 3");
    }

}
