package game.manager.dao.impl;

import game.manager.dao.GameDao;
import game.manager.model.Game;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("gameDao")
public class GameDaoImpl extends HibernateDaoSupport implements GameDao {

    @Override
    public Game findById(long id) {
        return (Game) getHibernateTemplate().get(Game.class, id);
    }

    @Override
    public List<Game> findAll() {
        return getHibernateTemplate().find("from game.manager.model.Game");
    }

    @Override
    public List<Game> findByTitle(String title) {
        return getHibernateTemplate().find("from game.manager.model.Game g where g.title=?", title);
    }

    @Override
    public void save(Game game) {
        getHibernateTemplate().save(game);
    }

    @Override
    public void update(Game game) {
        getHibernateTemplate().update(game);
    }

    @Override
    public void delete(Game game) {
        getHibernateTemplate().delete(game);
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
