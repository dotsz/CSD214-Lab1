package lab1.q3;

import java.io.Serializable;

public class App implements Serializable {

    void run (){
        Person p1 = new Person("Joe", "Student", Person.Gender.Male, 123456789);
        Person p2 = new Person("Joe", "Student", 1234);
        Person P3 = new Person("Joe", "Student");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(P3);
    }


}
