package game.manager.service;

import game.manager.model.Game;

import java.util.List;

public interface GameService {

    public Game findById(long id);

    public List<Game> findAll();

    public Game findByTitle(String title);

    public void save(Game game);

    public void update(Game game);

    public void delete(Game game);

    public void shutdown();

}
