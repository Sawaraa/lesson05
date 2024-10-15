package dao.Imlp;

import connection.ConnectionDataBase;
import dao.UserDao;
import domain.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    static String READ = "select * from user";
    static String READ_BY_ID = "select * from user where idUser =?";
    static String CREATE = "insert into user(firstName, lastName, email, password) value (?,?,?,?)";
    static String DELETE = "delete from user where idUser=?";
    static String UPDATE = "update user set firstName=?, lastName=?, email=?, password=?, where id=? ";
    private static String READ_BY_EMAIL = "select * from user where email=?";

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException {
        connection = ConnectionDataBase.getConnection();
    }

    @Override
    public User create(User user)  {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    @Override
    public User read(int id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String firstName = resultSet.getNString("firstName");
            String lastName = resultSet.getNString("lastName");
            String email = resultSet.getNString("email");
            String password = resultSet.getNString("password");
            user = new User(firstName, lastName, email, password);
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    @Override
    public User update(User user) {
        throw new IllegalStateException("there is no update for user");
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }


    }

    @Override
    public List<User> readAll()  {
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String firstName = resultSet.getNString("firstName");
                String lastName = resultSet.getNString("lastName");
                String email = resultSet.getNString("email");
                String password = resultSet.getNString("password");

                userList.add(new User(firstName, lastName, email, password));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String firstName = resultSet.getNString("firstName");
            String lastName = resultSet.getNString("lastName");
            String password = resultSet.getNString("password");
            user = new User(firstName, lastName, email, password);

        } catch (SQLException e) {
            logger.error(e);
        }
        return user;
    }
}
