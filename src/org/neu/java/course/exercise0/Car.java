package org.neu.java.course.exercise0;

import java.util.Date;

public class Car {
  class Dashboard {

  }

  class Tire {

  }

  public String color;
  public String year;
  private String VIN;
  public String modal;
  public String make;
  public Date purchaseDate;
  public String[] owners;
  public String currentOwner;


  Car(String VIN) {
    this.VIN = VIN;
    System.out.println("New Car created with VIN " + VIN);
  }

  public static void main(String[] args) {
    final Car car1 = new Car("2129f3a8-e6cc-4a89-a107-7c21218925c3");
    final Car car2 = new Car("c843c2e4-6daf-4309-b8ae-be7e1006bce7");
    final Car car3 = new Car("c813994d-4582-4b17-b7aa-a64170906e48");
  }

  public void brake() {

  }

  public String getVIN() {
    return this.VIN;
  }

  public void horn() {
  }


}
