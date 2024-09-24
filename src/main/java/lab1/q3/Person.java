package lab1.q3;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private Gender gender;
    private Integer SIN;
    private static int COUNT;

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

    public enum Gender{ Male, Female, Others }

    // Constructors
    public Person() {
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

    @Override // Override toString method
    public String toString(){
        if(this.getGender() == null) {
            return "Person: " + this.getFirstname() + " " + this.getLastname() + ", " + this.getSIN();
        }
        else {
            return "Person: " + this.getFirstname() + " " + this.getLastname() + ", " + this.getGender() + ", " + this.getSIN();
        }

    }
}
