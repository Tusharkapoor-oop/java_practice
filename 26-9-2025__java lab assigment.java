class Car {    
    String model;
    int year;
    String brand;
    
    Car() {
        this("unknown", 0, "unknown");
    }
    
    Car(String brand) {
        this("unknown", 0, brand);  
    }
    
    Car(String model, int year, String brand) {
        this.model = model;  
        this.year = year;
        this.brand = brand;
    }
    void displayInfo(){
        System.out.println(" Model: "+model+" Year: "+year+" Brand: "+brand);
    }

}
public class hlo {  
    public static void main(String[] args) {
        Car c = new Car("rr", 2025, "Camry");
        Car c1 = new Car();
        Car c2 = new Car("Honda");
        
        c.displayInfo();
        c1.displayInfo();
        c2.displayInfo();
    }
}