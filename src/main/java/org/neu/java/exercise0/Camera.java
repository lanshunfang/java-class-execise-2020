package org.neu.java.exercise0;

import java.util.Date;

public class Camera {

  class Company {

  }
  class Dashboard {

  }

  public String color;
  public Date year;
  private String ID;
  public String brand;
  public String[] supportedRecordVideoFormats;
  public boolean isSupportWifi;
  public int maxMemoryCardCapability;
  public int runningRAM;

  Camera(String ID) {
    this.ID = ID;
    System.out.println("New Camera created with ID " + ID);
  }

  public static void main(String[] args) {
    final Camera camera1 = new Camera("2129f3a8-e6cc-4a89-a107-7c21218925c3");
    final Camera camera2 = new Camera("c843c2e4-6daf-4309-b8ae-be7e1006bce7");
    final Camera camera3 = new Camera("c813994d-4582-4b17-b7aa-a64170906e48");
  }

  public void record() {

  }

  public void takeSnapshot() {

  }

  public void setYear(Date year) {
    this.year = year;
  }

}
