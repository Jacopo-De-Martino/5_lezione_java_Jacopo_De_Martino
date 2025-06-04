package EsercizioEreditarieta;

public class Recensione {
    private String testo;
    private int valutazione; // da 1 a 5

    private Utente autore; // The user who wrote the review
    private Piatto piatto; // The dish being reviewed

    public Recensione(String testo, int valutazione, Utente autore, Piatto piatto) {
        this.testo = testo;
        setValutazione(valutazione);
        this.autore = autore;
        this.piatto = piatto;
    }

    // Getters for accessing review details
    public String getTesto() {
        return testo;
    }

    public void setValutazione(int valutazione) {
        if (valutazione < 1 || valutazione > 5) {
            throw new IllegalArgumentException("Valutazione deve essere tra 1 e 5.");
        } else {
            this.valutazione = valutazione;
        }
    }

    public int getValutazione() {
        return valutazione;
    }

    public Utente getAutore() {
        return autore;
    }

    public Piatto getPiatto() {
        return piatto;
    }

    // Optional: A method to print review details
    public void stampaRecensione() {
        System.out.println("Recensione di " + autore.getNome() + " per " + piatto.getNome() + ":");
        System.out.println("  Valutazione: " + valutazione + " stelle");
        System.out.println("  Testo: \"" + testo + "\"");
    }
}