import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        // Creating objects
        try {
            books.add(new Book("Java Basics", "John", "Education", 500));
            books.add(new Book("Harry Potter", "J.K Rowling", "Fiction", 800));
            books.add(new Book("Data Science", "Alice", "Education", 700));

            // This will throw exception
            books.add(new Book("Invalid Book", "Error Author", "Fiction", -100));

        } catch (InvalidPriceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Display all books
        System.out.println("\n--- All Books ---");
        double total = 0;

        for (Book b : books) {
            System.out.println(b);
            total += b.getPrice();
        }

        // Average price
        if (books.size() > 0) {
            double avg = total / books.size();
            System.out.println("\nAverage Price: " + avg);
        }

        // Filter Fiction books using forEach
        System.out.println("\n--- Fiction Books ---");

        books.forEach(book -> {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book);
            }
        });
    }
}