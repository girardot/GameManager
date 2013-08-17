package game.manager.service;

import game.manager.model.Console;
import game.manager.model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.extractProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class ConsoleServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Inject
    private ConsoleService consoleService;

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
