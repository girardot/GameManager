package dao.impl;

import dao.GameDao;
import model.Game;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static helper.CsvFileHelper.readCsvFile;

@Repository
public class GameDaoHibernateImpl extends HibernateDaoSupport implements GameDao {

    public Game findById(long id) {
        return (Game) getHibernateTemplate().get(Game.class, id);
    }

    public List<Game> findAll() {
        return getHibernateTemplate().find("from model.Game");
    }

    public void save(Game game) {
        getHibernateTemplate().save(game);
    }

    public void update(Game game) {
        getHibernateTemplate().update(game);
    }

    public void delete(Game game) {
        getHibernateTemplate().delete(game);
    }

    public void shutdown() {
        getHibernateTemplate().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();
    }

    @Inject
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
