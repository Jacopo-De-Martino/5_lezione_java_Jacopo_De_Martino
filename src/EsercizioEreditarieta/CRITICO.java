package EsercizioEreditarieta;

public class CRITICO extends Utente {
    private int recensioniEffettuate; // To track how many reviews this critic has made

    public CRITICO(String nome, String email) {
        super(nome, email); // Call the constructor of the Utente superclass
        this.recensioniEffettuate = 0; // Initialize review count
    }

    // Method to allow a critic to add a review
    public Recensione aggiungiRecensione(String testo, int valutazione, Piatto piatto) {
        // Basic validation for rating
        if (valutazione < 1 || valutazione > 5) {
            System.out.println("Valutazione non valida. Deve essere tra 1 e 5.");
            return null;
        }
        Recensione nuovaRecensione = new Recensione(testo, valutazione, this, piatto);
        this.recensioniEffettuate++; // Increment the count of reviews made by this critic
        System.out.println(
                getNome() + " ha recensito il piatto '" + piatto.getNome() + "' con " + valutazione + " stelle.");
        return nuovaRecensione;
    }

    public int getRecensioniEffettuate() {
        return recensioniEffettuate;
    }

    // You might need a way to increment recensioniEffettuate externally if reviews
    // are added differently
    public void incrementaRecensioniEffettuate() {
        this.recensioniEffettuate++;
    }

    // --- FIX HERE: Add a method to set the total count for promotion transfer ---
    public void setRecensioniEffettuate(int count) {
        this.recensioniEffettuate = count;
    }
}