package EsercizioEreditarieta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRestaurant { // Corrected the typo from MainRestourant

    // Helper method to find a user by name
    private static Utente findUserByName(ArrayList<Utente> users, String name) {
        for (Utente user : users) {
            if (user.getNome().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    // Helper method to find a dish by name
    private static Piatto findPiattoByName(Menu menu, String name) {
        for (Piatto piatto : menu.getPiatti()) {
            if (piatto.getNome().equalsIgnoreCase(name)) {
                return piatto;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ristorante mioRistorante = new Ristorante();
        ArrayList<Utente> utentiRegistrati = new ArrayList<>();
        Utente utenteCorrente = null; // Will hold the currently logged-in user

        // Pre-populate with some users for easier testing
        utentiRegistrati.add(new Utente("Mario Rossi", "mario.rossi@example.com"));
        utentiRegistrati.add(new CHEF("Giulia Bianchi", "giulia.bianchi@example.com"));
        utentiRegistrati.add(new CRITICO("Luca Verdi", "luca.verdi@example.com"));

        System.out.println("Benvenuto nel Sistema di Gestione Ristorante!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU PRINCIPALE ---");
            if (utenteCorrente == null) {
                System.out.println("1. Crea Nuovo Utente");
                System.out.println("2. Accedi (Interagisci con Profilo)");
                System.out.println("3. Visualizza Menu Ristorante");
                System.out.println("4. Visualizza Tutte le Recensioni");
                System.out.println("5. Esci");
            } else {
                System.out.println("Sei loggato come: " + utenteCorrente.getNome());
                System.out.println("1. Visualizza il mio profilo");
                // Specific actions based on user type
                if (utenteCorrente instanceof CHEF) {
                    System.out.println("2. Aggiungi Piatto al Menu");
                } else if (utenteCorrente instanceof CRITICO) {
                    System.out.println("2. Aggiungi Recensione");
                }
                System.out.println("3. Visualizza Menu Ristorante");
                System.out.println("4. Visualizza Tutte le Recensioni");
                System.out.println("5. Disconnetti");
                System.out.println("6. Esci dal Programma");
            }

            System.out.print("Scegli un'opzione: ");
            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Per favore, inserisci un numero.");
                scanner.nextLine(); // Consume the invalid input
                continue; // Skip to next iteration of loop
            }

            if (utenteCorrente == null) { // Not logged in
                switch (choice) {
                    case 1: // Crea Nuovo Utente
                        System.out.print("Inserisci Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Inserisci Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Tipo di Utente (Utente/CHEF/CRITICO): ");
                        String tipo = scanner.nextLine().toUpperCase();

                        switch (tipo) {
                            case "UTENTE":
                                utentiRegistrati.add(new Utente(nome, email));
                                break;
                            case "CHEF":
                                utentiRegistrati.add(new CHEF(nome, email));
                                break;
                            case "CRITICO":
                                utentiRegistrati.add(new CRITICO(nome, email));
                                break;
                            default:
                                System.out.println("Tipo di utente non riconosciuto. Creato come Utente generico.");
                                utentiRegistrati.add(new Utente(nome, email));
                                break;
                        }
                        System.out.println("Utente " + nome + " creato con successo!");
                        break;
                    case 2: // Accedi (Interagisci con Profilo)
                        System.out.print("Inserisci il nome dell'utente per accedere: ");
                        String loginName = scanner.nextLine();
                        utenteCorrente = findUserByName(utentiRegistrati, loginName);
                        if (utenteCorrente != null) {
                            utenteCorrente.randomizeSoldi(); // Re-randomize soldi on login
                            System.out.println("Accesso effettuato come " + utenteCorrente.getNome() + ".");
                        } else {
                            System.out.println("Utente non trovato.");
                        }
                        break;
                    case 3: // Visualizza Menu Ristorante
                        mioRistorante.getMenu().stampaMenu();
                        break;
                    case 4: // Visualizza Tutte le Recensioni
                        mioRistorante.stampaTutteLeRecensioni();
                        break;
                    case 5: // Esci
                        running = false;
                        System.out.println("Uscita dal programma. Arrivederci!");
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                        break;
                }
            } else { // Logged in
                switch (choice) {
                    case 1: // Visualizza il mio profilo
                        if (utenteCorrente instanceof CHEF_CAPO) {
                            ((CHEF_CAPO) utenteCorrente).stampaProfiloAvanzato();
                        } else if (utenteCorrente instanceof CRIT_FORTI) {
                            ((CRIT_FORTI) utenteCorrente).stampaProfiloAvanzato();
                        } else {
                            utenteCorrente.stampaDati(); // Generic Utente method
                            if (utenteCorrente instanceof CHEF) {
                                System.out.println("Piatti aggiunti: " + ((CHEF) utenteCorrente).getPiattiAggiunti());
                            } else if (utenteCorrente instanceof CRITICO) {
                                System.out.println("Recensioni effettuate: "
                                        + ((CRITICO) utenteCorrente).getRecensioniEffettuate());
                            }
                        }
                        break;
                    case 2: // Specific action (Add Piatto or Add Recensione)
                        if (utenteCorrente instanceof CHEF) {
                            CHEF chef = (CHEF) utenteCorrente;
                            System.out.print("Nome Piatto: ");
                            String nomePiatto = scanner.nextLine();
                            System.out.print("Descrizione Piatto: ");
                            String descrizionePiatto = scanner.nextLine();
                            System.out.print("Prezzo Piatto: ");
                            float prezzoPiatto = -1;
                            try {
                                prezzoPiatto = scanner.nextFloat();
                                scanner.nextLine(); // Consume newline
                            } catch (InputMismatchException e) {
                                System.out.println("Input prezzo non valido. Riprova.");
                                scanner.nextLine(); // Consume invalid input
                                break;
                            }
                            chef.aggiungiPiatto(nomePiatto, descrizionePiatto, prezzoPiatto, mioRistorante.getMenu());

                            // Check for CHEF_CAPO promotion
                            if (chef.getPiattiAggiunti() >= 3 && !(chef instanceof CHEF_CAPO)) {
                                System.out.println("\n*** CONGRATULAZIONI! Sei diventato un CHEF CAPO! ***");
                                // Replace the old CHEF object with a new CHEF_CAPO object
                                int index = utentiRegistrati.indexOf(utenteCorrente);
                                CHEF_CAPO nuovoChefCapo = new CHEF_CAPO(chef.getNome(), chef.getEmail());
                                nuovoChefCapo.setSoldi(chef.getSoldi()); // Transfer current soldi

                                CHEF_CAPO promotedChef = new CHEF_CAPO(chef.getNome(), chef.getEmail());
                                promotedChef.setSoldi(chef.getSoldi());
                                promotedChef.setPiattiAggiunti(chef.getPiattiAggiunti()); // New method in CHEF
                                utentiRegistrati.set(index, promotedChef); // Replace in the list
                                utenteCorrente = promotedChef; // Update the current user reference
                            }

                        } else if (utenteCorrente instanceof CRITICO) {
                            CRITICO critico = (CRITICO) utenteCorrente;
                            mioRistorante.getMenu().stampaMenu();
                            if (mioRistorante.getMenu().getPiatti().isEmpty()) {
                                System.out.println("Nessun piatto da recensire al momento.");
                                break;
                            }
                            System.out.print("Nome del piatto da recensire: ");
                            String nomePiattoRecensione = scanner.nextLine();
                            Piatto piattoDaRecensire = findPiattoByName(mioRistorante.getMenu(), nomePiattoRecensione);

                            if (piattoDaRecensire != null) {
                                System.out.print("Testo della recensione: ");
                                String testoRecensione = scanner.nextLine();
                                System.out.print("Valutazione (1-5): ");
                                int valutazione = -1;
                                try {
                                    valutazione = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                } catch (InputMismatchException e) {
                                    System.out.println("Input valutazione non valido. Riprova.");
                                    scanner.nextLine(); // Consume invalid input
                                    break;
                                }
                                Recensione nuovaRecensione = critico.aggiungiRecensione(testoRecensione, valutazione,
                                        piattoDaRecensire);
                                if (nuovaRecensione != null) {
                                    mioRistorante.aggiungiRecensione(nuovaRecensione); // Add review to restaurant's
                                                                                       // list
                                }

                                // Check for CRIT_FORTI promotion
                                if (critico.getRecensioniEffettuate() >= 3 && !(critico instanceof CRIT_FORTI)) {
                                    System.out.println("\n*** CONGRATULAZIONI! Sei diventato un CRITICO FORTE! ***");
                                    int index = utentiRegistrati.indexOf(utenteCorrente);
                                    CRIT_FORTI promotedCritico = new CRIT_FORTI(critico.getNome(), critico.getEmail());
                                    promotedCritico.setSoldi(critico.getSoldi());
                                    promotedCritico.setRecensioniEffettuate(critico.getRecensioniEffettuate()); // Corrected
                                                                                                                // //
                                                                                                                // line
                                    utentiRegistrati.set(index, promotedCritico);
                                    utenteCorrente = promotedCritico;
                                }

                            } else {
                                System.out.println("Piatto non trovato.");
                            }
                        } else {
                            System.out.println("Non hai azioni specifiche.");
                        }
                        break;
                    case 3: // Visualizza Menu Ristorante
                        mioRistorante.getMenu().stampaMenu();
                        break;
                    case 4: // Visualizza Tutte le Recensioni
                        mioRistorante.stampaTutteLeRecensioni();
                        break;
                    case 5: // Disconnetti
                        System.out.println("Disconnesso da " + utenteCorrente.getNome() + ".");
                        utenteCorrente = null;
                        break;
                    case 6: // Esci dal Programma
                        running = false;
                        System.out.println("Uscita dal programma. Arrivederci!");
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                        break;
                }
            }
        }
        scanner.close();
    }
}