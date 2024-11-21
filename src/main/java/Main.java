import domain.Basket;
import domain.Product;
import domain.User;
import dto.BusketDto;
import service.BasketService;
import service.ProductService;
import service.UserService;
import service.impl.BasketServerImpl;
import service.impl.ProductServerImpl;
import service.impl.UserServerImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws SQLException {
        User user = new User("lol", "lol", "lol@gmail.com", "11");
        System.out.println(user.getRole());
    }

}
