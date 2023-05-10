package servlets;

import services.DataProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BooksServlet {
    DataProvider dataProvider = new DataProvider();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

        String bookType = request.getParameter("type");
        //int nr = Integer.parseInt(nrOfBooks);

//        List<Book> bookList = dataProvider.getBooks(bookType);

        //writing html in the stream
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
        pw.println("<button class=\"btn btn-beletristica\" type=\"button\"><a href=\"books?type=Beletristica\">Beletristica</a><span>5</span>");
        pw.println("</button>");
        pw.println("<button class=\"btn btn-copii\" type=\"button\"><a href=\"books?type=Carti%20pentru%20copii\">Carti pentru copii</a><span>5</span>");
        pw.println("</button>");
        pw.println("<button class=\"btn btn-dictionare\" type=\"button\"><a href=\"books?type=Dictionare\">Dictionare</a><span>5</span>");
        pw.println("</button>");
        pw.println("<button class=\"btn btn-manuale\" type=\"button\"><a href=\"Manuale.html\">Manuale scolare</a><span>5</span></button>");
        pw.println("<button class=\"btn btn-english\" type=\"button\"><a href=\"EnglishBooks.html\">Books in English</a><span>5</span>");
        pw.println("</button>");
        pw.println("</div>");
        pw.println("</body></html>");

        pw.close();//closing the stream

    }
}
