package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void createBookTest() {
        System.out.println(" = = = Running first test. = = =");
        Book book = new Book();
        book.setName("Poiezii");
        assertNotNull(book);
        assertTrue("Poiezii".equals(book.getName()));
    }
}
