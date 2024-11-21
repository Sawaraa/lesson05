package service.impl;

import dao.Imlp.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServerImpl implements ProductService {

    private static ProductService productServiceImpl;
    private ProductDao productDao;
//    private static Logger logger = Logger.getLogger(ProductServerImpl.class);

    public ProductServerImpl() throws SQLException {
            productDao = new ProductDaoImpl();
    }

    public static ProductService getProductService() throws SQLException {
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

    @Override
    public Map<Integer, Product> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
