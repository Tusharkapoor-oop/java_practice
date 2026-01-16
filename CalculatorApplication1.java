

import java.util.*;

class Calculator {

    

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if(b == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double)a / b;
    }
}

public class UserInterface {

    Scanner sc;
    Calculator calc;

    public UserInterface(){
        sc = new Scanner(System.in);
        calc = new Calculator();
    }

    public void performAddition(){
        System.out.println("1. Add two integers");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.print("Enter your choice: ");

        try{
            int ch = sc.nextInt();

            if(ch == 1){
                System.out.print("Enter first integer: ");
                int a = sc.nextInt();
                System.out.print("Enter second integer: ");
                int b = sc.nextInt();
                System.out.println("Result: " + calc.add(a, b));
            }
            else if(ch == 2){
                System.out.print("Enter first double: ");
                double a = sc.nextDouble();
                System.out.print("Enter second double: ");
                double b = sc.nextDouble();
                System.out.println("Result: " + calc.add(a, b));
            }
            else if(ch == 3){
                System.out.print("Enter first integer: ");
                int a = sc.nextInt();
                System.out.print("Enter second integer: ");
                int b = sc.nextInt();
                System.out.print("Enter third integer: ");
                int c = sc.nextInt();
                System.out.println("Result: " + calc.add(a, b, c));
            }
            else{
                System.out.println("Invalid choice.");
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter correct numbers.");
            sc.nextLine();
        }
    }

    public void performSubtraction(){
        try{
            System.out.print("Enter first integer: ");
            int a = sc.nextInt();
            System.out.print("Enter second integer: ");
            int b = sc.nextInt();
            System.out.println("Result: " + calc.subtract(a, b));
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Enter integers only.");
            sc.nextLine();
        }
    }

    public void performMultiplication(){
        try{
            System.out.print("Enter first double: ");
            double a = sc.nextDouble();
            System.out.print("Enter second double: ");
            double b = sc.nextDouble();
            System.out.println("Result: " + calc.multiply(a, b));
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Enter numbers only.");
            sc.nextLine();
        }
    }

    public void performDivision(){
        try{
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            double result = calc.divide(a, b);
            System.out.println("Result: " + result);
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Enter integers only.");
            sc.nextLine();
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

    public void mainMenu(){
        int choice = 0;
        do{
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try{
                choice = sc.nextInt();
                switch(choice){
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
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Enter a number from 1 to 5.");
                sc.nextLine();
            }

        }while(choice != 5);
    }

    public static void main(String args[]){
        UserInterface app = new UserInterface();
        app.mainMenu();
    }
}
