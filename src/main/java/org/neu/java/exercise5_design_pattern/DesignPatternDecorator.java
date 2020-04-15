package org.neu.java.exercise5_design_pattern;

public class DesignPatternDecorator {

    interface  Tax {
        double getRate();
    }

    class CaliforniaTax implements Tax {
        @Override
        public double getRate() {
            return 9.55;
        }
    }
    class NewHampshireTax implements Tax {
        @Override
        public double getRate() {
            return 5.50;
        }
    }
    CaliforniaTax californiaTax = new CaliforniaTax();
    NewHampshireTax newHampshireTax = new NewHampshireTax();


    public static void main(String[] args) {
        DesignPatternDecorator designPatternDecorator = new DesignPatternDecorator();
        System.out.println(String.format("California tax rate: %.2f", designPatternDecorator.californiaTax.getRate()));
        System.out.println(String.format("New Hampshire tax rate: %.2f", designPatternDecorator.newHampshireTax.getRate()));

    }
}
