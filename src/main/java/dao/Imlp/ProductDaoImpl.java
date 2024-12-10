package dao.Imlp;

import abstractDao.FactoryManager;
import connection.ConnectionDataBase;
import dao.ProductDao;
import domain.Product;
import domain.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public Product create(Product product)  {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product read(int id) {
        Product product = null;
        try {
            product = em.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product update(Product product) {

        try {
            // TODO: to be implemented
        } catch (Exception e) {
        }

        return product;
    }

    @Override
    public void delete(int id)  {
        try {
            // TODO: to be implemented
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Product e");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }
}
