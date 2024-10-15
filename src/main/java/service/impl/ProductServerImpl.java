package service.impl;

import dao.Imlp.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import org.apache.log4j.Logger;
import service.ProsuctService;

import java.sql.SQLException;
import java.util.List;

public class ProductServerImpl implements ProsuctService {

    private ProductDao productDao;
    private static Logger logger = Logger.getLogger(ProductServerImpl.class);

    public ProductServerImpl() {
        try {
            productDao = new ProductDaoImpl();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product read(int id)  {
        return productDao.read(id);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(int id)  {
        productDao.delete(id);
    }

    @Override
    public List<Product> readAll(){
        return productDao.readAll();
    }
}
