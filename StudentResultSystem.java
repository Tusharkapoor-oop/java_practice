import java.util.*;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String msg) {
        super(msg);
    }
}

class Student {
    String name;
    int m1, m2, m3;
    public Student(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    public double average() {
        return (m1 + m2 + m3) / 3.0;
    }
    public String result() {
        return average() >= 40 ? "Pass" : "Fail";
    }
}
public class StudentResultSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            if (name == null || name.trim().isEmpty()) {
                throw new NullPointerException("Name missing or pls enter any name");
                
            }
            System.out.print("Enter mark 1: ");
            int m1 = sc.nextInt();
            System.out.print("Enter mark 2: ");
            int m2 = sc.nextInt();
            System.out.print("Enter mark 3 ");
            int m3 = sc.nextInt();

            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
                throw new InvalidMarksException("Marks b/w 0 and 100 and find any error ");
            }
            Student s = new Student(name, m1, m2, m3);
            System.out.println("Name: " + s.name);
            System.out.println("Average: " + s.average());
            System.out.println("Result: " + s.result());
            sc.close();
        }
        catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        catch (InputMismatchException e) {
            System.out.println("Invalid input any inavallid operator types like int float ,long, double ");
        }
        catch (Exception e) {
            System.out.println(" error problem your code , find error ");
        }
    }
}
