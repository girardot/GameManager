package game.manager.service;

import game.manager.model.Game;

import java.util.List;

public interface GameService {

    public Game findById(long id);

    public List<Game> findAll();

    public void save(Game customer);

    public void update(Game customer);

    public void delete(Game customer);

    public void shutdown();

}
