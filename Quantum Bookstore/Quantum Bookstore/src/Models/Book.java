package Models;

abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishYear;
    protected double price;

    public Book(String isbn, String title, String author, int publishYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title;}
    public String getAuthor() { return author;}
    public int getPublishYear() { return publishYear; }
    public double getPrice() { return price; }

    public abstract void processPurchase(int quantity, String email, String address);

    public abstract boolean isAvailable(int quantity);

    public abstract void reduceStock(int quantity);

    public boolean isOutdated(int currentYear, int yearsThreshold) {
        return (currentYear - publishYear) > yearsThreshold;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Year: %d, Price: $%.2f",isbn, title, author, publishYear, price);
    }
}