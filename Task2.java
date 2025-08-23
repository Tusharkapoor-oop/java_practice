import java.util.*;

class Student {
    private int rollNo;
    private String course;
    private double marks;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));
            Student s = new Student();

            System.out.print("Roll No: ");
            s.setRollNo(sc.nextInt());
            sc.nextLine(); // Consume newline

            System.out.print("Course: ");
            s.setCourse(sc.nextLine());

            System.out.print("Marks: ");
            s.setMarks(sc.nextDouble());
            sc.nextLine(); // Consume newline

            students[i] = s;
            System.out.println("Student added successfully!");
        }

        // Optional: Display all student details
        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            s.displayDetails();
            System.out.println("-----------------------");
        }

        sc.close();
    }
}
