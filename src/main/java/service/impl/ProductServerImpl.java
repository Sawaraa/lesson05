package service.impl;

import dao.Imlp.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import service.ProsuctService;

import java.sql.SQLException;
import java.util.List;

public class ProductServerImpl implements ProsuctService {

    private ProductDao productDao;

    public ProductServerImpl() throws SQLException {
        productDao = new ProductDaoImpl();
    }

    @Override
    public Product create(Product product) throws SQLException {
        return productDao.create(product);
    }

    @Override
    public Product read(int id) throws SQLException {
        return productDao.read(id);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(int id) throws SQLException {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll() throws SQLException {
        return productDao.readAll();
    }
}
