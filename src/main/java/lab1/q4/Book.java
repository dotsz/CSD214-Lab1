package lab1.q4;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer asin;
    private String publisherName;
    private Language language;
    private Integer pageCount;
    private String isbn10;
    private String isbn13;
    private Integer itemWeight;
    private String productDimensions;
    private String Author;
    private String bookTitle;

    private static int count;

    public enum Language {
        English, French, Spanish, German, Italian, Dutch, Chinese, Japanese, Korean, Arabic, Hebrew, Russian, Other
    }

    // Constructors
    public Book(){ // Default empty parameter constructor
        this.asin = 0;
        this.publisherName = "";
        this.language = Language.English;
        this.pageCount = 0;
        this.isbn10 = "";
        this.isbn13 = "";
        this.itemWeight = 0;
        this.productDimensions = "";
        this.Author = "";
        this.bookTitle = "";
        count++;
    }
    public Book(String bookTitle, String Author){ // Constructor that accepts Strings as Book Title and Author
        this();
        this.bookTitle = bookTitle;
        this.Author = Author;
    }
    public Book(String bookTitle, String Author, String isbn13){
        this();
        this.bookTitle = bookTitle;
        this.Author = Author;
        this.isbn13 = isbn13;
    }
    public Book(String bookTitle, String Author, String isbn13, Integer pageCount){
        this();
        this.bookTitle = bookTitle;
        this.Author = Author;
        this.isbn13 = isbn13;
        this.pageCount = pageCount;
    }

    // Constructors with Person object as parameters
    public Book (String bookTitle, Person person, String isbn13){
        this();
        this.bookTitle = bookTitle;
        this.Author = person.getFirstname() + " " + person.getLastname();
        this.isbn13 = isbn13;
    }

    // Getters and Setters
    public Integer getAsin() {
        return asin;
    }
    public void setAsin(Integer asin) {
        this.asin = asin;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public String getIsbn10() {
        return isbn10;
    }
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
    public String getIsbn13() {
        return isbn13;
    }
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
    public Integer getItemWeight() {
        return itemWeight;
    }
    public void setItemWeight(Integer itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getProductDimensions() {
        return productDimensions;
    }

    public void setProductDimensions(String productDimensions) {
        this.productDimensions = productDimensions;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String Author) {
        this.Author = Author;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Book.count = count;
    }







    @Override
    public String toString() {
        return "Book{" +
                "asin=" + asin +
                ", publisherName='" + publisherName + '\'' +
                ", language=" + language +
                ", pageCount=" + pageCount +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", itemWeight=" + itemWeight +
                ", productDimensions='" + productDimensions + '\'' +
                ", Author='" + Author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o == this){ // Check if the object is the same as this
            return true;
        }
        if(!(o instanceof Book)){ // Check if the object is an instance of Book
            return false;
        }
        Book book = (Book) o;
        return book.getBookTitle().equals(this.getBookTitle()) // Compare the book title, author, isbn10 and isbn13
                && book.getAuthor().equals(this.getAuthor())
                && book.getIsbn10().equals(this.getIsbn10())
                && book.getIsbn13().equals(this.getIsbn13());
    }

    @Override
    public int hashCode(){ // Generate a hash code based on the book title, author, isbn10 and isbn13
        return this.getBookTitle().hashCode()
                + this.getAuthor().hashCode()
                + this.getIsbn10().hashCode()
                + this.getIsbn13().hashCode();
    }

    @Override
    public void finalize() {
        count--;
    }
}
