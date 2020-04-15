package org.neu.java.exercise3_serialization;

public class Square extends Rectangle {

    public Square(String name, int a) {
        super(name, a, a);
    }

    public static void main(String[] args) {
        Shape shape = new Square("Square C", 3);
        shape.printInfo();
        shape.serialize();

        Shape shapeFromDeserialization = shape.deserialize();
        shapeFromDeserialization.printInfo();
    }

}
