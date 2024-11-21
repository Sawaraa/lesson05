package servlet;

import domain.Basket;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BasketService;
import service.impl.BasketServerImpl;

import java.io.IOException;
import java.sql.SQLException;

public class BasketServlet extends HttpServlet {
    private BasketService bucketService = BasketServerImpl.getBasketServiceImpl();

    public BasketServlet() throws SQLException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        Basket basket = new Basket(userId, Integer.parseInt(productId));
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
