package servlet;

import domain.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProsuctService;
import service.impl.ProductServerImpl;

import java.io.IOException;
import java.sql.SQLException;

public class ProductServlet {
    private static final long serialVersionUID = 1L;
    ProsuctService prosuctService = ProductServerImpl.getProductService();

    public ProductServlet() throws SQLException {
    }

    // to get resource (product)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
    }

    // to create resource (product)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        String pages = request.getParameter("pages");
        String price = request.getParameter("price");

        Product product  = new Product(title, description, author, getValidatedPages(pages),  getValidatedPrice(price));
        prosuctService.create(product);
        response.setContentType("text");
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
