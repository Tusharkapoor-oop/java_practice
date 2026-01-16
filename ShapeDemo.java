import java.util.*;
class Shape {
    double radius;
    double length, width;

    Shape(double radius) {
        this.radius = radius;
        this.length = 0;
        this.width = 0;
    }

    Shape(double length, double width) {
        this.length = length;
        this.width = width;
        this.radius = 0;
    }

    void areaCircle() {
        if (radius > 0) {
            double area = 3.14 * radius * radius;
            System.out.println("Area of Circle with radius " + radius + " is: " + area);
        } else {
            System.out.println("Not a circle shape.");
        }
    }

    void areaRectangle() {
        if (length > 0 && width > 0) {
            double area = length * width;
            System.out.println("Area of Rectangle with length " + length + " and width " + width + " is: " + area);
        } else {
            System.out.println("Not a rectangle shape.");
        }
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Shape(14);
        circle.areaCircle();

        Shape rectangle = new Shape(15, 25);
        rectangle.areaRectangle();
    }
}

