package EsercizioStudente;

import java.util.ArrayList;
import java.util.List;

public class Scuola {
    private List<Studente> studenti = new ArrayList<>();

    void addStud(Studente stud) {
        studenti.add(stud);
    }

    Studente cercaStudentePerNome(String nome) {
        for (Studente s : studenti) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

}
