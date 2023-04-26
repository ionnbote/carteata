package services;

import model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DataProvider {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String MAX_POOL = "250";

    public List<Book> getBooks(String bookType) {
        System.out.println("Running ...");
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sql = "SELECT * FROM book where ProductType = '" + bookType + "'";
        List<Book> bookList = new LinkedList<>();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Printing results from DB...");
            while (rs.next()) {
                //int x = rs.getInt("a");
                String bookName = rs.getString("name");
                String imageBook = rs.getString("image");
                int bookId = rs.getInt("BookId");
                Book book = new Book();
                book.setId(bookId);
                book.setName(bookName);
                book.setImage(imageBook);
                book.setAuthor("fsgsg");
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

        return bookList;
    }

    public Book getBook(String id) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sql = "SELECT * FROM book where BookId = '" + id + "'";
        Book book = new Book();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String bookName = rs.getString("name");
                String imageBook = rs.getString("image");
                int bookId = rs.getInt("BookId");
                book.setId(bookId);
                book.setName(bookName);
                book.setImage(imageBook);
                book.setAuthor("fsgsg");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

        return book;
    }
}
