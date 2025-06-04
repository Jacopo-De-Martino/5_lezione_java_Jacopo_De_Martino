package EsercizioEreditarieta;

import java.util.ArrayList;

public class Ristorante {
    private Menu menu; // Manages the list of Piatti
    private ArrayList<Recensione> recensioni; // Stores all reviews for the restaurant

    // Constructor to initialize the menu and review list
    public Ristorante() {
        this.menu = new Menu(); // Create a new Menu object
        this.recensioni = new ArrayList<>(); // Initialize the ArrayList for reviews
    }

    // Getter for the Menu object
    public Menu getMenu() {
        return menu;
    }

    // No setter for Menu is usually needed if it's created once in the constructor
    // public void setMenu(Menu menu) {
    // this.menu = menu;
    // }

    // Getter for the list of reviews
    public ArrayList<Recensione> getRecensioni() { // Changed name to plural
        return recensioni;
    }

    // No setter for the list of reviews is usually needed as you'd add/remove
    // individually
    // public void setRecensioni(ArrayList<Recensione> recensioni) { // Changed name
    // to plural
    // this.recensioni = recensioni;
    // }

    // Method to add a review to the restaurant's collection of reviews
    public void aggiungiRecensione(Recensione recensione) {
        this.recensioni.add(recensione);
        System.out.println("Recensione aggiunta con successo per " + recensione.getPiatto().getNome() + ".");
    }

    // Method for CHEF to add a dish to the restaurant's menu
    public void aggiungiPiatto(Piatto piatto) {
        this.menu.aggiungiPiatto(piatto); // Delegate to the Menu object's method
    }

    // Method to print all reviews (optional, but useful for testing)
    public void stampaTutteLeRecensioni() {
        System.out.println("\n--- TUTTE LE RECENSIONI ---");
        if (recensioni.isEmpty()) {
            System.out.println("Nessuna recensione disponibile.");
            return;
        }
        for (Recensione r : recensioni) {
            r.stampaRecensione(); // Assuming Recensione has a stampaRecensione method
            System.out.println("---------------------------");
        }
        System.out.println("---------------------------\n");
    }

    // You might also want a method to get reviews for a specific piatto
    public ArrayList<Recensione> getRecensioniPerPiatto(Piatto piatto) {
        ArrayList<Recensione> reviewsForDish = new ArrayList<>();
        for (Recensione r : recensioni) {
            if (r.getPiatto().equals(piatto)) { // You might need to override .equals() in Piatto for this
                reviewsForDish.add(r);
            }
        }
        return reviewsForDish;
    }

    // Method to calculate average rating for a dish (optional)
    public double calcolaMediaValutazionePiatto(Piatto piatto) {
        ArrayList<Recensione> reviews = getRecensioniPerPiatto(piatto);
        if (reviews.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (Recensione r : reviews) {
            totalRating += r.getValutazione();
        }
        return (double) totalRating / reviews.size();
    }
}