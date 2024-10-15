package servlet;

import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.impl.UserServerImpl;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServerImpl.getUserService();

    @Override
    public void init() throws ServletException {
        userService = UserServerImpl.getUserService();
        if (userService == null) {
            System.out.println("UserService is not initialized");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            if (userService == null) {
                System.out.println("userService is null");
            } else {
                userService.create(new User(firstName, lastName, email, password));
            }
        }
        request.getRequestDispatcher("magazine.jsp").forward(request, response);
    }
}