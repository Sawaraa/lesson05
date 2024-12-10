package dao.Imlp;

import abstractDao.FactoryManager;
import connection.ConnectionDataBase;
import dao.UserDao;
import domain.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public User create(User user)  {

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User read(int id) {
        User user = null;

        try {
            user = em.find(User.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            // TODO: to be implemented
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void delete(int id) {
        try {
            // TODO: to be implemented
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readAll()  {

        List<User> userRecords = new ArrayList<>();
        try {
            // TODO: to be implemented
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userRecords;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<User> typed = em.createQuery(criteria);
            user = typed.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public String getRoleByEmail(String email) {
        String role = null;

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<String> criteria = builder.createQuery(String.class);
            Root<User> from = criteria.from(User.class);
            criteria.select(from.get("role"));
            criteria.where(builder.equal(from.get("email"), email));
            TypedQuery<String> typed = em.createQuery(criteria);
            role = typed.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            preparedStatement = connection.prepareStatement(GET_ROLE);
//            preparedStatement.setString(1, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                role = resultSet.getString("role");
//            }
//        } catch (Exception e) {
//            logger.error(e);
//        }

        return role;
    }
}
