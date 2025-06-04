package EsercizioIncapsulamento;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // ! Array Piatti che conpongono il menu
    private List<PiattoSpeciale> menu = new ArrayList<>();

    // ! getMenu per accedere al menu
    public List<PiattoSpeciale> getMenu() {
        return menu;
    }

    // ! setMenu Per Modificare il Menu
    public void setMenu(List<PiattoSpeciale> menu) {
        this.menu = menu;
    }

    // //! costruttore
    // public Menu(List<PiattoSpeciale> menu) {
    // this.menu = menu;
    // }
    // !costruttore vuoto
    public Menu() {
    }

    // ! metodo per aggiungere un piatto
    public void add(PiattoSpeciale piatto) {
        menu.add(piatto);
    }

    // ! metodo per stampare il menu
    public void showMenu() {
        menu.forEach(p -> System.out.println(p.showPlate()));
    }

}
