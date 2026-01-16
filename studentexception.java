import java.util.*;
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}
class Studentresult{
    String name;
    float marks;
    public Studentresult(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public void checkMarks() throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks should be between 0 and 100.");
        } else {
            System.out.println("Student: " + name + ", Marks: " + marks + " - Valid");
        }
    }
}
public class studentexception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            float marks = sc.nextFloat();

            Studentresult s = new Studentresult(name, marks);
            s.checkMarks();

            if (marks >= 40){
                System.out.println("Result: Pass");
            } 
            else{
                System.out.println("Result: Fail");
            }

        } catch (InvalidMarksException e){
            System.out.println("Error: " + e.getMessage());

        } 
        catch (Exception e){
            System.out.println("Invalid input! Please enter numbers only.");
        }

        sc.close();
    }
}
    