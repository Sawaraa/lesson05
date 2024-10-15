import domain.User;
import service.UserService;
import service.impl.UserServerImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServerImpl();
        userService.create(new User("Emma", "Emma", "Emmam@gmail.com", "Emma"));
        System.out.println(userService.read(5));
    }
}
