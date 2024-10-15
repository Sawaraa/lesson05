package service.impl;

import dao.Imlp.UserDaoImpl;
import dao.UserDao;
import domain.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServerImpl implements UserService {

    private UserDao userDao;
    private static UserService userServiceImpl;
    private static Logger logger = Logger.getLogger(UserServerImpl.class);

    public UserServerImpl(){

        try {
            userDao = new UserDaoImpl();
            if (userDao == null) {
                logger.error("userDao is null");
            }
        } catch (SQLException e) {
            logger.error("Помилка тут" + e);
        }
    }

    public static UserService getUserService(){
        if(userServiceImpl == null){
            userServiceImpl = new UserServerImpl();
        }
        if (userServiceImpl == null) {
            logger.error("UserServiceImpl is null after initialization");
        }

        return userServiceImpl;
    }

    @Override
    public User create(User user)  {
        return userDao.create(user);
    }

    @Override
    public User read(int id)  {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(int id)  {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll()  {
        return userDao.readAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
