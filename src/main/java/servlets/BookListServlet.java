package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BookListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String nrOfBooks = request.getParameter("nrOfBooks");
        int nr = Integer.parseInt(nrOfBooks);

        //writing html in the stream
        pw.println("<html><body>");
        pw.println("Welcome to servlet");
        for(int i = 0; i < nr; i++) {
            pw.println("<br/>MyBook nr. " + i);
            pw.println("<hr/>");
        }
        pw.println("</body></html>");

        pw.close();//closing the stream
        savetoDB();    }

    private void savetoDB() {
    }
}
