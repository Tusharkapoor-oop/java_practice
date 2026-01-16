import java.util.*;
class Shape {
    void area() {
        System.out.println("Area cannot be calculated for a generic shape.");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void area() {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class shape_area {
    public static void main(String[] args) {
        Circle c = new Circle(21);
        c.area();

        Rectangle r = new Rectangle(25, 5);
        r.area();
    }
}
