package servlet;

import domain.Basket;
import domain.Product;
import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BasketService;
import service.ProductService;
import service.UserService;
import service.impl.BasketServerImpl;
import service.impl.ProductServerImpl;
import service.impl.UserServerImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class BasketServlet extends HttpServlet {
    private BasketService bucketService = BasketServerImpl.getBasketServiceImpl();
    private ProductService productService = ProductServerImpl.getProductService();
    private UserService userService = UserServerImpl.getUserService();

    public BasketServlet() throws SQLException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        Product product = productService.read(Integer.parseInt(productId));

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");
        User user = userService.read(userId);

        Basket basket = new Basket();
        basket.setIdBasket(UUID.randomUUID().toString());
        basket.setProduct(product);
        basket.setUser(user);
        bucketService.create(basket);

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bucketId = request.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
