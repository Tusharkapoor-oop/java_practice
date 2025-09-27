class Shape {
    void area() {
        System.out.println("Displays area of shape");
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) {
        radius = r;
    }
    void area() {
        super.area();
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle   : " + area);
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;
    Rectangle(double l, double b) {
        length = l;
        breadth = b;
    }
    void area() {
        super.area();
        double area = length * breadth;
        System.out.println("Area of rectangle: " + area);
    }
}
public class inheritance_java_lab{
    public static void main(String[] args) {
        Circle c = new Circle(8.8);
        Rectangle r = new Rectangle(22,33);
        c.area();
        r.area();
    }
    
}