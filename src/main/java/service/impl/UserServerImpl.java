package service.impl;

import dao.Imlp.UserDaoImpl;
import dao.UserDao;
import domain.User;
import org.apache.log4j.Logger;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServerImpl implements UserService {

    private static UserService userServiceImpl;
    private UserDao userDao;

    private UserServerImpl() throws SQLException {
        userDao = new UserDaoImpl();
    }

    public static UserService getUserService() throws SQLException {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServerImpl();
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

    @Override
    public String getRoleByEmail(String email) {
        return userDao.getRoleByEmail(email);
    }
}
