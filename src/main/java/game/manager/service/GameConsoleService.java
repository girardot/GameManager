package game.manager.service;

import game.manager.model.Game;

import java.util.List;

public interface GameConsoleService {

    void loadGameConsolesInMermory();

    List<Game> getAllConsoles();

}
