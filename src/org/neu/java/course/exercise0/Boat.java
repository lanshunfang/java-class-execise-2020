package org.neu.java.course.exercise0;

import java.util.Date;

public class Boat {
  class Company {

  }
  class Dashboard {

  }
  public String color;
  public String year;
  private String VIN;
  public String modal;
  public String make;
  public Date purchaseDate;
  public String[] owners;
  public String currentOwner;

  Boat(String VIN) {
    this.VIN = VIN;Engineer
    System.out.println("New Boat created with VIN " + VIN);
  }

  public static void main(String[] args) {
    final Boat boat1 = new Boat("2129f3a8-e6cc-4a89-a107-7c21218925c3");
    final Boat boat2 = new Boat("c843c2e4-6daf-4309-b8ae-be7e1006bce7");
    final Boat boat3 = new Boat("c813994d-4582-4b17-b7aa-a64170906e48");
  }

  public void brake() {

  }

  public String getVIN() {
    return this.VIN;
  }

  public void addOwner(String ownerName) {
  }

}
