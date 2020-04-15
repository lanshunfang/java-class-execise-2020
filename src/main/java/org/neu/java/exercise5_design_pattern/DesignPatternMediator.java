package org.neu.java.exercise5_design_pattern;

public class DesignPatternMediator {

    enum LocationEnum {
        Home,
        Office
    }

    class Mediator {
        void arriveHome() {
            smartLight.turnOn();
            inDoorThiefAlarm.dismiss();
        }
    }

    class Cellphone {

        void locationAt(LocationEnum locationEnum) {
            System.out.println(
                    String.format(
                            "Cellphone GPS Location is %s",
                            locationEnum
                    )
            );
            if (locationEnum == LocationEnum.Home) {
                mediator.arriveHome();
            }
        }
    }

    class SmartLight {
        boolean isOn;

        void turnOn() {
            isOn = true;
            System.out.println("Light is on");
        }

        void turnOff() {
            isOn = false;
            System.out.println("Light is on");
        }
    }

    class InDoorThiefAlarm {
        boolean isAlarmOn;

        void start() {
            isAlarmOn = true;
            System.out.println("Alert is on");
        }

        void dismiss() {
            isAlarmOn = false;
            System.out.println("Thief Alarm is off");
        }
    }

    Mediator mediator = new Mediator();
    Cellphone cellphone = new Cellphone();
    SmartLight smartLight = new SmartLight();
    InDoorThiefAlarm inDoorThiefAlarm = new InDoorThiefAlarm();

    public static void main(String[] args) {

        DesignPatternMediator designPatternMediator = new DesignPatternMediator();

        designPatternMediator.cellphone.locationAt(LocationEnum.Home);
        designPatternMediator.cellphone.locationAt(LocationEnum.Office);

    }
}
