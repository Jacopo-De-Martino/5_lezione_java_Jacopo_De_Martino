package CompagniaAerea;

public class Pilota {
    // * Attributi del pilota
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    // * Variabile statica per tenere traccia del numero totale di piloti creati
    private static int counter;

    // * ID univoco assegnato automaticamente ad ogni pilota
    private int id;

    // ! Costruttore con parametri
    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo); // * Valida le ore di volo
        this.id = ++counter; // * Assegna ID incrementando il contatore statico
    }

    // * Getter per il nome del pilota
    public String getNome() {
        return nome;
    }

    // * Setter per il nome del pilota
    public void setNome(String nome) {
        this.nome = nome;
    }

    // * Getter per il numero di brevetto
    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    // * Setter per il numero di brevetto
    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    // * Getter per le ore di volo
    public int getOreVolo() {
        return oreVolo;
    }

    // ! Setter con validazione: le ore di volo non possono essere negative
    public void setOreVolo(int oreVolo) {
        if (oreVolo >= 0) {
            this.oreVolo = oreVolo;
        } else {
            // ! Solleva eccezione in caso di input non valido
            throw new IllegalArgumentException("Le ore di volo non possono essere negative.");
        }
    }

    // * Metodo statico per ottenere il numero totale di piloti creati
    public static int getCounter() {
        return counter;
    }

    // * Getter per ID del pilota
    public int getId() {
        return id;
    }

    // * Metodo per stampare le informazioni complete del pilota
    public void printInfo() {
        System.out.println("Pilota [nome=" + nome
                + ", numeroBrevetto=" + numeroBrevetto
                + ", oreVolo=" + oreVolo
                + ", id=" + id + "]");
    }
}
