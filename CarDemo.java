import java.util.*;
class Car {
    String brand;
    String model;
    int year;

    Car() {
        this("Unknown");
    }

    Car(String brand) {
        this(brand, "Not Specified", 0);
    }

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.displayInfo();

        Car c2 = new Car("Honda");
        c2.displayInfo();

        Car c3 = new Car("Hyundai", "i20", 2019);
        c3.displayInfo();
    }
}

