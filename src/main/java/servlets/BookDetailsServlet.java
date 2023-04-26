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
        pw.println("</head>");

        pw.println("<body>");
        pw.println("Selected book " + strId);
        pw.println("<br/>book name: " + book.getName());

        pw.println("</body></html>");
    }
}
