package lab1.q4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testIfBookObjectsAreEquals() {

        Person p1 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);


        Book b1 = new Book("Effective Java", p1, "978-0134685991");
        Book b2 = new Book("Effective Java", p1, "978-0134685991");
        Book b3 = new Book("Effective Java", p1, "978-0134685991");
        Book b4 = b1;

        assertEquals(b1, b2);
        assertEquals(b4, b1);
        assertEquals(b1, b3);


    }
  
}