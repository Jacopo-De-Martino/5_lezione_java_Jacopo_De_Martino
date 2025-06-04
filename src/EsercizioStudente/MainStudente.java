package EsercizioStudente;

public class MainStudente {
    public static void main(String[] args) {
        // ! Test studente
        Studente studente1 = new Studente("Luca");
        Studente studente2 = new Studente("Jacopo", -1);// errore

        studente1.setVoto(10);
        studente1.setVoto(11);// errore

        System.out.println(studente1.getId_stud() + " " + studente1.getNome() + " " + studente1.getVoto());
        System.out.println(studente2.getId_stud() + " " + studente2.getNome() + " " + studente2.getVoto());

        Scuola scuolaJava = new Scuola();
        scuolaJava.addStud(studente2);
        scuolaJava.addStud(studente1);

        // utilizzo la funzione scuola per cercare uno Studente
        Studente trovato = scuolaJava.cercaStudentePerNome("luca");
        // se trovo lo studente stampo le sue info
        if (trovato != null) {
            trovato.info();
        } else {
            System.out.println(" Studente non trovato");
        }
    }
}
