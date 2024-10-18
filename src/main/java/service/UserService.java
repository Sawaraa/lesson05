package service;

import abstractDao.AbstractDao;
import domain.Product;
import domain.User;

public interface UserService extends AbstractDao<User> {
    User getUserByEmail(String email);
    String getRoleByEmail(String email);
}
