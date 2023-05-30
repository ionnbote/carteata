package servlets;

import model.User;
import services.UserProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangePasswordServlet extends HttpServlet {
    UserProvider userProvider = new UserProvider();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("password1");
        User user = userProvider.getUser(email, password);

        if (user == null) {
            // no user found error
            pw.println(getJSON("Email sau parola curenta gresita", true));
            return;
        }

        user.setPassword(newPassword);
        if (!userProvider.changePasswordUser(user)) {
            pw.println(getJSON("Email sau parola curenta gresita", true));
        } else {
            pw.println(getJSON("Parola a fost modificata cu succes", false));
        }
    }

    private String getJSON(String message, boolean isError) {
        String json = String.format("{\"message\":\"%s\", \"isError\":\"%s\"}", message, isError);
        return json;
    }
}
