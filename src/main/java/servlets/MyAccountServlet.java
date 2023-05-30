package servlets;

import model.User;
import services.UserProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAccountServlet extends HttpServlet {
    UserProvider userProvider = new UserProvider();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);

        userProvider.addUser(user);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("http://localhost:8080/CarteaTa/ContulMeu.html");
            return;
        }

        String logout = request.getParameter("logout");
        if ("true".equals(logout)) {
            session.invalidate();
            response.sendRedirect("http://localhost:8080/CarteaTa/ContulMeu.html");
            return;
        }

        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Carti</title>");
        pw.println("<link href=\"style.css\" rel=\"stylesheet\">");
        pw.println("<meta charset=\"utf-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("Sinteti logat: " + user.getFirstName() + " " + user.getLastName());
        pw.println("<hr>");
        pw.println("email: " + user.getEmail());
        pw.println("<hr>");
        pw.println("<a class=\"btn btn-danger\" href='index.html' role=\"button\">" +
                "Pagina principala</a>");
        pw.println("<a class=\"btn btn-danger\" href='SchimbaParola.html' role=\"button\">" +
                "Schimba parola</a>");
        pw.println("<a class=\"btn btn-danger\" href='account?logout=true' role=\"button\">" +
                "Log Out - Iesire</a>");
        pw.println("<a class=\"btn btn-danger\" href='StergeCont.html' role=\"button\">" +
                "Sterge acount</a>");
        pw.println("</body>");
        pw.println("</html");
    }
}
