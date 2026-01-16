import java.util.Scanner;

// Task 1: Student Class
class Student {
    private String rollNo;
    private String name;
    private String course;
    private double marks;
    private String grade;

    // Method to input student details
    public void inputStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        do {
            System.out.print("Enter Marks (0-100): ");
            while (!sc.hasNextDouble()) {
                System.out.print("Invalid input. Enter a number between 0 and 100: ");
                sc.next();
            }
            marks = sc.nextDouble();
            sc.nextLine(); // consume newline
        } while (marks < 0 || marks > 100);

        calculateGrade();
    }

    // Method to calculate grade based on marks
    private void calculateGrade() {
        if (marks >= 90)
            grade = "A+";
        else if (marks >= 80)
            grade = "A";
        else if (marks >= 70)
            grade = "B";
        else if (marks >= 60)
            grade = "C";
        else if (marks >= 50)
            grade = "D";
        else
            grade = "F";
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + grade);
        System.out.println("----------------------------");
    }
}

// Task 2: StudentManagementSystem Class
class StudentManagementSystem {
    private Student[] students;
    private int studentCount;

    // Initialize the system with max size
    public void initializeSystem(int size) {
        students = new Student[size];
        studentCount = 0;
    }

    // Adds a student record
    public void addStudent(Scanner sc) {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Array is full!");
            return;
        }
        Student s = new Student();
        s.inputStudent(sc);
        students[studentCount++] = s;
        System.out.println("Student added successfully!\n");
    }

    // Displays all student records
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records available!\n");
            return;
        }
        System.out.println("\n======= All Student Records =======");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
}

// Task 3: Main Driver Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.print("Enter the maximum number of students: ");
        int size = sc.nextInt();
        sc.nextLine();  // consume leftover newline

        sms.initializeSystem(size);

        int choice;
        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    sms.addStudent(sc);
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
