package EsercizioEreditarieta;

public class CRIT_FORTI extends CRITICO {
    public CRIT_FORTI(String nome, String email) {
        super(nome, email); // Call the constructor of the CRITICO superclass
        System.out.println(nome + " è diventato un CRITICO FORTE!");
    }

    // Specific method for CRIT_FORTI as per "print unica"
    public void stampaProfiloAvanzato() {
        System.out.println("--- Profilo CRITICO FORTE ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Soldi: " + String.format("%.2f", getSoldi()));
        System.out.println("Recensioni Totali Effettuate: " + getRecensioniEffettuate());
        System.out.println("Status: CRITICO FORTE - Le tue opinioni contano di più!");
        System.out.println("-----------------------------");
    }

}