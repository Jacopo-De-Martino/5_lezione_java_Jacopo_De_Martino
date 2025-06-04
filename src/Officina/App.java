package Officina;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // ! test app auto
        Officina myOfficina = new Officina("myOfficina");
        myOfficina.addAuto(new Auto("32ACB04", "Fiat", "Bianca", 2007, 13098.00));
        myOfficina.addAuto(new Auto("32ACB04", "Tesla", "Bianca", 2015, 7098.00));
        // myOfficina.showAuto();

        // ! Menù
        Scanner scanner = new Scanner(System.in);

        // !Registrazione utente
        System.out.println("Inserisci nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci email");
        String email = scanner.nextLine();
        System.out.println("Inserisci password");
        String password = scanner.nextLine();
        Utente utente1 = Utente.register(nome, email, password);
        if (utente1 != null) {
            System.out.println("Registrazione completata!");
            while (true) {
                System.out.println("\n== MENU ==");
                System.out.println("1) Aggiungi auto");
                System.out.println("2) Mostra auto");
                System.out.println("3) Esci");
                System.out.print("Seleziona un'opzione: ");

                int value = scanner.nextInt();
                scanner.nextLine(); // Pulisce il buffer dopo il numero

                switch (value) {
                    // ! inserimento auto Scanner, metoto addAuto
                    case 1:
                        System.out.println("Inserisci la targa:");
                        String targa = scanner.nextLine();

                        System.out.println("Inserisci il modello:");
                        String modello = scanner.nextLine();

                        System.out.println("Inserisci il colore:");
                        String colore = scanner.nextLine();

                        System.out.println("Inserisci l'anno:");
                        int anno = scanner.nextInt();

                        System.out.println("Inserisci i chilometri:");
                        double km = scanner.nextDouble();
                        scanner.nextLine(); // Pulisce il buffer

                        Auto nuovaAuto = new Auto(targa, modello, colore, anno, km);
                        myOfficina.addAuto(nuovaAuto);
                        System.out.println("Auto aggiunta con successo!");
                        break;

                    case 2:
                        // ! Stampa delle auto metodo showAuto
                        System.out.println("Ci sono : " + Auto.counter + " auto presenti nell'officina : ");
                        myOfficina.showAuto();
                        break;

                    case 3:
                        System.out.println("Chiusura programma...");
                        return;

                    default:
                        System.out.println("Operazione non consentita. Riprova.");
                        break;
                }
            }
        } else {
            System.out.println("utente non trovato");
        }
    }

}
