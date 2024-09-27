package lab1.q3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    @Test
    void testIfPersonObjectsAreEquals() {
        Person p1 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);
        Person p2 = new Person("Joshua", "Bloch", Person.Gender.Male, 1234);
        Person p3 = new Person("Joshua", "Bloch", Person.Gender.Male, 12345);
        Person p4 = p1;

        assertEquals(p1, p2);
        assertEquals(p4, p1);
        assertNotEquals(p1, p3);
    }
}