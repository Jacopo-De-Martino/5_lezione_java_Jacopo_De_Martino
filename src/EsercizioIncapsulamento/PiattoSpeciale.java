package EsercizioIncapsulamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PiattoSpeciale {
    private static final List<Ingrediente> ingredientiObbligatori = List.of(
            new Ingrediente("pane", 2.20),
            new Ingrediente("uova", 3.20),
            new Ingrediente("insalata", 2.50));
    public List<Ingrediente> scelti = new ArrayList<>();

    private double calcolaPrezzo() {
        double price = 0;
        for (Ingrediente igo : ingredientiObbligatori) {
            price += igo.getPrice();
        }
        for (Ingrediente igs : scelti) {
            price += igs.getPrice();
        }
        return price;
    }

    public PiattoSpeciale() {
    }

    void addIngredienti(Ingrediente scleto) {
        scelti.add(scleto);
    }

    public PiattoSpeciale(List<Ingrediente> scelti) {
        this.scelti = scelti;
    }

    PiattoSpeciale componiPiatto() {
        return new PiattoSpeciale(scelti);
    }

    public String showPlate() {
        String obbligatoriStr = ingredientiObbligatori.stream()
                .map(i -> i.getNome())
                .collect(Collectors.joining(", "));

        String sceltiStr = scelti.stream()
                .map(i -> i.getNome())
                .collect(Collectors.joining(", "));

        return "PiattoSpeciale {" +
                "\n  Ingredienti obbligatori: " + obbligatoriStr +
                "\n  Ingredienti scelti: " + sceltiStr +
                "\n  Prezzo totale: €" + String.format("%.2f", calcolaPrezzo()) +
                "\n}";
    }
}
