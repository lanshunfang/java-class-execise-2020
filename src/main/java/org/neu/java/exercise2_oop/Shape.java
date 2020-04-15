package org.neu.java.exercise2_oop;

import java.util.Date;

public abstract class Shape {
    final String name;
    transient long createdTime;

    static int countOfShapeCreated;

    public Shape(String name) {
        this.name = name;
        createdTime = System.currentTimeMillis();
        countOfShapeCreated++;
    }

    abstract double getArea();

    abstract double getPerimeter();

    protected void printInfo() {
        System.out.println(
                String.format(
                        "Area of \"%s\" is %.0f",
                        this.name,
                        this.getArea()
                )
        );

        System.out.println(
                String.format(
                        "Perimeter of \"%s\" is %.0f",
                        this.name,
                        this.getPerimeter()
                )
        );

        System.out.println(
                String.format(
                        "You have %d shape%s created",
                        Shape.countOfShapeCreated,
                        Shape.countOfShapeCreated > 1 ? "s" : ""

                )
        );
    }
}
