package org.neu.java.exercise2_oop;

public class Circle extends Shape {

    private int r;

    public Circle(String name, int r) {
        super(name);
        this.r = r;

    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }

    @Override
    double getPerimeter() {
        return Math.PI * r * 2;
    }

    public static void main(String[] args) {
        Shape shape = new Circle("Circle E", 9);

        shape.printInfo();
    }

}
