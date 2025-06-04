public class Utente {
    String nome;
    String email;
    String password;

    // ! field utente -> costruttore con parametri
    public Utente(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    // ! funzione di registrazione ritorna un utente
    static Utente register(String nome, String email, String password) {
        Utente u = new Utente(nome, email, password);
        return u;
    }

}
