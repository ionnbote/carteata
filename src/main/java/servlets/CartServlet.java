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
        pw.println("<hr>");
        pw.println("</div>");
        for (int i = 0; i < bookList.size(); i++) {
            int bookId = bookList.get(i).getId();
            String img = "<a href=\"book?id=" + bookId +
                    "\"><img height=\"300\" width=\"200\" class='img-rounded' src='images/Carti/"
                    + bookList.get(i).getImage() + "'/></a>";
            //pw.println(img);
            pw.println(i + 1 + ". <a href='book?id=" + bookList.get(i).getId() + "&show-add-to-cart=false'>"
                    + bookList.get(i).getName() + "</a><hr>");
        }
        pw.println("TOTAL: " + bookList.size() + " carti.");
        pw.println("</body></html>");

        pw.close();
    }
}
