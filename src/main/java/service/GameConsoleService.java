package service;

import model.Game;

import java.util.List;

public interface GameConsoleService {

    void loadGameConsolesInMermory();

    List<Game> getAllConsoles();

}
