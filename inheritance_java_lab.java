class shape {
    void area() {
        System.out.println("Displays area of shape");
    }
}

class circle extends shape {
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

class rectangle extends shape {
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
        circle c = new circle(8.8);
        rectangle r = new rectangle(22,33);
        c.area();
        r.area();

        System.out.println("by polimorphism");
        // by polimorphism
        shape a = new circle(9.9);
        shape b = new rectangle(11,22);
        a.area();
        b.area();
    }
    
}