
public class Book {

    private String title;
    private String author;
    private String genre;
    private double price;

    // Default constructor
    public Book() {}

    // Parameterized constructor (throws exception)
    public Book(String title, String author, String genre, double price) 
            throws InvalidPriceException {

        this.title = title;
        this.author = author;
        this.genre = genre;

        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative!");
        }

        this.price = price;
    }

    // Getters
    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    // Display
    @Override
    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Genre: " + genre +
               ", Price: " + price;
    }
}