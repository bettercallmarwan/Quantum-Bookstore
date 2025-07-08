package Models;

class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int publishYear, double price, int stock) {
        super(isbn, title, author, publishYear, price);
        this.stock = stock;
    }

    public int getStock() { return stock; }

    @Override
    public boolean isAvailable(int quantity) {
        return stock >= quantity;
    }

    @Override
    public void reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            stock -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient stock available");
        }
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        System.out.println("Quantum book store: Processing paper book purchase");
        reduceStock(quantity);
        ShippingService.ship(this, quantity, address);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",Stock:%d", stock);
    }
}