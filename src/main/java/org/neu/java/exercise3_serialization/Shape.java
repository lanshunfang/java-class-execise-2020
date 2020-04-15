package org.neu.java.exercise3_serialization;

import java.io.*;

public abstract class Shape implements Serializable {
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
                        "Area of \"%s\"(%d) is %.0f",
                        this.name,
                        this.createdTime,
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
                        "You have %d shape%s created\n",
                        Shape.countOfShapeCreated,
                        Shape.countOfShapeCreated > 1 ? "s" : ""

                )
        );
    }

    private String getSerializationFilePath() {
        return String.format(
                "/tmp/%s.java.ser",
                this.name
        );
    }

    protected Shape deserialize() {
        String filePath = this.getSerializationFilePath();
        Shape shape = null;
        try {
            FileInputStream fileIn =
                    new FileInputStream(
                            filePath
                    );

            ObjectInputStream in = new ObjectInputStream(fileIn);
            shape = (Shape)in.readObject();

            in.close();
            fileIn.close();

            System.out.println(
                    String.format(
                            "De-serialized data from  %s",
                            filePath
                    )
            );

        } catch (Exception i) {
            i.printStackTrace();
        }

        return shape;
    }

    protected void serialize() {

        String filePath = this.getSerializationFilePath();

        try {
            FileOutputStream fileOut =
                    new FileOutputStream(
                            filePath
                    );

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println(
                    String.format(
                            "Serialized data is saved in %s",
                            filePath
                    )
            );
        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}
