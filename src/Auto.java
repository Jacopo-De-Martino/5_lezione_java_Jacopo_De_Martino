public class Auto {
    // ! Attributi
    String targa;
    String modello;
    String colore;
    int anno;
    double km;
    static int counter;

    // ! Costruttore con parametri
    public Auto(String targa, String modello, String colore, int anno, double km) {
        this.targa = targa;
        this.modello = modello;
        this.colore = colore;
        this.anno = anno;
        this.km = km;
        counter++;
    }

    @Override
    public String toString() {
        return "Auto [targa=" + targa + ", modello=" + modello + ", colore=" + colore + ", anno=" + anno + ", km=" + km
                + "]";
    }

}
