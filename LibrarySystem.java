import java.util.*;
import java.io.*;

// Superclass: LibraryUser
class LibraryUser {
    protected String userId;
    protected String name;

    public LibraryUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int maxBooksAllowed() {
        return 0; // General user has no borrowing privileges by default
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Type: General User";
    }
}

// Subclass: Student
class Student extends LibraryUser {
    public Student(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int maxBooksAllowed() {
        return 3;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + " (Student)";
    }
}

// Subclass: Teacher
class Teacher extends LibraryUser {
    public Teacher(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int maxBooksAllowed() {
        return 5;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + " (Teacher)";
    }
}

// Subclass: Researcher
class Researcher extends LibraryUser {
    public Researcher(String userId, String name) {
        super(userId, name);
    }

    @Override
    public int maxBooksAllowed() {
        return 10;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + " (Researcher)";
    }
}

// Main Class
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Library Management System ------ ");
        System.out.print("Enter number of users to register: ");
        int n = sc.nextInt();
        sc.nextLine();  // consume newline

        LibraryUser[] users = new LibraryUser[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for User " + (i + 1) + ":");
            System.out.print("Enter User ID: ");
            String userId = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.println("Select User Type:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Researcher");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    users[i] = new Student(userId, name);
                    break;
                case 2:
                    users[i] = new Teacher(userId, name);
                    break;
                case 3:
                    users[i] = new Researcher(userId, name);
                    break;
                default:
                    System.out.println("Invalid choice! Added as general user.");
                    users[i] = new LibraryUser(userId, name);
            }
        }

        System.out.println("\n------ BORROWING LIMIT DETAILS ------- ");
        StringBuilder report = new StringBuilder();

        for (LibraryUser u : users) {
            int limit = u.maxBooksAllowed();
            System.out.println(u);
            System.out.println("Max Books Allowed: " + limit);
            System.out.println("                                                               ");

            report.append(u.toString()).append("\n");
            report.append("Max Books Allowed: ").append(limit).append("\n");
            report.append("                                                       \n");
        }

        // Write report to a text file
        try (FileWriter writer = new FileWriter("Library_Report.txt")) {
            writer.write(report.toString());
            System.out.println("\nReport successfully written to: Library_Report.txt");
        } catch (IOException e) {
            System.out.println("Error writing report file!");
        }

        System.out.println("Thank you for using the Library System!");

        sc.close();
    }
}
