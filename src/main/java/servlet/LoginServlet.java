package servlet;

import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServerImpl;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = UserServerImpl.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("magazine.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
