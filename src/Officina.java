import java.util.ArrayList;
import java.util.List;

public class Officina {
    String nomeOff;
    List<Auto> auto = new ArrayList<>();

    public Officina(String nomeOff, List<Auto> auto) {
        this.nomeOff = nomeOff;
        this.auto = auto;
    }

    public Officina(String nomeOff) {
        this.nomeOff = nomeOff;
    }

    void addAuto(Auto auto) {
        this.auto.add(auto);
    }

    void showAuto() {
        for (Auto auto : this.auto) {
            System.out.println(auto);
        }

    }

}
