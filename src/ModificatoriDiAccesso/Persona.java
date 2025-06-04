package ModificatoriDiAccesso;

public class Persona {
    // Campi privati (incapsulamento) - Private fields (encapsulation)
    // These fields store the state of a Persona object and are private to ensure
    // data hiding and control access through methods.
    private String nome; // Declares a private String variable named 'nome' (name)
    private int eta; // Declares a private int variable named 'eta' (age)
    // Costruttore pubblico - Public constructor
    // This is a special method used to create new instances of the Persona class.
    // It initializes the 'nome' and 'eta' fields when a new Persona object is
    // created.

    public Persona(String nome, int eta) { // Constructor that takes a name (String) and an age (int)
        this.nome = nome; // Assigns the passed 'nome' parameter to the 'nome' field of the object
        this.eta = eta; // Assigns the passed 'eta' parameter to the 'eta' field of the object
    }

    // Metodo privato utilizzato dalla classe - Private method used by the class
    // This method is private, meaning it can only be called from within the Persona
    // class itself.
    // It encapsulates the logic for checking if a person is of legal age.
    private boolean verificaMaggiorenne() { // Declares a private method that returns a boolean
        return this.eta >= 18; // Returns true if the 'eta' (age) is 18 or greater, false otherwise
    }

    // Metodo pubblico che fa uso del metodo privato - Public method that uses the
    // private method
    // This is a public method, meaning it can be called from outside the Persona
    // class.
    // It uses the private 'verificaMaggiorenne' method to determine the person's
    // status
    // and then prints a corresponding message.
    public void stampaStatus() { // Declares a public method that returns nothing (void)
        if (verificaMaggiorenne()) { // Calls the private 'verificaMaggiorenne' method
            // If the person is of legal age (method returns true)
            System.out.println(this.nome + " è maggiorenne."); // Prints that the person is of legal age
        } else {
            // If the person is not of legal age (method returns false)
            System.out.println(this.nome + " non è maggiorenne."); // Prints that the person is not of legal age
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
