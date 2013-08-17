package game.manager.dao;

import game.manager.model.Console;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConsoleDao {

    Console findById(long id);

    List<Console> findAll();

    List findByName(String s);

    void save(Console customer);

    void update(Console customer);

    void delete(Console customer);

    void shutdown();
}
