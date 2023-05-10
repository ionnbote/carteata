package servlets;

import model.Book;
import services.DataProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class NewBooksServlet extends HttpServlet {
    DataProvider dataProvider = new DataProvider();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String editionYearStr = request.getParameter("editionYear");
        int editionYear = editionYearStr == null ? 0 : Integer.parseInt(editionYearStr);

        List<Book> newBooks = dataProvider.getNewBooks(editionYear);
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
        pw.println("<h2><center> " + "C&#227r&#355i noi" + "</center>");
        pw.println("</h2>");
        pw.println("<hr>");
        pw.println("</div>");
        for (int i = 0; i < newBooks.size(); i++) {
            int bookId = newBooks.get(i).getId();
            String img = "<a href=\"book?id=" + bookId +
                    "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                    + newBooks.get(i).getImage() + "'/></a>";
            pw.println(img);
        }
        pw.println("<hr/>TOTAL: " + newBooks.size() + " carti.");
        pw.println("<ul class='pager'>");
        pw.println("<li><a href='index.html'>Pagina principala</a></li>");
        pw.println("<li><a href='Carti.html'>Carti</a></li>");
        pw.println("<li><a href='topbooks?editionYear=2021'>Top carti</a></li>");
        pw.println("</ul>");
        pw.println("</div");
        pw.println("</body></html>");

        pw.close();

    }
}