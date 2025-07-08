package Models;

import java.util.*;

class QuantumBookstore {
    private Map<String, Book> inventory;

    public QuantumBookstore() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int currentYear, int yearsThreshold) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(currentYear, yearsThreshold)) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle());
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws BookstoreException {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new BookstoreException("Book with ISBN " + isbn + " not found");
        }

        if (!book.isAvailable(quantity)) {
            throw new BookstoreException("Book not available in requested quantity");
        }

        try {
            book.processPurchase(quantity, email, address);
            double totalAmount = book.getPrice() * quantity;
            System.out.println("Quantum book store: Purchase successful. Total amount: $" +
                    String.format("%.2f", totalAmount));
            return totalAmount;
        } catch (Exception e) {
            throw new BookstoreException("Purchase failed: " + e.getMessage());
        }
    }

    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("=====================================");

        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: No books in inventory");
            return;
        }

        for (Book book : inventory.values()) {
            System.out.println("Quantum book store: " + book);
        }
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public int getInventorySize() {
        return inventory.size();
    }
}
