package game.manager.service;

import game.manager.model.Console;
import game.manager.model.Game;

import java.util.List;

public interface ConsoleService {

    public Console findById(long id);

    public List<Console> findAll();

    public void save(Console console);

    public void update(Console console);

    public void delete(Console console);

    public void shutdown();

}
