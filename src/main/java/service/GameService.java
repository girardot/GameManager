package service;

import model.Game;

import java.util.List;

public interface GameService {

    void loadGamesInMermory();

    void addNewGame(Game game);

    List<Game> getAllGames();

}
