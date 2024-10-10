import domain.User;
import service.UserService;
import service.impl.UserServerImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServerImpl();
        userService.create(new User("Elene", "Alison", "elena@gmail.com", "yes"));
        System.out.println(userService.read(5));
        System.out.println(userService.readAll());
        userService.create(new User("NNNNNNNN", "Alison", "elena@gmail.com", "yes"));
        userService.delete(8);

    }
}
