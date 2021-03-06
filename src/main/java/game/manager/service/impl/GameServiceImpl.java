package game.manager.service.impl;

import game.manager.dao.GameDao;
import game.manager.model.Game;
import game.manager.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public Game findById(long id) {
        return gameDao.findById(id);
    }

    @Override
    public List<Game> findAll() {
        return gameDao.findAll();
    }

    @Override
    public Game findByTitle(String title) {
        Game result = null;
        List gamesByTitle = gameDao.findByTitle(title.toLowerCase());

        if (gamesByTitle.size() > 0) {
            result = (Game) gamesByTitle.get(0);
        }
        return result;
    }

    @Override
    public void save(Game game) {
        game.setTitle(game.getTitle().toLowerCase());
        gameDao.save(game);
    }

    @Override
    public void update(Game game) {
        gameDao.update(game);
    }

    @Override
    public void delete(Game game) {
        gameDao.delete(game);
    }

    @Override
    public void shutdown() {
        gameDao.shutdown();
    }
}
