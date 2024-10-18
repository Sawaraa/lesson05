package servlet;

import domain.Product;
import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProsuctService;
import service.UserService;
import service.impl.ProductServerImpl;
import service.impl.UserServerImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AdminProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   private ProsuctService productService = ProductServerImpl.getProductService();

    public AdminProductServlet() throws SQLException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String author = request.getParameter("author");
            String pages = request.getParameter("pages");
            String price = request.getParameter("price");

        if (!title.isEmpty() && !description.isEmpty() && !author.isEmpty() && !pages.isEmpty() && !price.isEmpty()) {
            Product product = new Product(title, description, author, getValidatedPages(pages), getValidatedPrice(price));
            productService.create(product);
        }
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Success");
    }

    private int getValidatedPrice(String price) {
        if(price == null || price.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(price);
    }

    private int getValidatedPages(String pages) {
        if(pages == null || pages.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(pages);
    }
}
