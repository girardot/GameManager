package game.manager.dao;

import game.manager.model.Console;
import game.manager.model.Game;
import org.fest.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static game.manager.helper.CsvFileHelper.readCsvFile;

@Repository
public interface ConsoleDao {

    public Console findById(long id);

    public List<Console> findAll();

    public void save(Console customer);

    public void update(Console customer);

    public void delete(Console customer);

    public void shutdown();

}
