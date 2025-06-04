package EsercizioEreditarieta;

public class Piatto {
    private String nome;
    private String descrizione;
    private float prezzo;

    public Piatto(String nome, String descrizione, float prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }
}