import java.util.*;
class Person {
    String name;
    int age;

    Person() {
        System.out.println("Default constructor called");
        this.name = "Unknown";
        this.age = 0;
    }

    Person(String name, int age) {
        System.out.println("Parameterized constructor called");
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        System.out.println("Copy constructor called");
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.display();

        Person p2 = new Person("Krishan", 18);
        p2.display();

        Person p3 = new Person(p2);
        p3.display();
    }
}
