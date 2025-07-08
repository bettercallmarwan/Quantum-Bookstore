package Models;

class AudioService {
    public static void sendAudio(AudioBook book, int quantity, String email) {
        System.out.println("Quantum book store: Sending " + quantity + " copy(ies) of audiobook '" +
                book.getTitle() + "' (" + book.getAudioFormat() + ") to email: " + email);
    }
}