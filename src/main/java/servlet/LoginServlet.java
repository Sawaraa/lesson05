package servlet;

import com.google.gson.Gson;
import domain.User;
import dto.UserLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.impl.UserServerImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService = UserServerImpl.getUserService();

    public LoginServlet() throws SQLException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);
        if(user != null) {
            String json = new Gson().toJson("Success");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.getUserByEmail(email);

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", user.getIdUser());
        if(user != null && user.getPassword().equals(password)){
            if(userService.getRoleByEmail(email).equals("admin")){
                request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
                return;
            }
            else{
                request.setAttribute("userEmail", email);
                request.getRequestDispatcher("magazine.jsp").forward(request, response);
                System.out.println(user.getFirstName());
                System.out.println(user.getEmail());
                System.out.println(user.getIdUser());
                System.out.println(user.getRole());
                return;
            }
        }
        else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

}
