package ProvaEreditarietà;

// 1. Base class for Bank
class Bank {
    // 2. Default rate of interest for a generic bank
    int getRateOfInterest() {
        return 0; // Default interest rate is 0%
    }
}

// 3. SBI bank class, extending Bank
class SBI extends Bank {
    // 4. Overrides the getRateOfInterest method for SBI
    @Override // Annotation to indicate that this method overrides a superclass method
    int getRateOfInterest() {
        return 8; // SBI offers 8% interest
    }
}

// 5. ICICI bank class, extending Bank
class ICICI extends Bank {
    // 6. Overrides the getRateOfInterest method for ICICI
    @Override
    int getRateOfInterest() {
        return 7; // ICICI offers 7% interest
    }
}

// 7. AXIS bank class, extending Bank
class AXIS extends Bank {
    // 8. Overrides the getRateOfInterest method for AXIS
    @Override
    int getRateOfInterest() {
        return 9; // AXIS offers 9% interest
    }
}

// 1. Test class to demonstrate polymorphism
public class Test2 { // The public class must match the file name (Test2.java)
    // 2. Main method, the entry point of the program
    public static void main(String args[]) {
        // 3. Create an object of SBI. 's' is declared as type Bank, but the object is
        // SBI.
        // This demonstrates polymorphism.
        Bank s = new SBI();
        // 4. Create an object of ICICI. 'i' is declared as type Bank, but the object is
        // ICICI.
        Bank i = new ICICI();
        // 5. Create an object of AXIS. 'a' is declared as type Bank, but the object is
        // AXIS.
        Bank a = new AXIS();

        // 6. Call getRateOfInterest on the SBI object.
        // Due to polymorphism, the overridden method in SBI class is called.
        System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
        // 7. Call getRateOfInterest on the ICICI object.
        // The overridden method in ICICI class is called.
        System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
        // 8. Call getRateOfInterest on the AXIS object.
        // The overridden method in AXIS class is called.
        System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());
    }
}