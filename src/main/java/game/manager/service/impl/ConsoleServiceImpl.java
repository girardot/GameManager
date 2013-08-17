package game.manager.service.impl;

import game.manager.dao.ConsoleDao;
import game.manager.model.Console;
import game.manager.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("consoleService")
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private ConsoleDao consoleDao;

    @Override
    public Console findById(long id) {
        return consoleDao.findById(id);
    }

    @Override
    public List<Console> findAll() {
        return consoleDao.findAll();
    }

    @Override
    public void save(Console console) {
        consoleDao.save(console);
    }

    @Override
    public void update(Console console) {
        consoleDao.update(console);
    }

    @Override
    public void delete(Console console) {
        consoleDao.delete(console);
    }

    @Override
    public void shutdown() {
        consoleDao.shutdown();
    }
}
