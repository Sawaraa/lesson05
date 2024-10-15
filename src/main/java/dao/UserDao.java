package dao;

import abstractDao.AbstractDao;
import domain.User;

public interface UserDao extends AbstractDao<User> {
    User getUserByEmail(String email);

}
