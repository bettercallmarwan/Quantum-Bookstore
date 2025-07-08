package Models;

class ShippingService {
    public static void ship(PaperBook book, int quantity, String address) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '" +
                book.getTitle() + "' to address: " + address);
    }
}