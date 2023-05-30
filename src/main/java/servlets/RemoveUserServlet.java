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

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User us = new User();
        us.setEmail(email);
        us.setPassword(password);
        if (userProvider.removeUser(us)) {
            pw.println("Utilizatorul a fost sters cu succes");
        } else {
            pw.println("Utilizatorul nu a fost gasit");
        }

    }
}
