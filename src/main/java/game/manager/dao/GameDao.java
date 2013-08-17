package game.manager.dao;

import game.manager.model.Game;

import java.util.List;

public interface GameDao {

    public Game findById(long id);

    public List<Game> findAll();

    public List findByTitle(String title);

    public void save(Game customer);

    public void update(Game customer);

    public void delete(Game customer);

    public void shutdown();
}
