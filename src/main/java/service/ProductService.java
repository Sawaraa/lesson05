package service;

import abstractDao.AbstractDao;
import domain.Product;

import java.util.Map;

public interface ProductService extends AbstractDao<Product> {
    public Map<Integer, Product> readAllMap();
}
