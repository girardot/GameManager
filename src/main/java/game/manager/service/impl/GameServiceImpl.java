package game.manager.service.impl;

import game.manager.dao.GameDao;
import game.manager.model.Game;
import game.manager.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "gameService" )
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public Game findById( long id )
    {
        return gameDao.findById( id );
    }

    @Override
    public List<Game> findAll()
    {
        return gameDao.findAll();
    }

    @Override
    public void save( Game customer )
    {
        gameDao.save(customer);
    }

    @Override
    public void update( Game customer )
    {
        gameDao.update(customer);
    }

    @Override
    public void delete( Game customer )
    {
        gameDao.delete(customer);
    }

    @Override
    public void shutdown()
    {
        gameDao.shutdown();
    }
}
