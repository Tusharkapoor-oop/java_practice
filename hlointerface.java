import java.util.Scanner;

/**
 * UserInterface class to interact with the user
 * This class handles user input and menu operations
 */
public class hlointerface {
    private Scanner scanner;
    private Calculator calculator;
    
    // Constructor to initialize objects
    public interface() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
    }
    
    /**
     * Method to perform addition based on user choice
     * Demonstrates method overloading in action
     */
    public void performAddition() {
        System.out.println("\n--- Addition Operation ---");
        System.out.println("Choose addition type:");
        System.out.println("1. Add two integers");
        System.out.println("2. Add two decimal numbers");
        System.out.println("3. Add three integers");
        System.out.print("Enter your choice (1-3): ");
        
        try {
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter first integer: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int num2 = scanner.nextInt();
                    int result1 = calculator.add(num1, num2);
                    System.out.println("Result: " + result1);
                    break;
                    
                case 2:
                    System.out.print("Enter first decimal number: ");
                    double d1 = scanner.nextDouble();
                    System.out.print("Enter second decimal number: ");
                    double d2 = scanner.nextDouble();
                    double result2 = calculator.add(d1, d2);
                    System.out.println("Result: " + result2);
                    break;
                    
                case 3:
                    System.out.print("Enter first integer: ");
                    int a = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b = scanner.nextInt();
                    System.out.print("Enter third integer: ");
                    int c = scanner.nextInt();
                    int result3 = calculator.add(a, b, c);
                    System.out.println("Result: " + result3);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter valid numbers!");
            scanner.nextLine(); // Clear the invalid input
        }
    }
    
    /**
     * Method to perform subtraction of two integers
     */
    public void performSubtraction() {
        System.out.println("\n--- Subtraction Operation ---");
        try {
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int num2 = scanner.nextInt();
            
            int result = calculator.subtract(num1, num2);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error: Please enter valid integers!");
            scanner.nextLine(); // Clear the invalid input
        }
    }
    
    /**
     * Method to perform multiplication of two decimal numbers
     */
    public void performMultiplication() {
        System.out.println("\n--- Multiplication Operation ---");
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            double result = calculator.multiply(num1, num2);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error: Please enter valid numbers!");
            scanner.nextLine(); // Clear the invalid input
        }
    }
    
    /**
     * Method to perform division with exception handling
     * Handles division by zero error
     */
    public void performDivision() {
        System.out.println("\n--- Division Operation ---");
        try {
            System.out.print("Enter numerator (integer): ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator (integer): ");
            int denominator = scanner.nextInt();
            
            double result = calculator.divide(numerator, denominator);
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Please enter valid integers!");
            scanner.nextLine(); // Clear the invalid input
        }
    }
    
    /**
     * Main menu to display options and handle user choices
     */
    public void mainMenu() {
        int choice;
        
        System.out.println("====================================");
        System.out.println("   Welcome to Calculator Application");
        System.out.println("====================================");
        
        do {
            System.out.println("\nPlease choose an operation:");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            try {
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        performAddition();
                        break;
                    case 2:
                        performSubtraction();
                        break;
                    case 3:
                        performMultiplication();
                        break;
                    case 4:
                        performDivision();
                        break;
                    case 5:
                        System.out.println("\nThank you for using Calculator Application!");
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1-5.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number (1-5)!");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Continue the loop
            }
            
        } while (choice != 5);
    }
    
    /**
     * Main method - starting point of the application
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
        
        // Close scanner when done
        ui.scanner.close();
    }
}