package servlets;

import model.Book;
import services.DataProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CartServlet extends HttpServlet {
    DataProvider dataProvider = new DataProvider();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String strId = request.getParameter("id");

        HttpSession session = request.getSession();
        List<Book> bookList = (List<Book>) session.getAttribute("bookList");
        if (bookList == null) {
            bookList = new ArrayList<>();
            session.setAttribute("bookList", bookList);
        }

        System.out.println("sessionId = " + session.getId());
        if (strId != null) {
            System.out.println("Adding book to cart, id = " + strId);
            Book book = dataProvider.getBook(strId);
            bookList.add(book);
        }

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
        pw.println("<h2><center> " + "Cosul Meu" + "</center>");
        pw.println("</h2>");
        pw.println("</div>");
        pw.println("<table class='table'>");
        pw.println("<thead>");
        pw.println("<tr>");
        pw.println("<th>Nr.</th>");
        pw.println("<th>Carte</th>");
        pw.println("<th>Numarul de carti de acelasi fel</th>");
        pw.println("<th>Subtotal</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
        pw.println("<tr>");
        for (int i = 0; i < bookList.size(); i++) {
            int bookId = bookList.get(i).getId();
            String img = "<a href=\"book?id=" + bookId +
                    "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                    + bookList.get(i).getImage() + "'/></a>";
            pw.println("<tr>");
            pw.println("<td>");
            pw.println(i + 1);
            pw.println("</td>");
            pw.println("<td><a href='book?id=" + bookList.get(i).getId() + "&show-add-to-cart=false'>" +
                    bookList.get(i).getName() + "</a></td>");
            pw.println("<td>1</td>");
            pw.println("<td> " + bookList.get(i).getPrice() + " " + "lei" + "</td>");
            pw.println("<td>");
            pw.println("<ul class='list-inline m-0'>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<button class='btn btn-primary btn-sm rounded-0'type='button' data-toggle='tooltip' data-placement='top' title='Add'><i class='fa fa-table'>Adauga</i></button>");
            pw.println("</li>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<button class='btn btn-success btn-sm rounded-0' type='button' data-toggle='tooltip' data-placement='top' title='Edit'><i class='fa fa-edit'>Editeaza</i></button>");
            pw.println("</li>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<button class='btn btn-danger btn-sm rounded-0' type='button' data-toggle='tooltip' data-placement='top' title='Delete'><i class='fa fa-trash'>Sterge</i></button>");
            pw.println("</li>");
            pw.println("</ul>");
            pw.println("</td>");
        }
        pw.println("</tbody>");
        pw.println("</table>");
        pw.println("<ul class='pager'>");
        pw.println("<li><a href='index.html'>Pagina principala </a></li>");
        pw.println("<li><a href='Carti.html'>Carti</a></li>");
        pw.println("</ul>");
        pw.println("</section>");
        pw.println("</div");
        pw.println("</body></html>");

        pw.close();
    }
}
