package Models;

class AudioBook extends Book {
    private String audioFormat;
    private int durationMinutes;

    public AudioBook(String isbn, String title, String author, int publishYear, double price,
                     String audioFormat, int durationMinutes) {
        super(isbn, title, author, publishYear, price);
        this.audioFormat = audioFormat;
        this.durationMinutes = durationMinutes;
    }

    public String getAudioFormat() { return audioFormat; }
    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }

    @Override
    public void reduceStock(int quantity) {
    }

    @Override
    public void processPurchase(int quantity, String email, String address) {
        System.out.println("Quantum book store: Processing audiobook purchase");
        AudioService.sendAudio(this, quantity, email);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Format: %s, Duration: %d minutes",
                audioFormat, durationMinutes);
    }
}