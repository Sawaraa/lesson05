package dao.Imlp;

import connection.ConnectionDataBase;
import dao.ProductDao;
import domain.Product;
import domain.User;

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

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl() throws SQLException {
        connection = ConnectionDataBase.getConnection();
    }

    @Override
    public Product create(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setString(2,product.getDescription());
        preparedStatement.setString(3,product.getAuthor());
        preparedStatement.setInt(4,product.getPages());
        preparedStatement.setInt(4,product.getPrice());
        preparedStatement.executeUpdate();
        return product;
    }

    @Override
    public Product read(int id) throws SQLException {
        Product product = null;
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        String title = resultSet.getNString("title");
        String description = resultSet.getNString("description");
        String author = resultSet.getNString("author");
        int pages = resultSet.getInt("pages");
        int price = resultSet.getInt("price");
        product = new Product(title,description,author,pages,price);

        return product;
    }

    @Override
    public Product update(Product product) {
        throw new IllegalStateException("there is no update for product");
    }

    @Override
    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Product> readAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String title = resultSet.getNString("title");
            String description = resultSet.getNString("description");
            String author = resultSet.getNString("author");
            int pages = resultSet.getInt("pages");
            int price = resultSet.getInt("price");

            productList.add(new Product(title,description,author,pages,price));
        }
        return productList;
    }
}
