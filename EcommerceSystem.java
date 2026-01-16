import java.util.*;

// Base class Product with attributes and default discount calculation
class Product {
    protected int id;
    protected String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Default discount: no discount
    public double calculateDiscount() {
        return 0.0;
    }

    // Calculate final price after discount
    public double getFinalPrice() {
        return price - calculateDiscount();
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: ₹" + price;
    }
}

// Electronics subclass with 10% discount override
class Electronics extends Product {
    private static final double DISCOUNT_RATE = 0.10;

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT_RATE;
    }
}

// Clothing subclass with 20% discount override
class Clothing extends Product {
    private static final double DISCOUNT_RATE = 0.20;

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT_RATE;
    }
}

// Groceries subclass with 5% discount override
class Groceries extends Product {
    private static final double DISCOUNT_RATE = 0.05;

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * DISCOUNT_RATE;
    }
}

// Main class that demonstrates polymorphism and billing
public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ E-Commerce System ------");
        System.out.print("Enter number of products to add to cart: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        Product[] cart = new Product[n];

        // Input product data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();

            System.out.println("Select Category:");
            System.out.println("1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Groceries");
            System.out.print("Your Choice: ");
            int category = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (category) {
                case 1:
                    cart[i] = new Electronics(id, name, price);
                    break;
                case 2:
                    cart[i] = new Clothing(id, name, price);
                    break;
                case 3:
                    cart[i] = new Groceries(id, name, price);
                    break;
                default:
                    System.out.println("Invalid category! Adding as generic product (no discount).");
                    cart[i] = new Product(id, name, price);
            }
        }

        // Calculate bill and display details
        double totalBill = 0;
        System.out.println("\n------ BILL DETAILS -------");
        for (Product p : cart) {
            double discount = p.calculateDiscount();
            double finalPrice = p.getFinalPrice();
            totalBill += finalPrice;

            System.out.println(p);
            System.out.printf("Discount Applied: ₹%.2f\n", discount);
            System.out.printf("Final Price: ₹%.2f\n", finalPrice);
            System.out.println();
        }

        System.out.printf("TOTAL BILL AMOUNT: ₹%.2f\n", totalBill);
        System.out.println("Thank you for shopping with us!");

        sc.close();
    }
}
