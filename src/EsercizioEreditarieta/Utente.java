package EsercizioEreditarieta;

import java.util.Random; // Import Random class for better control if needed, or stick with Math.random()

public class Utente {
    private String nome;
    private String email;
    private float soldi; // Initialize in constructor or separate method

    // Using a Random object for more flexible random number generation
    private static final Random random = new Random();

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.randomizeSoldi(); // Initialize soldi upon creation
    }

    // Method to randomize soldi, to be called at login or initialization
    public void randomizeSoldi() {
        // Generates a float between 0.0 (inclusive) and 100.0 (exclusive)
        this.soldi = random.nextFloat() * 100;
        // If you want integers or a specific range, you can adjust:
        // this.soldi = (float) (random.nextInt(100) + 1); // For integers between 1 and
        // 100
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSoldi() {
        return soldi;
    }

    // You might remove this setter if soldi should only be randomized and not set
    // arbitrarily
    public void setSoldi(float soldi) {
        this.soldi = soldi;
    }

    // Optional: A method to print user details (useful for testing)
    public void stampaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Soldi: " + String.format("%.2f", soldi)); // Format to 2 decimal places
    }
}