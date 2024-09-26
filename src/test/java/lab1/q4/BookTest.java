package lab1.q4;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void testIfEquals() {
        Book b1 = new Book("Effective Java", , 1234);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 1234);
        Book b3 = new Book("Effective Java", "Joshua Bloch", 12345);
        Book b4 = b1;

        assertTrue(b1.equals(b2));
        assertTrue(b4.equals(b1));
        assertFalse(b1.equals(b3));

    }
  
}