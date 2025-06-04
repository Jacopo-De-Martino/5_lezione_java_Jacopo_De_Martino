package ProvaEreditarietà;

// ! Classe base
class Vehicle {
    protected String brand = "Ford";

    public void honk() {
        System.out.println("Beep, beep!");
    }

    public void run() {
        System.out.println("Veicolo in marcia");
    }
}

// ! Classe derivata Car
class Car extends Vehicle {
    private String modelName = "Fiesta";

    public void display() {
        System.out.println("Brand: " + brand + ", Model: " + modelName);
    }

    // ! Override del metodo run()
    @Override
    public void run() {
        System.out.println("L'auto è in movimento");
    }
}

// ! Classe derivata Bike
class Bike extends Vehicle {
    @Override
    public void run() {
        System.out.println("La moto sta viaggiando");
    }
}

// ! Classe derivata Bike2
class Bike2 extends Vehicle {
    @Override
    public void run() {
        System.out.println("Bike2 in corsa su strada");
    }
}

// ! Classe principale (deve avere lo stesso nome del file)
public class ProvaEreditarieta {
    public static void main(String[] args) {
        System.out.println("--- Car ---");
        Car myCar = new Car();
        myCar.display(); // Brand: Ford, Model: Fiesta
        myCar.honk(); // Beep, beep!
        myCar.run(); // L'auto è in movimento

        System.out.println("\n--- Bike ---");
        Bike myBike = new Bike();
        myBike.honk(); // Beep, beep!
        myBike.run(); // La moto sta viaggiando
        System.out.println("Brand: " + myBike.brand); // Ford

        System.out.println("\n--- Bike2 ---");
        Bike2 myBike2 = new Bike2();
        myBike2.run(); // Bike2 in corsa su strada
    }
}
