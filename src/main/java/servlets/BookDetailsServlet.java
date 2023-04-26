package servlets;

import model.Book;
import services.DataProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BookDetailsServlet extends HttpServlet {
    DataProvider dataProvider = new DataProvider();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strId = request.getParameter("id");
        Book book = dataProvider.getBook(strId);

        PrintWriter pw = response.getWriter();
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
        pw.println("<div class=\"container\">");
        pw.println("<table class=\"table\">");
        pw.println("<thead>");
        pw.println("<tr>");
        pw.println("<th>Firstname</th>");
        pw.println("<th>Lastname</th>");
        pw.println("<th>Email</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
//        pw.println("<html>");
//        pw.println("<head>");
//        pw.println("</head>");
//
//        pw.println("<body>");
//        pw.println("Selected book " + strId);
//        pw.println("<br/>book name: " + book.getName());
//
//        pw.println("</body></html>");
    }
}
