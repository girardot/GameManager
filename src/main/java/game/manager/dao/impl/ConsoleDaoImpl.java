package game.manager.dao.impl;

import game.manager.dao.ConsoleDao;
import game.manager.dao.GameDao;
import game.manager.model.Console;
import game.manager.model.Game;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("ConsoleDao")
public class ConsoleDaoImpl extends HibernateDaoSupport implements ConsoleDao {

    @Override
    public Console findById(long id) {
        return (Console) getHibernateTemplate().get(Console.class, id);
    }

    @Override
    public List<Console> findAll() {
        return getHibernateTemplate().find("from game.manager.model.Console");
    }

    @Override
    public List<Console> findByName(String name) {
        return getHibernateTemplate().find("from game.manager.model.Console c where c.name=?", name);
    }

    @Override
    public void save(Console console) {
        getHibernateTemplate().save(console);
    }

    @Override
    public void update(Console console) {
        getHibernateTemplate().update(console);
    }

    @Override
    public void delete(Console console) {
        getHibernateTemplate().delete(console);
    }

    @Override
    public void shutdown() {
        getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();
    }

    @Inject
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
