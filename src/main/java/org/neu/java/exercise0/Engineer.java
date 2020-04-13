package org.neu.java.exercise0;

import java.util.Date;

public class Engineer {
  class Family {

  }
  class Personality {

  }

  public Date birthday;
  private String ID;
  public int groupId;
  public Date attendanceDate;
  public boolean isKnowDevOps;
  public boolean isKnowJavascript;
  public boolean isKnowTypescript;
  public boolean isKnowAzure;


  Engineer(String ID) {
    this.ID = ID;
    System.out.println("New Engineer created with ID " + ID);
  }

  public static void main(String[] args) {
    final Engineer engineer1 = new Engineer("2129f3a8-e6cc-4a89-a107-7c21218925c3");
    final Engineer engineer2 = new Engineer("c843c2e4-6daf-4309-b8ae-be7e1006bce7");
    final Engineer engineer3 = new Engineer("c813994d-4582-4b17-b7aa-a64170906e48");
  }

  public void develop() {

  }

  public void test() {


  }

  public void dismiss() {


  }

}
