package org.neu.java.exercise3_serialization;

public class Triangle extends Shape {

    private int a;
    private int b;
    private int c;

    public Triangle(String name, int a, int b, int c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    public static void main(String[] args) {
        Shape shape = new Triangle("Triangle A", 3, 4, 5);

        shape.printInfo();
        shape.serialize();

        Shape shapeFromDeserialization = shape.deserialize();
        shapeFromDeserialization.printInfo();
    }

}
