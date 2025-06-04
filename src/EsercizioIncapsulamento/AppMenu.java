package EsercizioIncapsulamento;

import java.util.*;

public class AppMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu myMenu = new Menu();

        // Lista di ingredienti pubblici disponibili
        List<Ingrediente> pubbliciDisponibili = List.of(
                new Ingrediente("pomodoro", 1.00),
                new Ingrediente("maionese", 2.00),
                new Ingrediente("porchetta", 3.00),
                new Ingrediente("cipolla", 5.00),
                new Ingrediente("senape", 1.20));

        // Ingredienti obbligatori ammessi (già presenti nella classe PiattoSpeciale)
        List<String> nomiObbligatoriAmmessi = List.of("pane", "uova", "insalata");

        while (true) {
            System.out.println("\n CREA IL TUO PIATTO SPECIALE");
            PiattoSpeciale piatto = new PiattoSpeciale();

            // Mostra ingredienti pubblici disponibili
            System.out.println("Ingredienti pubblici disponibili:");
            for (int i = 0; i < pubbliciDisponibili.size(); i++) {
                System.out.println((i + 1) + ") " + pubbliciDisponibili.get(i).getNome() +
                        " - €" + pubbliciDisponibili.get(i).getPrice());
            }

            System.out.println("Seleziona gli ingredienti pubblici (numeri separati da virgola, es. 1,3,4):");
            String input = scanner.nextLine();
            String[] scelte = input.split(",");

            for (String scelta : scelte) {
                try {
                    int index = Integer.parseInt(scelta.trim()) - 1;
                    if (index >= 0 && index < pubbliciDisponibili.size()) {
                        piatto.addIngredienti(pubbliciDisponibili.get(index));
                    } else {
                        System.out.println(" Numero non valido: " + scelta);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(" Input non valido: " + scelta);
                }
            }

            // Mostra gli ingredienti obbligatori accettati
            System.out.println("\nIngredienti obbligatori inclusi automaticamente:");
            System.out.println(String.join(", ", nomiObbligatoriAmmessi));

            // Aggiunge il piatto al menu
            myMenu.add(piatto);

            // Mostra il piatto appena creato
            System.out.println("\n✅ PIATTO AGGIUNTO:");
            System.out.println(piatto.showPlate());

            // Chiede se creare un altro piatto
            System.out.println("\nVuoi creare un altro piatto? (s/n):");
            String continua = scanner.nextLine();
            if (!continua.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Mostra il menu finale
        System.out.println("\n MENU COMPLETO:");
        myMenu.showMenu();
        scanner.close();
    }
}
