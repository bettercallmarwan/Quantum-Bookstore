package Models;

import java.util.List;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        System.out.println("Quantum book store: Starting Quantum Bookstore Test");
        System.out.println("==================================================");

        QuantumBookstore bookstore = new QuantumBookstore();

        // Test 1: adding different types of books
        System.out.println("\nQuantum book store: TEST 1 - Adding Books");
        System.out.println("----------------------------------------");

        // add paper books
        PaperBook paperBook1 = new PaperBook("ISBN001", "Java Programming", "John Smith", 2020, 45.99, 10);
        PaperBook paperBook2 = new PaperBook("ISBN002", "Data Structures", "Jane Doe", 2015, 39.99, 5);

        // add ebooks
        EBook ebook1 = new EBook("ISBN003", "Python Guide", "Bob Johnson", 2021, 29.99, "PDF");
        EBook ebook2 = new EBook("ISBN004", "Web Development", "Alice Brown", 2022, 34.99, "EPUB");

        // add showcase books
        ShowcaseBook showcase1 = new ShowcaseBook("ISBN005", "Advanced AI", "Dr. Smith", 2023, 89.99);

        bookstore.addBook(paperBook1);
        bookstore.addBook(paperBook2);
        bookstore.addBook(ebook1);
        bookstore.addBook(ebook2);
        bookstore.addBook(showcase1);

        // show inventory
        bookstore.displayInventory();

        // Test 2: buying books
        System.out.println("\nQuantum book store: TEST 2 - Buying Books");
        System.out.println("----------------------------------------");

        try {
            // buuy paper book
            System.out.println("Quantum book store: Attempting to buy paper book...");
            double amount1 = bookstore.buyBook("ISBN001", 2, "customer@email.com", "123 Main St");

            // buy ebook
            System.out.println("\nQuantum book store: Attempting to buy ebook...");
            double amount2 = bookstore.buyBook("ISBN003", 1, "customer@email.com", "123 Main St");

            // try to buy showcase book (fail))
            System.out.println("\nQuantum book store: Attempting to buy showcase book...");
            bookstore.buyBook("ISBN005", 1, "customer@email.com", "123 Main St");

        } catch (BookstoreException e) {
            System.out.println("Quantum book store: Purchase error - " + e.getMessage());
        }

        // Test 3: error handling
        System.out.println("\nQuantum book store: TEST 3 - Error Handling");
        System.out.println("------------------------------------------");

        try {
            // try to buy non-existent book
            System.out.println("Quantum book store: Attempting to buy non-existent book...");
            bookstore.buyBook("INVALID", 1, "customer@email.com", "123 Main St");
        } catch (BookstoreException e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        try {
            // try to buy more than available stock
            System.out.println("Quantum book store: Attempting to buy more than available stock...");
            bookstore.buyBook("ISBN002", 10, "customer@email.com", "123 Main St");
        } catch (BookstoreException e) {
            System.out.println("Quantum book store: Expected error - " + e.getMessage());
        }

        // Test 4: remove outdated books
        System.out.println("\nQuantum book store: TEST 4 - Removing Outdated Books");
        System.out.println("--------------------------------------------------");

        List<Book> removedBooks = bookstore.removeOutdatedBooks(2024, 8);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");

        // final inventory display
        System.out.println("\nQuantum book store: Final Inventory");
        System.out.println("----------------------------------");
        bookstore.displayInventory();

        System.out.println("\nQuantum book store: TEST 5 - Existing Example");
        System.out.println("--------------------------------------------------");

        AudioBook audioBook = new AudioBook("ISBN006", "History of Science", "Dr. Wilson", 2022, 24.99, "MP3", 360);
        bookstore.addBook(audioBook);

        try {
            System.out.println("Quantum book store: Attempting to buy audiobook...");
            bookstore.buyBook("ISBN006", 1, "customer@email.com", "123 Main St");
        } catch (BookstoreException e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        System.out.println("\nQuantum book store: Test completed successfully!");
    }
}