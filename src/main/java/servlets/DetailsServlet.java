package servlets;

import model.Book;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

public class DetailsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("http://localhost:8080/CarteaTa/ContulMeu.html");
            return;
        }

        Map<Book, Integer> map = (Map<Book, Integer>) session.getAttribute("bookMap");
        placeOrder(map, user);

        response.setContentType("text/html");//setting the content type
        PrintWriter pw = response.getWriter();//get the stream to write the data

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
        pw.println("Comanda a fost acceptata. Detalii:");
        pw.println("<hr>");
        for (Book b : map.keySet()) {
            int bookId = b.getId();
            pw.println("<br/><a href='book?id=" + b.getId() + "&show-add-to-cart=false'>" +
                    b.getName() + "</a>");
        }
        pw.println("<hr>");
        pw.println("Sinteti logat: " + user.getFirstName());
        pw.println("<hr>");
        pw.println("email: " + user.getEmail());
        pw.println("<a class=\"btn btn-danger\" href='account?logout=true' role=\"button\">" +
                "Log Out - Iesire</a>");
        pw.println("</body>");
        pw.println("</html");
    }

    private void placeOrder(Map<Book, Integer> map, User user) {
        try {
            String fileName = "D:/BookOrders/order_" + UUID.randomUUID() + ".txt";
            try (BufferedWriter p = new BufferedWriter(new FileWriter(fileName, true))) {
                for (Book b : map.keySet()) {
                    p.write(b.getId() + ", " + b.getName() + ", " + b.getISBN());
                    p.newLine();
                }
                p.write("-------------USER-------------");
                p.newLine();
                p.write("UseName: " + user.getFirstName());
                p.newLine();
                p.write("UserId: " + user.getId());
                p.flush();
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
