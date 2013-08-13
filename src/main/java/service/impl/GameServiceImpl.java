package service.impl;

import dao.GameDao;
import model.Game;
import service.GameService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    private List<Game> games;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
        this.games = new ArrayList<Game>();
    }

    @Override
    public void loadGamesInMermory() {
        if(games.isEmpty()) {
            try {
                games.addAll(gameDao.findGames());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addNewGame(Game game) {
        games.add(game);
    }
}
