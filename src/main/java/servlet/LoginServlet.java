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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getIdUser());
            session.setAttribute("role", user.getRole());
            System.out.println(user.getRole());

//            UserLogin userLogin = new UserLogin();
//            userLogin.destinationUrl = "magazine.jsp";
//            userLogin.userEmail = user.getEmail();
//            String json = new Gson().toJson(userLogin);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(json);

            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("magazine.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

}
