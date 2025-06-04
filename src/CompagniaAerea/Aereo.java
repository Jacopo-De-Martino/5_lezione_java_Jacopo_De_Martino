package CompagniaAerea;

public class Aereo {
    // * Attributi principali dell'aereo
    private String modello;
    private int numeroPosti;
    private String codiceIdentificativo;
    // * Variabile statica per contare gli aerei creati (usata anche per assegnare
    // l'ID)
    private static int counter;
    // * ID univoco per ogni aereo (generato automaticamente)
    private int id;

    // ! Costruttore con parametri
    public Aereo(String modello, int numeroPosti, String codiceIdentificativo) {
        this.modello = modello;
        setNumeroPosti(numeroPosti);
        this.codiceIdentificativo = codiceIdentificativo;
        this.id = ++counter; // Incrementa il contatore e assegna l'ID
    }

    // * Getter per modello
    public String getModello() {
        return modello;
    }

    // * Setter per modello
    public void setModello(String modello) {
        this.modello = modello;
    }

    // * Getter per numero di posti
    public int getNumeroPosti() {
        return numeroPosti;
    }

    // ! Setter con validazione del numero di posti
    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0 && numeroPosti < 2000) {
            this.numeroPosti = numeroPosti;
        } else {
            throw new IllegalArgumentException("Il numero di posti deve essere compreso tra 0 e 500.");
        }
    }

    // * Getter per codice identificativo
    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    // * Metodo statico per ottenere il numero totale di aerei creati
    public static int getCounter() {
        return counter;
    }

    // * Getter per ID
    public int getId() {
        return id;
    }

    // * Metodo per stampare le informazioni dell'aereo
    public void printInfo() {
        System.out.println("Aereo [modello=" + modello + ", numeroPosti=" + numeroPosti + ", codiceIdentificativo="
                + codiceIdentificativo + ", id=" + id + "]");
    }

}
