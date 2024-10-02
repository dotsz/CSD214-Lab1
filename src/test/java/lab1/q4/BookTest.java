package lab1.q4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testIfBookObjectsAreEquals() {

        // Create a mock person object
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);
        // Create 4 book objects
        Book b1 = new Book("Effective Java", p1, "0134685991");
        Book b2 = new Book("Effective Java", p1, "0134685991");
        Book b3 = new Book("Effective Java", p1, "0134685991");
        Book b4 = b1;

        // Test if the book objects are equal
        assertEquals(b1, b2);
        assertEquals(b4, b1);
        assertEquals(b1, b3);
    }
  
}