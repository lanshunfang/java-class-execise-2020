package org.neu.java.course.exercise0;

import java.util.Date;

public class Laptop {
  class OS {

  }
  class Screen {

  }

  public String color;
  public Date year;
  private String ID;
  public int batteryCapability;
  public String brand;
  public Date purchaseDate;
  public boolean isWindows;
  public boolean isSupportRJ45;


  Laptop(String ID) {
    this.ID = ID;
    System.out.println("New Laptop created with ID " + ID);
  }

  public static void main(String[] args) {
    final Laptop laptop1 = new Laptop("2129f3a8-e6cc-4a89-a107-7c21218925c3");
    final Laptop laptop2 = new Laptop("c843c2e4-6daf-4309-b8ae-be7e1006bce7");
    final Laptop laptop3 = new Laptop("c813994d-4582-4b17-b7aa-a64170906e48");
  }


  public void shutdown() {

  }

  public void halt() {


  }

  public void closeLid() {


  }

}
