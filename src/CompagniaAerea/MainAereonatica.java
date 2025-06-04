package CompagniaAerea;

import java.util.Scanner;

public class MainAereonatica {
    public static void main(String[] args) {

        // HARDCODE: CompagniaAerea testing
        CompagniaAerea compagnia = new CompagniaAerea();
        compagnia.setNome("AeroLinee Italia");
        // Creazione di un aereo
        Aereo aereo1 = new Aereo("Boeing 737", 20, "A1234");
        System.out.println("Aereo creato: " + aereo1.getModello() + ", ID: " + aereo1.getId());
        // Creazione di un pilota
        Pilota pilota1 = new Pilota("Mario Rossi", "BREV123", 50);
        System.out.println("Pilota creato: " + pilota1.getNome() + ", ID: " + pilota1.getId());
        // Visualizzazione del contatore degli aerei e dei piloti
        System.out.println("Numero totale di aerei: " + Aereo.getCounter());
        System.out.println("Numero totale di piloti: " + Pilota.getCounter());

        compagnia.addAereo(aereo1);
        compagnia.addPilota(pilota1);

        Scanner scanner = new Scanner(System.in);

        // ! programma
        while (true) {
            System.out.println("\n==MENU==");
            System.out.println("1. Aggiungi un aereo");
            System.out.println("2. Aggiungi un pilota");
            System.out.println("3. Visualizza aerei");
            System.out.println("4. Visualizza piloti");
            System.out.println("5. Visualizza numero totale di aerei e piloti");
            System.out.println("6. Visualizza aereo per id o per nome modello");
            System.out.println("7. Visualizza pilota per id o per nome");
            System.out.println("0. Esci\n");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimasto

            switch (scelta) {
                // ! case per aggiunta pilota
                case 1:
                    System.out.println("\n1. Aggiungi un aereo");
                    System.out.print("Inserisci il modello dell'aereo: ");
                    String modello = scanner.nextLine();
                    System.out.print("Inserisci il numero di posti: ");
                    int numeroPosti = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimasto
                    System.out.print("Inserisci il codice identificativo: ");
                    String codiceIdentificativo = scanner.nextLine();
                    Aereo nuovoAereo = new Aereo(modello, numeroPosti, codiceIdentificativo);
                    System.out.println("Aereo aggiunto: " + nuovoAereo.getModello() + ", ID: " + nuovoAereo.getId());
                    compagnia.addAereo(nuovoAereo);
                    break;
                // ! case per aggiunta pilota
                case 2:
                    System.out.println("\n2. Aggiungi un pilota");
                    System.out.print("Inserisci il nome del pilota: ");
                    String nomePilota = scanner.nextLine();
                    System.out.print("Inserisci il codice brevettato: ");
                    String codiceBrevettato = scanner.nextLine();
                    System.out.print("Inserisci le ore di volo: ");
                    int oreVolo = scanner.nextInt();
                    Pilota nuovoPilota = new Pilota(nomePilota, codiceBrevettato, oreVolo);
                    System.out.println("Pilota aggiunto: " + nuovoPilota.getNome() + ", ID: " + nuovoPilota.getId());
                    compagnia.addPilota(nuovoPilota);
                    break;
                // ! stampa i piloti della compagnia
                case 3:
                    System.out.println("\n3. Visualizza aerei");
                    compagnia.printAerei();
                    break;
                // ! Stampa numero totale di aerei e piloti e "compagnia"
                case 4:
                    System.out.println("\n4. Visualizza piloti");
                    compagnia.printPiloti();
                    break;
                case 5:
                    System.out.println("\n5. Visualizza numero totale di aerei e piloti");
                    System.out.println("Numero totale di aerei: " + Aereo.getCounter());
                    System.out.println("Numero totale di piloti: " + Pilota.getCounter());
                    compagnia.print();
                    break;
                // ! Accesso filtri per AEREO
                case 6:
                    System.out.println("\n6. Visualizza aereo");
                    System.out.println("1. Cerca per ID");
                    System.out.println("2. Cerca per modello");
                    int sceltaAereo = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimasto
                    switch (sceltaAereo) {
                        // ! Filtro per ID AEREO
                        case 1:
                            System.out.print("Inserisci l'ID dell'aereo: ");
                            int idAereo = scanner.nextInt();
                            scanner.nextLine(); // Consuma il newline rimasto
                            Aereo aereoTrovato = compagnia.filtraAereoPerId(idAereo);
                            if (aereoTrovato != null) {
                                aereoTrovato.printInfo();
                            } else {
                                System.out.println("Aereo con ID " + idAereo + " non trovato.");
                            }
                            break;
                        // ! Filtro per MODELLO AEREO
                        case 2:
                            System.out.print("Inserisci il modello dell'aereo: ");
                            String modelloAereo = scanner.nextLine();
                            Aereo aereoModelloTrovato = compagnia.filtraAereoPerModello(modelloAereo);
                            if (aereoModelloTrovato != null) {
                                aereoModelloTrovato.printInfo();
                            } else {
                                System.out.println("Aereo con modello '" + modelloAereo + "' non trovato.");
                            }
                            break;
                        // default statement filtro aereo statement
                        default:
                            System.out.println("Opzione non valida per la ricerca aereo.");
                    }
                    break;
                // ! Accesso filtri per pilota
                case 7:
                    System.out.println("\n7. Visualizza pilota");
                    System.out.println("1. Cerca per ID");
                    System.out.println("2. Cerca per nome");
                    int sceltaPilota = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimasto
                    switch (sceltaPilota) {
                        // ! Filtro per ID PILOTA
                        case 1:
                            System.out.print("Inserisci l'ID del pilota: ");
                            int idPilota = scanner.nextInt();
                            scanner.nextLine(); // Consuma il newline rimasto
                            Pilota pilotaTrovato = compagnia.filtraPilotaPerId(idPilota);
                            if (pilotaTrovato != null) {
                                pilotaTrovato.printInfo();
                            } else {
                                System.out.println("Pilota con ID " + idPilota + " non trovato.");
                            }
                            break;
                        // ! Filtro per NOME PILOTA
                        case 2:
                            System.out.print("Inserisci il nome del pilota: ");
                            String nomePilotaRicerca = scanner.nextLine();
                            Pilota pilotaNomeTrovato = compagnia.filtraPilotaPerNome(nomePilotaRicerca);
                            if (pilotaNomeTrovato != null) {
                                pilotaNomeTrovato.printInfo();
                            } else {
                                System.out.println("Pilota con nome '" + nomePilotaRicerca + "' non trovato.");
                            }
                            break;
                        // default statement filtro pilota statement
                        default:
                            System.out.println("Opzione non valida per la ricerca pilota.");
                    }
                    break;
                default:
                    System.out.println("\nInserire un'opzione valida (1-3).");
                    break;
            }
            // ! Condizione uscita ciclo
            if (scelta == 0) {
                System.out.println("Uscita dal programma.");
                break;
            }
        }
        // chiusuta programma
        System.out.println("Grazie per aver utilizzato il sistema di gestione della compagnia aerea!");
        scanner.close();
    }

}
