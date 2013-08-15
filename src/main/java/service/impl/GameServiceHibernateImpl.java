package service.impl;

import dao.impl.GameDaoCsvImpl;
import dao.impl.GameDaoHibernateImpl;
import model.Game;
import org.springframework.stereotype.Service;
import service.GameService;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceHibernateImpl implements GameService {

    private GameDaoHibernateImpl gameDao;

    public GameServiceHibernateImpl() {
    }

    @Inject
    public GameServiceHibernateImpl(GameDaoHibernateImpl gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public void loadGamesInMermory() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addNewGame(Game game) {
        gameDao.save(game);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.findAll();
    }
}
