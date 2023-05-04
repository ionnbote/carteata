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
        String showCart = request.getParameter("show-add-to-cart");
        Book book = dataProvider.getBook(strId);
        String img = "<a href=\"Carti.html" +
                "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                + book.getImage() + "'/></a>";
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
        pw.println("<div class=\"_container-fluid top-bar-banner\">");
        pw.println("<h2><center> " + book.getName() + "</center>");
        pw.println("</h2>");
        pw.println("<hr>");
        pw.println("</div>");

        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<td rowspan = \"7\"> " + img + "</td>");
        pw.println("<td><h4>" + "Autor" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + "</h4></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td><h4>" + "Editura" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getEditionName() + "</h4></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td><h4>" + "Anul" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getEditionYear() + "</h4></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td><h4>" + "Pagini" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getPage() + "</h4></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td><h4>" + "ISDN" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getPage() + "</h4></td>");
        pw.println("</tr>");
        pw.println("<td><h4>" + "Pret" + "</h4></td>");
        pw.println("<td>" + "--------------------" + " </td>");
        pw.println("<td><h4>" + book.getPrice() + " lei " + "</h4></td>");
        pw.println("</table>");

        if (!"false".equals(showCart)) {
            pw.println("<a class=\"btn btn-primary\" href='cart?id=" + book.getId() +
                    "' role=\"button\">Adauga aceasta carte in cos</a>");
        }
    }
}
