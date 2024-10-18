package service.impl;

import dao.Imlp.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import org.apache.log4j.Logger;
import service.ProsuctService;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class ProductServerImpl implements ProsuctService {

    private static ProsuctService productServiceImpl;
    private ProductDao productDao;
//    private static Logger logger = Logger.getLogger(ProductServerImpl.class);

    public ProductServerImpl() throws SQLException {
            productDao = new ProductDaoImpl();
    }

    public static ProsuctService getProductService() throws SQLException {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServerImpl();
        }
        return productServiceImpl;
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
