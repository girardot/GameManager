package game.manager.dao;

import game.manager.model.Console;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConsoleDao {

    public Console findById(long id);

    public List<Console> findAll();

    public void save(Console customer);

    public void update(Console customer);

    public void delete(Console customer);

    public void shutdown();

}
