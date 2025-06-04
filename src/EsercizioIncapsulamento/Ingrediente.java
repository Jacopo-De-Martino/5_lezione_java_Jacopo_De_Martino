package EsercizioIncapsulamento;

public class Ingrediente {
    private String nome;
    private double price;

    public double getPrice() {
        return price;
    }

    public Ingrediente(String nome, double price) {
        this.nome = nome;
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
