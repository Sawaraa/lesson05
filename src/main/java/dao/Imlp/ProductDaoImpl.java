package dao.Imlp;

import connection.ConnectionDataBase;
import dao.ProductDao;
import domain.Product;
import domain.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    static String READ = "select * from product";
    static String READ_BY_ID = "select * from product where idProduct =?";
    static String CREATE = "insert into product(title, description, author, pages, price) value (?,?,?,?,?)";
    static String DELETE = "delete from product where idProduct=?";
    static String UPDATE = "update product set title=?, description=?, author=?, pages=?, price=?, where id=? ";
    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl() throws SQLException {
        connection = ConnectionDataBase.getInstance().getConnection();
    }

    @Override
    public Product create(Product product)  {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setString(3,product.getAuthor());
            preparedStatement.setInt(4,product.getPages());
            preparedStatement.setInt(5,product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
        return product;
    }

    @Override
    public Product read(int id) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int productId = resultSet.getInt("idProduct");
            String title = resultSet.getNString("title");
            String description = resultSet.getNString("description");
            String author = resultSet.getNString("author");
            int pages = resultSet.getInt("pages");
            int price = resultSet.getInt("price");
            product = new Product(productId,title,description,author,pages,price);

        } catch (SQLException e) {
            logger.error(e);
        }

        return product;
    }

    @Override
    public Product update(Product product) {
        throw new IllegalStateException("there is no update for product");
    }

    @Override
    public void delete(int id)  {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }

    }

    @Override
    public List<Product> readAll() {
        List<Product> productList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("idProduct");
                String title = resultSet.getNString("title");
                String description = resultSet.getNString("description");
                String author = resultSet.getNString("author");
                int pages = resultSet.getInt("pages");
                int price = resultSet.getInt("price");

                productList.add(new Product(productId,title,description,author,pages,price));
            }
        } catch (SQLException e) {
            logger.error(e);
        }

        return productList;
    }
}
