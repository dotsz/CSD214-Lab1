package lab1.q6;

import lab1.q4.Book;
import lab1.q4.Person;

import java.io.Serializable;
import java.util.Scanner;

/**
 Author : Victor Felipe Jr
 Date : October 8, 2024
 Description : A Bookstore App
 **/
public class App implements Serializable {
    private final int numBooks = 100;
    private Book[] unsoldBooks = new Book[numBooks];
    private Book[] soldBooks = new Book[numBooks];
    private int unsoldCurrentIndex = 0;
    private int soldCurrentIndex = 0;
    private Scanner input = new Scanner(System.in);
    private String menu = """
            \n-------------------------
            1. Add a book
            2. Edit a book
            3. Delete an unsold Book
            4. Delete a sold Book
            5. List unsold Books
            6. List sold Books
            7. Sell a book
            99. Exit
            """;

    void run() {
        System.out.println("\nWelcome to the Bookstore App");
        boolean running = true;

        while(running){
            System.out.println(menu);
            System.out.println("Select from the options: ");
            String option = input.nextLine();

            switch(option){
                case "1" -> addBook();
                case "2" -> editBook();
                case "3" -> deleteUnsoldBook();
                case "4" -> deleteSoldBook();
                case "5" -> listUnsoldBooks();
                case "6" -> listSoldBooks();
                case "7" -> sellBook();
                case "99"-> running = false;
                default -> System.out.println("Invalid input");
            }

        }
    }

    public void addBook(){
        if(unsoldCurrentIndex >= numBooks){
            System.out.println("The bookstore is full");
            return;
        }
        try {
            System.out.println("\nEnter the book title:");
            String bookTitle = input.nextLine();
            System.out.println("Enter the author:");
            String author = input.nextLine();
            System.out.println("Enter book ISBN: ");
            String isbn = input.nextLine();

            unsoldBooks[unsoldCurrentIndex] = new Book(bookTitle, author, isbn);
            unsoldCurrentIndex++;
            System.out.println("Book Title: " + bookTitle + ", Author: " + author + ", ISBN: " + isbn);
            System.out.println("Book added successfully");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public void editBook(){
        if (unsoldCurrentIndex == 0){
            System.out.println("There are no books to edit");
            return;
        }

        listUnsoldBooks();
        System.out.println("Select the book to edit: ");
        int bookIndex = Integer.parseInt(input.nextLine());

        if(bookIndex < 1 || bookIndex > unsoldCurrentIndex){
            System.out.println("Invalid book index");
            return;
        }

        System.out.println("Enter the new book title: ");
        String bookTitle = input.nextLine();
        System.out.println("Enter the new author: ");
        String author = input.nextLine();
        System.out.println("Enter the new ISBN: ");
        String isbn = input.nextLine();

        unsoldBooks[bookIndex-1].setBookTitle(bookTitle);
        unsoldBooks[bookIndex-1].setAuthor(author);
        unsoldBooks[bookIndex-1].setIsbn10(isbn);
        System.out.println("Book updated successfully");

    }

    public void deleteUnsoldBook(){

        if (unsoldCurrentIndex == 0){
            System.out.println("There are no books to delete");
            return;
        }
        // print the list of books
        listUnsoldBooks();
        System.out.println("Select the book to delete: ");
        int bookIndex = Integer.parseInt(input.nextLine());

        if(bookIndex < 1 || bookIndex > unsoldCurrentIndex){
            System.out.println("Invalid book index");
            return;
        }

        for(int i = bookIndex-1; i < unsoldCurrentIndex-1; i++){
            unsoldBooks[i] = unsoldBooks[i+1];
        }
        unsoldCurrentIndex--;
        System.out.println("Book deleted successfully");

    }

    public void deleteSoldBook(){

        if (soldCurrentIndex == 0){
            System.out.println("There are no sold books to delete");
            return;
        }
        // print the list of books
        listSoldBooks();
        System.out.println("Select the book to delete: ");
        int bookIndex = Integer.parseInt(input.nextLine());

        if(bookIndex < 1 || bookIndex > soldCurrentIndex){
            System.out.println("Invalid book index");
            return;
        }

        for(int i = bookIndex-1; i < soldCurrentIndex-1; i++){
            soldBooks[i] = soldBooks[i+1];
        }
        soldCurrentIndex--;
        System.out.println("Book deleted successfully");

    }

    public void listUnsoldBooks(){
        System.out.println("Current list of unsold books: ");
        for(int i = 0; i < unsoldCurrentIndex; i++){
            System.out.println( (i+1) + ". Book Title: " + unsoldBooks[i].getBookTitle() + ", Author: " + unsoldBooks[i].getAuthor() + ", ISBN10: " + unsoldBooks[i].getIsbn10() +", ISBN13: " + unsoldBooks[i].getIsbn13());
        }
    }

    public void listSoldBooks(){

        if(soldCurrentIndex == 0){
            System.out.println("There are no sold books");
            return;
        }
        System.out.println("Current list of sold books: ");
        for(int i = 0; i < soldCurrentIndex; i++){
            System.out.println( (i+1) + ". Book Title: " + soldBooks[i].getBookTitle() + ", Author: " + soldBooks[i].getAuthor() + ", ISBN10: " + soldBooks[i].getIsbn10() +", ISBN13: " + soldBooks[i].getIsbn13());
        }

    }

    public void sellBook(){ // sell to a person

        if (unsoldCurrentIndex == 0){
            System.out.println("There are no books to sell");
            return;
        }
        // print the list of books
        listUnsoldBooks();
        System.out.println("Select the book to sell: ");
        int bookIndex = Integer.parseInt(input.nextLine());

        if(bookIndex < 1 || bookIndex > unsoldCurrentIndex){
            System.out.println("Invalid book index");
            return;
        }

        System.out.println("Enter the buyer's first firstName: ");
        String firstName = input.nextLine();
        System.out.println("Enter the buyer's last name: ");
        String lastName = input.nextLine();
        System.out.println("Enter the buyer's SIN: ");
        int sin = Integer.parseInt(input.nextLine());


        Person buyer = new Person(firstName, lastName, sin);
        unsoldBooks[bookIndex-1].setOwner(buyer);
        soldBooks[soldCurrentIndex] = unsoldBooks[bookIndex-1];
        soldCurrentIndex++;
        for(int i = bookIndex-1; i < unsoldCurrentIndex-1; i++){
            unsoldBooks[i] = unsoldBooks[i+1];
        }
        unsoldCurrentIndex--;
        System.out.println("Book sold successfully");

    }
}
