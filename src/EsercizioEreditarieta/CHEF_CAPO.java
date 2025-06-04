package EsercizioEreditarieta;

public class CHEF_CAPO extends CHEF {
    public CHEF_CAPO(String nome, String email) {
        super(nome, email); // Call the constructor of the CHEF superclass
        System.out.println(nome + " è diventato un CHEF CAPO!");
    }

    // Specific method for CHEF_CAPO as per "print unica"
    public void stampaProfiloAvanzato() {
        System.out.println("--- Profilo CHEF CAPO ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Soldi: " + String.format("%.2f", getSoldi()));
        System.out.println("Piatti Totali Aggiunti: " + getPiattiAggiunti());
        System.out.println("Status: CHEF CAPO - Sei il maestro della cucina!");
        System.out.println("-------------------------");
    }

}