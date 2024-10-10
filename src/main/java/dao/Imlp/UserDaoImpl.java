package dao.Imlp;

import connection.ConnectionDataBase;
import dao.UserDao;
import domain.User;

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

    private final Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException {
        connection = ConnectionDataBase.getConnection();
    }

    @Override
    public User create(User user) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.executeUpdate();

        return user;
    }

    @Override
    public User read(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        String firstName = resultSet.getNString("firstName");
        String lastName = resultSet.getNString("lastName");
        String email = resultSet.getNString("email");
        String password = resultSet.getNString("password");

        return new User(firstName, lastName, email, password);
    }

    @Override
    public User update(User user) {
        throw new IllegalStateException("there is no update for user");
    }

    @Override
    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public List<User> readAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String firstName = resultSet.getNString("firstName");
            String lastName = resultSet.getNString("lastName");
            String email = resultSet.getNString("email");
            String password = resultSet.getNString("password");

            userList.add(new User(firstName, lastName, email, password));
        }
        return userList;
    }
}
