package servlets;

import model.User;
import services.UserProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveUserServlet extends HttpServlet {

    UserProvider userProvider = new UserProvider();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userProvider.getUser(email, password);
    }
}
