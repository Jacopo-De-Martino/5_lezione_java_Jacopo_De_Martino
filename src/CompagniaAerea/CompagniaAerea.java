package CompagniaAerea;

import java.util.ArrayList;
import java.util.List;

public class CompagniaAerea {

    // * Attributo per il nome della compagnia aerea
    private String nome;

    // * Lista di aerei associati alla compagnia
    private List<Aereo> aerei = new ArrayList<>();

    // * Lista di piloti associati alla compagnia
    private List<Pilota> piloti = new ArrayList<>();

    // ! Costruttore di default (senza parametri)
    public CompagniaAerea() {
        // TODO: eventualmente inizializzare altri attributi se necessario
    }

    // * Getter e setter per il nome della compagnia
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // * Getter e setter per la lista di aerei
    public List<Aereo> getAerei() {
        return aerei;
    }

    public void setAerei(List<Aereo> aerei) {
        this.aerei = aerei;
    }

    // * Getter e setter per la lista di piloti
    public List<Pilota> getPiloti() {
        return piloti;
    }

    public void setPiloti(List<Pilota> piloti) {
        this.piloti = piloti;
    }

    // ! Costruttore con parametri
    public CompagniaAerea(String nome, List<Aereo> aerei, List<Pilota> piloti) {
        this.nome = nome;
        this.aerei = aerei;
        this.piloti = piloti;
    }

    // * Aggiunge un aereo alla lista, controllando che non sia null
    public void addAereo(Aereo aereo) {
        if (aereo != null) {
            aerei.add(aereo);
        } else {
            // ! Controllo su valore nullo per evitare eccezioni a runtime
            throw new IllegalArgumentException("L'aereo non può essere null.");
        }
    }

    // * Aggiunge un pilota alla lista, controllando che non sia null
    public void addPilota(Pilota pilota) {
        if (pilota != null) {
            piloti.add(pilota);
        } else {
            // ! Controllo su valore nullo per evitare eccezioni a runtime
            throw new IllegalArgumentException("Il pilota non può essere null.");
        }
    }

    // * Stampa l'elenco degli aerei della compagnia
    public void printAerei() {
        System.out.println("Aerei della compagnia " + nome + ":");
        for (Aereo aereo : aerei) {
            System.out.println(" - " + aereo.getModello() + " (" + aereo.getCodiceIdentificativo() + ")");
        }
    }

    // * Stampa l'elenco dei piloti della compagnia
    public void printPiloti() {
        System.out.println("Piloti della compagnia " + nome + ":");
        for (Pilota pilota : piloti) {
            System.out.println(" - " + pilota.getNome() + " (ID: " + pilota.getId() + ")");
        }
    }

    // * Stampa riassuntiva della compagnia: nome, aerei e piloti
    public void print() {
        System.out.println("Compagnia Aerea: " + nome);
        System.out.println("Aerei:");
        printAerei();
        System.out.println("Piloti:");
        printPiloti();
    }

    // ! ================= FILTRI =================

    // * Restituisce un aereo cercandolo per ID
    public Aereo filtraAereoPerId(int id) {
        for (Aereo aereo : aerei) {
            if (aereo.getId() == id) {
                return aereo;
            }
        }
        return null; // ? Se non trovato, ritorna null
    }

    // * Restituisce un pilota cercandolo per ID
    public Pilota filtraPilotaPerId(int id) {
        for (Pilota pilota : piloti) {
            if (pilota.getId() == id) {
                return pilota;
            }
        }
        return null; // ? Se non trovato, ritorna null
    }

    // * Cerca un aereo per modello (case-insensitive)
    public Aereo filtraAereoPerModello(String modello) {
        for (Aereo aereo : aerei) {
            if (aereo.getModello().equalsIgnoreCase(modello)) {
                return aereo;
            }
        }
        return null; // ? Se non trovato, ritorna null
    }

    // * Cerca un pilota per nome (case-insensitive)
    public Pilota filtraPilotaPerNome(String nome) {
        for (Pilota pilota : piloti) {
            if (pilota.getNome().equalsIgnoreCase(nome)) {
                return pilota;
            }
        }
        return null; // ? Se non trovato, ritorna null
    }

    //@formatter:off
}

















































//@formatter:off
// public List<Aereo> filtraAereiPerPosti(int minPosti, int maxPosti) {
// List<Aereo> aereiFiltrati = new ArrayList<>();
// for (Aereo aereo : aerei) {
// if (aereo.getNumeroPosti() >= minPosti && aereo.getNumeroPosti() <= maxPosti)
// {
// aereiFiltrati.add(aereo);
// }
// }
// return aereiFiltrati;
// }

// public List<Pilota> filtraPilotiPerOreVolo(int minOre, int maxOre) {
// List<Pilota> pilotiFiltrati = new ArrayList<>();
// for (Pilota pilota : piloti) {
// if (pilota.getOreVolo() >= minOre && pilota.getOreVolo() <= maxOre) {
// pilotiFiltrati.add(pilota);
// }
// }
// return pilotiFiltrati;
// }

// public List<Aereo> filtraAereiPerModello(String modello) {
// List<Aereo> aereiFiltrati = new ArrayList<>();
// for (Aereo aereo : aerei) {
// if (aereo.getModello().equalsIgnoreCase(modello)) {
// aereiFiltrati.add(aereo);
// }
// }
// return aereiFiltrati;
// }

// public List<Pilota> filtraPilotiPerNome(String nome) {
// List<Pilota> pilotiFiltrati = new ArrayList<>();
// for (Pilota pilota : piloti) {
// if (pilota.getNome().equalsIgnoreCase(nome)) {
// pilotiFiltrati.add(pilota);
// }
// }
// return pilotiFiltrati;
// }

// public List<Aereo> filtraAereiPerCodiceIdentificativo(String codice) {
// List<Aereo> aereiFiltrati = new ArrayList<>();
// for (Aereo aereo : aerei) {
// if (aereo.getCodiceIdentificativo().equalsIgnoreCase(codice)) {
// aereiFiltrati.add(aereo);
// }
// }
// return aereiFiltrati;
// }

// public List<Pilota> filtraPilotiPerCodiceBrevettato(String codice) {
// List<Pilota> pilotiFiltrati = new ArrayList<>();
// for (Pilota pilota : piloti) {
// if (pilota.getNumeroBrevetto().equalsIgnoreCase(codice)) {
// pilotiFiltrati.add(pilota);
// }
// }
// return pilotiFiltrati;
// }