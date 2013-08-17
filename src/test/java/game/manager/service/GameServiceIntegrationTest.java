package game.manager.service;

import game.manager.model.Console;
import game.manager.model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

import static org.fest.assertions.api.Assertions.extractProperty;

public class GameServiceIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private GameService gameService;

    @Test
    public void should_add_new_game() {
        // Given
        Game game = new Game("Call of duty");

        // When
        gameService.save(game);

        //Then
        List<Game> games = gameService.findAll();
        Game gameResult = games.get(0);
        Assertions.assertThat(gameResult.getTitle()).isEqualTo("Call of duty");
    }


}
