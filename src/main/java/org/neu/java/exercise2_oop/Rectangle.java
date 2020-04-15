package org.neu.java.exercise2_oop;

public class Rectangle extends Shape {

    private int a;
    private int b;

    public Rectangle(String name, int a, int b) {
        super(name);
        this.a = a;
        this.b = b;
    }

    @Override
    double getArea() {
        return a * b;
    }

    @Override
    double getPerimeter() {
        return (a + b) * 2;
    }

    public static void main(String[] args) {
        Shape shape = new Rectangle("Rectangle B", 10, 20 );

        shape.printInfo();
    }

}
