package Models;

class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int publishYear, double price) {
        super(isbn, title, author, publishYear, price);
    }

    @Override
    public boolean isAvailable(int quantity) {
        return false;
    }

    @Override
    public void reduceStock(int quantity) {
        throw new UnsupportedOperationException("showcase books cannot be purchased");
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new UnsupportedOperationException("showcase books are not for sale");
    }

    @Override
    public String toString() {
        return super.toString() + " [SHOWCASE - NOT FOR SALE]";
    }
}