package lab1.q3;

import lab1.q3.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    @Test
    void testIfEquals() {
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);
        Person p2 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);
        Person p3 = new Person("Joshua", "Bloch", Person.Gender.Male, 12345);
        Person p4 = p1;

        assertTrue(p1.equals(p2));
        assertTrue(p4.equals(p1));
        assertFalse(p1.equals(p3));
    }
}