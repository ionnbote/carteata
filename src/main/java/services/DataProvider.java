package services;

import model.Author;
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
                String productType = rs.getString("ProductType");
                int bookId = rs.getInt("BookId");
                Book book = new Book();
                book.setId(bookId);
                book.setName(bookName);
                book.setImage(imageBook);
                book.setProductType(productType);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

        return bookList;
    }

    public List<Book> getNewBooks(int editionYear) {
        System.out.println("Running ...");
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sql = "SELECT * FROM book where EditionYear > '" + editionYear + "'";
        List<Book> bookList = new LinkedList<>();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Printing results from DB...");
            while (rs.next()) {
                String bookName = rs.getString("name");
                String imageBook = rs.getString("image");
                int bookId = rs.getInt("BookId");
                Book book = new Book();
                book.setId(bookId);
                book.setName(bookName);
                book.setImage(imageBook);
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
        String sql = "SELECT b.*, a.LastName, a.FirstName FROM carteata.book as b " +
                "inner join carteata.author as a on a.AuthorId = b.AuthorId where BookId = '" + id + "'";
        Book book = new Book();
        Author author = new Author();
        try {
            Statement stmt = mysqlConnect.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String bookName = rs.getString("name");
                String imageBook = rs.getString("image");
                String productType = rs.getString("ProductType");
                int bookId = rs.getInt("BookId");
                String editionName = rs.getString("EditionName");
                int editionYear = rs.getInt("EditionYear");
                int page = rs.getInt("Page");
                String isbn = rs.getString("ISBN");
                int price = rs.getInt("Price");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                author.setLastName(lastName);
                author.setFirstName(firstName);
                book.setId(bookId);
                book.setName(bookName);
                book.setImage(imageBook);
                book.setAuthor(author);
                book.setProductType(productType);
                book.setEditionName(editionName);
                book.setEditionYear(editionYear);
                book.setISBN(isbn);
                book.setPage(page);
                book.setPrice(price);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

        return book;
    }
}
