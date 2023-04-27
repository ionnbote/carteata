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

    private static String getHeadMetadata() {
        return "<meta charset=\"utf-8\">\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                "    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>";
    }

    private static String getImageUrl(Book book) {
        return "<td class=\"w-25\">\"<a href=\"book?id=" +
                "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                + book.getImage() + "'/></a>";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strId = request.getParameter("id");
        Book book = dataProvider.getBook(strId);

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Carti</title>");
        pw.println("<link href=\"style.css\" rel=\"stylesheet\">");
        pw.println(getHeadMetadata());
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<div class=\"table-responsive\">");
        pw.println("<table class=\"table\">");
        pw.println("<thead>");
        pw.println("<tr>");
        pw.println("<th>Id</th>");
        pw.println("<th>Image</th>");
        pw.println("<th>Name</th>");
        pw.println("<th>Author</th>");
        pw.println("<th>Edition Name</th>");
        pw.println("<th>Edition Year</th>");
        pw.println("<th>ISBN</th>");
        pw.println("<th>Price</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
        pw.println("<tr>");
        pw.println("<td>" + book.getId() + "</td>");
        pw.println(getImageUrl(book));
        pw.println("</td>");
        pw.println("<td>" + book.getName() + "</td>");
        pw.println("</tr>");
        pw.println("</tbody>");
        pw.println("</table>");
        pw.println("</div>");
        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");


//        pw.println("<div class=\"container\">");
//        pw.println("<div class=\"row\">");
//        pw.println("<div class=\"col-12\">");
//        pw.println("<table class=\"table table-image\">");
//        pw.println("<thead>");
//        pw.println("<tr>");
//        pw.println("<th scope=\"col\">Id Book</th>");
//        pw.println("<th scope=\"col\">Image</th>");
//        pw.println("<th scope=\"col\">Name</th>");
//        pw.println("<th scope=\"col\">Author</th>");
//        pw.println("<th scope=\"col\">Edition Name</th>");
//        pw.println("<th scope=\"col\">Edition Year</th>");
//        pw.println("<th scope=\"col\">ISBN</th>");
//        pw.println("<th scope=\"col\">Price</th>");
//        pw.println("</tr>");
//        pw.println("</thead>");
//        pw.println("<tbody>");
//        pw.println("<tr>");
//        pw.println("<th scope=\"row\">1</th>");
//        pw.println("<td class=\"w-25\">\"<a href=\"book?id=" +
//                "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
//                + book.getImage() + "'/></a>");
//        pw.println("</td>");
//        pw.println("</tr>");
//        pw.println("<td class=\"w-25\">");
//        pw.println("</tbody>");
//        pw.println("</table>");
//        pw.println("</div>");
//        pw.println("</div>");
//        pw.println("</div>");
//        pw.println("</head>");
//        pw.println("</body></html>");
    }
}
