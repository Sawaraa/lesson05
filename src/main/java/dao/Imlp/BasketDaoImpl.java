package dao.Imlp;

import connection.ConnectionDataBase;
import dao.BasketDao;
import domain.Basket;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDaoImpl implements BasketDao {
    static String READ = "select * from basket";
    static String READ_BY_ID = "select * from basket where idBasket =?";
    static String CREATE = "insert into basket(idUser, idProduct) value (?,?)";
    static String DELETE = "delete from basket where idBasket=?";
    static String UPDATE = "update basket set idBasket=?, idUser=?, idProduct=?, where id=? ";

    private static Logger logger = Logger.getLogger(BasketDaoImpl.class);

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public BasketDaoImpl() throws SQLException {
        connection = ConnectionDataBase.getInstance().getConnection();
    }

    @Override
    public Basket create(Basket basket)  {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setInt(1,basket.getIdUser());
            preparedStatement.setInt(2,basket.getIdProduct());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        }

        return basket;

    }

    @Override
    public Basket read(int id)  {
        Basket basket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int idUser = resultSet.getInt("idUser");
            int idProduct = resultSet.getInt("idProduct");
            basket =new Basket(idUser,idProduct);
        } catch (SQLException e) {
            logger.error(e);
        }

        return basket;
    }

    @Override
    public Basket update(Basket basket) {
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
    public List<Basket> readAll()  {
        List<Basket> basketsList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                int idProduct = resultSet.getInt("idProduct");

                basketsList.add(new Basket(idUser,idProduct));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return basketsList;
    }
}
