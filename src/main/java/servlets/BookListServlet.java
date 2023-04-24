package servlets;

import model.Book;
import services.DataProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookListServlet extends HttpServlet {
    DataProvider dataProvider = new DataProvider();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String nrOfBooks = request.getParameter("nrOfBooks");
        int nr = Integer.parseInt(nrOfBooks);

        List<Book> bookList = dataProvider.getBooks();

        //writing html in the stream
        pw.println("<html><body>");
        pw.println("Welcome to servlet");
        for (int i = 0; i < nr; i++) {
            pw.println("<br/>MyBook nr. " + i);
            pw.println("<br/>Name " + bookList.get(i).getName());
            pw.println("<hr/>");
        }
        pw.println("</body></html>");

        pw.close();//closing the stream

    }
}
