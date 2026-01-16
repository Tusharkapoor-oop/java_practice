import java.util.*;
class Student {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }
}

class Marks extends Student {
    int m1, m2, m3;

    Marks(int rollNo, String name, String course, int m1, int m2, int m3) {
        super(rollNo, name, course);
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
}

class Result extends Marks {
    int total;
    double percentage;
    String grade;

    Result(int rollNo, String name, String course, int m1, int m2, int m3) {
        super(rollNo, name, course, m1, m2, m3);
    }

    void calculate() {
        total = m1 + m2 + m3;
        percentage = total / 3.0;

        if (percentage >= 90)
            grade = "A";
        else if (percentage >= 75)
            grade = "B";
        else if (percentage >= 50)
            grade = "C";
        else
            grade = "D";
    }

    void display() {
        System.out.println("---- Student Result---- ");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Result r = new Result(205, "tusharkapoor", "B.Tech", 55, 47, 75);
        r.calculate();
        r.display();
    }
}
