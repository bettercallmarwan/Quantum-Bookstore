package Models;

class MailService {
    public static void sendEmail(EBook book, int quantity, String email) {
        System.out.println("Quantum book store: Sending " + quantity + " copy(ies) of '" +
                book.getTitle() + "' (" + book.getFileType() + ") to email: " + email);
    }
}