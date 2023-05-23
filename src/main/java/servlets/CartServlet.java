package servlets;

import model.Book;
import model.User;
import services.DataProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends HttpServlet {
    DataProvider dataProvider = new DataProvider();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("http://localhost:8080/CarteaTa/ContulMeu.html");
        }

        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String strId = request.getParameter("id");
        String action = request.getParameter("action");

        Map<Book, Integer> map = (Map<Book, Integer>) session.getAttribute("bookMap");

        if (map == null) {
            map = new HashMap<>();
            session.setAttribute("bookMap", map);
        }

        System.out.println("sessionId = " + session.getId());
        if (strId != null) {
            if ("add".equals(action)) {
                System.out.println("Adding book to cart, id = " + strId);
                Book book = dataProvider.getBook(strId);
                Integer nrOfBooks = map.get(book);
                if (nrOfBooks == null) {
                    map.put(book, 1);
                } else {
                    nrOfBooks++;
                    map.put(book, nrOfBooks);
                }
            }
            if ("minus".equals(action)) {
                Book book = dataProvider.getBook(strId);
                Integer nrOfBooks = map.get(book);
                if (nrOfBooks > 1) {
                    nrOfBooks--;
                    map.put(book, nrOfBooks);
                }
            }
            if ("delete".equals(action)) {
                System.out.println("Deleting book from cart, id = " + strId);
                Book book = dataProvider.getBook(strId);
                map.remove(book);
            }
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
        pw.println("<th>Subtotal</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
        pw.println("<tr>");
        int i = 1;
        int total = 0;
        for (Book b : map.keySet()) {
            int bookId = b.getId();
            String img = "<a href=\"book?id=" + bookId +
                    "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                    + b.getImage() + "'/></a>";
            pw.println("<tr>");
            pw.println("<td>");
            pw.println(i++);
            pw.println("</td>");
            pw.println("<td><a href='book?id=" + b.getId() + "&show-add-to-cart=false'>" +
                    b.getName() + "</a></td>");
            pw.println("<td>" + map.get(b) + "</td>");
            int totalPrice = b.getPrice() * map.get(b);
            pw.println("<td> " + totalPrice + " " + "lei" + "</td>");
            total = total + totalPrice;
            pw.println("<td>");
            pw.println("<ul class='list-inline m-0'>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<form action='cart' method='get'>");
            pw.println("<button class='btn btn-primary btn-sm rounded-0' type='submit' data-toggle='tooltip' data-placement='top' title='Dubleaza cartea'>" +
                    "<i class='fa fa-table'>+</i></button>");
            pw.println("<input type=\"hidden\" value='" + b.getId() + "' name=\"id\">");
            pw.println("<input type=\"hidden\" value='add' name='action'>");
            pw.println("</form>");
            pw.println("</li>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<form action='cart' method='get'>");
            pw.println("<button class='btn btn-success btn-sm rounded-0' type='submit' data-toggle='tooltip' data-placement='top' title='Sterge o unitate'>" +
                    "<i class='fa fa-edit'>-</i></button>");
            pw.println("<input type=\"hidden\" value='" + b.getId() + "' name=\"id\">");
            pw.println("<input type=\"hidden\" value='minus' name='action'>");
            pw.println("</form>");
            pw.println("</li>");
            pw.println("<li class='list-inline-item'>");
            pw.println("<form onsubmit=\"return confirm('Doriti stergerea acestei carti din cos ?');\" action='cart' method='get'>");
            pw.println("<button class='btn btn-danger btn-sm rounded-0' type='submit' data-toggle='tooltip' data-placement='top' title='Delete'>" +
                    "<i class='fa fa-trash'>Sterge</i></button>");
            pw.println("<input type=\"hidden\" value='" + b.getId() + "' name=\"id\">");
            pw.println("<input type=\"hidden\" value='delete' name='action'>");
            pw.println("</form>");
            pw.println("</li>");
            pw.println("</ul>");
            pw.println("</td>");
        }
        pw.println("</tbody>");
        pw.println("</table>");
        pw.println("<h4> " + "Total spre achitare" + " " + total + " " + "lei" + "</h4>");

        pw.println("<p id='demo'></p>");
        pw.println("<script>");
        pw.println("const d = new Date()");
        pw.println("document.getElementById('demo').innerHTML = d");
        pw.println("</script>");

        pw.println("<ul class='pager'>");
        pw.println("<li><a href='details'>Plaseaza comanda</a></li>");
        pw.println("</ul>");
        pw.println("<hr>");

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
