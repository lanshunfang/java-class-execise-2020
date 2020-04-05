package org.neu.java.course.exercise0;

import java.util.Date;

public class Ox {

  class Farm {

  }
  class Cube {

  }

  public String color;
  public Date birthday;
  private String name;
  public String owner;
  public boolean isFather;
  public boolean isCastrated;
  public boolean height;
  public boolean weight;


  Ox(String name) {
    this.name = name;
    System.out.println("New Ox created with name " + name);
  }

  public static void main(String[] args) {
    final Ox ox1 = new Ox("Tom");
    final Ox ox2 = new Ox("Tim");
    final Ox ox3 = new Ox("John");
  }


  public void sound() {

  }

  public void layEggs() {

  }

  public void eat() {

  }

}
