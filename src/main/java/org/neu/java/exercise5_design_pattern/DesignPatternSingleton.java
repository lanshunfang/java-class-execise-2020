package org.neu.java.exercise5_design_pattern;

public class DesignPatternSingleton {

    private static Service inst;

    static class Service {
        private int callCount;

        private void addCallCount() {
            callCount++;

        }

        public int getCallCount() {
            return callCount;
        }
    }

    static Service getInstance() {

        if (inst == null) {
            inst = new Service();
        }

        inst.addCallCount();

        return inst;
    }

    public static void main(String[] args) {

        Service singletonA = getInstance();
        Service singletonB = getInstance();

        System.out.println("Is singletonA the same as singletonB? " + (singletonA == singletonB));
        System.out.println("Is singletonA call count incremented? " + (singletonA.callCount == 2));

    }
}
