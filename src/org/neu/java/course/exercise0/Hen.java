package org.neu.java.course.exercise0;

import java.util.Date;

public class Hen {
  class Farm {

  }
  class Cube {

  }

  public String color;
  public Date birthday;
  private String name;
  public String owner;
  public boolean isMale;
  public boolean isCarryEggs;
  public boolean height;
  public boolean weight;

  
  Hen(String name) {
    this.name = name;
    System.out.println("New Hen created with name " + name);
  }

  public static void main(String[] args) {
    final Hen hen1 = new Hen("Phebe");
    final Hen hen2 = new Hen("Lydia");
    final Hen hen3 = new Hen("Anna");
  }

  public void sound() {

  }

  public void layEggs() {

  }

  public void eat() {

  }

}
