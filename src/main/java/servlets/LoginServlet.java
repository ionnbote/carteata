package servlets;

import model.User;
import services.UserProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserProvider userProvider = new UserProvider();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userProvider.getUser(email, password);

        HttpSession session = request.getSession();

        if (user == null) {
            System.out.println("User nu a fost gasit");
        } else {
            session.setAttribute("user", user);
            System.out.println("User a fost gasit");
            response.sendRedirect("http://localhost:8080/CarteaTa/");
        }
    }
}
