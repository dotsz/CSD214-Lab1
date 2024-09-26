package lab1.q3;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private Gender gender;
    private Integer SIN;
    private static int COUNT; // Object counter
    public enum Gender{ Male, Female, Others } // Enums for the gender property of the Person class

    // Getters and Setters
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Integer getSIN() {
        return SIN;
    }
    public void setSIN(Integer SIN) {
        this.SIN = SIN;
    }
    public static int getCOUNT() {
        return COUNT;
    }
    public static void setCOUNT(int COUNT) {
        Person.COUNT = COUNT;
    }

    // Constructors
    public Person() { // Default empty parameter constructor
        this.firstname = "";
        this.lastname = "";
        this.SIN = 0;
        COUNT++;
    }

    public Person(String firstname, String lastname){
        this();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(String firstname, String lastname, Integer SIN){
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.SIN = SIN;
    }

    public Person(String firstname, String lastname, Gender gender, Integer SIN){
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.SIN = SIN;

    }

    // Overrides for the toString, equals and hashCode methods
    @Override
    public String toString(){
        if(this.getGender() == null) {
            return "Person: " + this.getFirstname() + " " + this.getLastname() + ", " + this.getSIN();
        }
        else {
            return "Person: " + this.getFirstname() + " " + this.getLastname() + ", " + this.getGender() + ", " + this.getSIN();
        }

    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false; // check if the object is null
        if(this == o) return true; // compare the memory address of the two objects
        if(!(o instanceof Person person)) return false; // check if the object is an instance of the Person class
        // compare property values of the two objects
        return this.getFirstname().equals(person.getFirstname()) && this.getLastname().equals(person.getLastname()) && this.getSIN().equals(person.getSIN());
    }

    @Override
    public int hashCode() {
        // generate a hash code for the properties of the object
        return Objects.hash(this.getFirstname(), this.getLastname(), this.getSIN());
    }


}
