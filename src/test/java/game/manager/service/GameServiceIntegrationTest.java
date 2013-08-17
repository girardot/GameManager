package game.manager.service;

import game.manager.model.Game;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import javax.inject.Inject;

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
        Game gameResult = gameService.findByTitle("Call of duty");
        Assertions.assertThat(gameResult.getTitle()).isEqualTo("call of duty");
    }

    @Test
    public void should_find_game_by_title() {
        // When
        Game gameResult = gameService.findByTitle("Call of duty");

        //Then
        Assertions.assertThat(gameResult.getTitle()).isEqualTo("call of duty");
    }

}
