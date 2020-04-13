package org.neu.java.exercise0;

import java.util.Date;

public class QA {

  class Family {

  }
  class Personality {

  }

  public Date birthday;
  private String ID;
  private String name;
  public int groupId;
  public Date attendanceDate;
  public boolean isKnowDevOps;
  public boolean isKnowJavascript;
  public boolean isKnowPython;
  public boolean isKnowAWS;

  QA(String ID, String name) {
    this.ID = ID;
    this.name = name;
    System.out.println("New QA created with ID " + ID + ", name" + name);
  }

  public static void main(String[] args) {
    final QA qa1 = new QA("2129f3a8-e6cc-4a89-a107-7c21218925c3", "Jeff");
    final QA qa2 = new QA("c843c2e4-6daf-4309-b8ae-be7e1006bce7", "Michael");
    final QA qa3 = new QA("c813994d-4582-4b17-b7aa-a64170906e48", "Alex");
  }


  public void test() {

  }

  public void promote() {


  }

  public void dismiss() {


  }

}
