package service.impl;

import dao.Imlp.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServerImpl implements UserService {

    private UserDao userDao;

    public UserServerImpl() throws SQLException {

        userDao = new UserDaoImpl();
    }

    @Override
    public User create(User user) throws SQLException {
        return userDao.create(user);
    }

    @Override
    public User read(int id) throws SQLException {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(int id) throws SQLException {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() throws SQLException {
        return userDao.readAll();
    }
}
