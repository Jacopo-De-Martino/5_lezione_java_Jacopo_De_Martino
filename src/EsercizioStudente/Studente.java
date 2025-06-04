package EsercizioStudente;

public class Studente {
    private static int idCounter = 1;
    private int id_stud;
    private String nome;
    private int voto;

    public Studente() {
        this.id_stud = idCounter++;
    }

    public Studente(String nome) {
        this(); // chiama il costruttore vuoto
        this.nome = nome;
    }

    public Studente(String nome, int voto) {
        this();
        this.nome = nome;
        setVoto(voto);
    }

    public int getId_stud() {
        return id_stud;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
            System.out.println(" Voto inserito con successo: " + this.voto);
        } else {
            System.out.println(" Voto fuori dal range consentito (0-10)");
        }
    }

    public void info() {
        System.out.println(" Studente [ID: " + id_stud + ", Nome: " + nome + ", Voto: " + voto + "]");
    }
}
