package EsercizioEreditarieta;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Piatto> piatti;

    public Menu() {
        this.piatti = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto) {
        this.piatti.add(piatto);
        System.out.println("Piatto '" + piatto.getNome() + "' aggiunto al menu.");
    }

    public void rimuoviPiatto(Piatto piatto) {
        if (this.piatti.remove(piatto)) {
            System.out.println("Piatto '" + piatto.getNome() + "' rimosso dal menu.");
        } else {
            System.out.println("Piatto '" + piatto.getNome() + "' non trovato nel menu.");
        }
    }

    public ArrayList<Piatto> getPiatti() {
        return piatti;
    }

    public void stampaMenu() {
        System.out.println("\n--- MENU DEL RISTORANTE ---");
        if (piatti.isEmpty()) {
            System.out.println("Il menu è vuoto.");
        } else {
            for (int i = 0; i < piatti.size(); i++) {
                Piatto p = piatti.get(i);
                System.out.println((i + 1) + ". " + p.getNome() + " - " + String.format("%.2f", p.getPrezzo()) + "€");
                System.out.println("   Descrizione: " + p.getDescrizione());
            }
        }
        System.out.println("---------------------------\n");
    }
}