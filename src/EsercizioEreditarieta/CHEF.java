package EsercizioEreditarieta;

public class CHEF extends Utente {
    private int piattiAggiunti; // To track how many dishes this chef has added

    public CHEF(String nome, String email) {
        super(nome, email); // Call the constructor of the Utente superclass
        this.piattiAggiunti = 0; // Initialize dish count
    }

    // Method to allow a chef to add a dish
    // This method would typically interact with the Ristorante's menu
    public Piatto aggiungiPiatto(String nomePiatto, String descrizionePiatto, float prezzoPiatto, Menu menuRistorante) {
        // Basic validation for price (optional, but good practice)
        if (prezzoPiatto <= 0) {
            System.out.println("Il prezzo del piatto deve essere positivo.");
            return null;
        }
        Piatto nuovoPiatto = new Piatto(nomePiatto, descrizionePiatto, prezzoPiatto);
        menuRistorante.aggiungiPiatto(nuovoPiatto); // Add the plate to the restaurant's menu
        this.piattiAggiunti++; // Increment the count of dishes added by this chef
        System.out.println(getNome() + " ha aggiunto il piatto '" + nomePiatto + "' al menu.");
        return nuovoPiatto;
    }

    public int getPiattiAggiunti() {
        return piattiAggiunti;
    }

    // You might need a way to increment piattiAggiunti externally if dishes are
    // added differently
    public void incrementaPiattiAggiunti() {
        this.piattiAggiunti++;
    }

    public void setPiattiAggiunti(int piattiAggiunti) {
        this.piattiAggiunti = piattiAggiunti; // Assign the provided value to the field
    }
}