package servlet;

import domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;
import service.impl.ProductServerImpl;

import com.google.gson.Gson;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/products")
public class Products extends HttpServlet {
    private ProductService productService = ProductServerImpl.getProductService();

    public Products() throws SQLException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.readAll();
        String json = new Gson().toJson(products);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
