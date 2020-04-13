package org.neu.java.exercise0;

import java.util.Date;

public class CellPhone {
  class OS {

  }
  class Screen {

  }
  public String color;
  public Date year;
  private String IMEI;
  public int batteryCapability;
  public String brand;
  public Date purchaseDate;
  public boolean isSmartPhone;
  public String[] owners;

  CellPhone(String IMEI, String color) {
    this.IMEI = IMEI;
    this.color = color;
    System.out.println("New CellPhone created with IMEI " + IMEI + ", Color " + color);
  }

  public static void main(String[] args) {
    final CellPhone phone1 = new CellPhone("2129f3a8-e6cc-4a89-a107-7c21218925c3", "red");
    final CellPhone phone2 = new CellPhone("c843c2e4-6daf-4309-b8ae-be7e1006bce7", "blue");
    final CellPhone phone3 = new CellPhone("c813994d-4582-4b17-b7aa-a64170906e48", "yellow");
  }

  public void beep() {

  }

  public String getIMEI() {
    return this.IMEI;
  }

  public void setYear(Date year) {
    this.year = year;
  }

}
