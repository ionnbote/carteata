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
        pw.println("<div class=\"_container-fluid top-bar-banner\">");
        pw.println("<h2><center> " + "Comanda a fost acceptata" + "</center>");
        pw.println("</h2>");
        pw.println("</div>");
        pw.println("<hr>");
        pw.println("<h4> " + "Comanda dvs.:" + "</h4>");
        pw.println("<table class='table'>");
        pw.println("<thead>");
        pw.println("<tr>");
        pw.println("<th>Nr.</th>");
        pw.println("<th>Carte</th>");
        pw.println("<th>Total carti</th>");
        pw.println("<th>Subtotal</th>");
        pw.println("</tr>");
        pw.println("</thead>");
        pw.println("<tbody>");
        pw.println("<tr>");
        int total = 0;
        int i = 1;
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
            total = total + totalPrice;
            pw.println("<td> " + totalPrice + " " + "lei" + "</td>");
        }
        pw.println("</tbody>");
        pw.println("</table>");
        pw.println("<h4> " + "Total spre achitare" + " " + total + " " + "lei" + "</h4>");
        pw.println("<hr>");
        pw.println("<a class=\"btn btn-danger\" href='account?logout=true' role=\"button\">" +
                "Iesire</a>");
        pw.println("</body>");
        pw.println("</html");
    }

    private void placeOrder(Map<Book, Integer> map, User user) {
        try {
            String fileName = "D:/BookOrders/order_" + UUID.randomUUID() + ".txt";
            try (BufferedWriter p = new BufferedWriter(new FileWriter(fileName, true))) {
                int totalPrice = 0;
                for (Book b : map.keySet()) {
                    p.write("Id book: " + b.getId());
                    p.newLine();
                    p.write("Name book: " + b.getName());
                    p.newLine();
                    p.write("Author book: " + b.getAuthor().getFirstName() + " " + b.getAuthor().getLastName());
                    p.newLine();
                    p.write("Numar de carti: " + map.get(b));
                    p.newLine();
                    int Price = b.getPrice() * map.get(b);
                    totalPrice = totalPrice + Price;
                    p.write("Pret:" + Price);
                    p.newLine();
                    p.write("----------------------------");
                    p.newLine();
                }
                p.write("Total pret spre achitare:" + totalPrice);
                p.newLine();
                p.write("-------------USER-------------");
                p.newLine();
                p.write("Use First Name: " + user.getFirstName());
                p.newLine();
                p.write("Use Last Name: " + user.getLastName());
                p.newLine();
                p.write("User email: " + user.getEmail());
                p.flush();
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
