package dao.Imlp;

import abstractDao.FactoryManager;
import connection.ConnectionDataBase;
import dao.BasketDao;
import domain.Basket;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDaoImpl implements BasketDao {
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Basket create(Basket basket)  {
        try {
            em.getTransaction().begin();
            em.persist(basket);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return basket;

    }

    @Override
    public Basket read(int id)  {
        Basket basket = null;
        try {
            basket = em.find(Basket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return basket;
    }

    @Override
    public Basket update(Basket basket) {
        throw new IllegalStateException("there is no update for product");
    }

    @Override
    public void delete(int id)  {
        try {
            Basket basket = read(id);
            em.getTransaction().begin();
            em.remove(basket);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Basket> readAll()  {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Bucket e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }
}
