package Models;

class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int publishYear, double price, String fileType) {
        super(isbn, title, author, publishYear, price);
        this.fileType = fileType;
    }

    public String getFileType() { return fileType; }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }

    @Override
    public void reduceStock(int quantity) {

    }

    //@Override
    //public void reduceStock(int quantity) {
    //}

    @Override
    public void processPurchase(int quantity, String email, String address) {
        System.out.println("Quantum book store: Processing ebook purchase");
        MailService.sendEmail(this, quantity, email);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File Type: %s", fileType);
    }
}