package org.neu.java.course;

public class Car {

  public String color;

  public void swapColors(Car x, Car y) {
    final String xColor = x.color;
    x.color = y.color;
    y.color = xColor;
  }

  Car(String color) {
    this.color = color;
  }

  public static void main(String[] args) {

    final Car a = new Car("white");
    final Car b = new Car("blue");

    System.out.println(a.color + "\t" + b.color);

    a.swapColors(a, b);

    System.out.println(a.color + "\t" + b.color);


  }
}
