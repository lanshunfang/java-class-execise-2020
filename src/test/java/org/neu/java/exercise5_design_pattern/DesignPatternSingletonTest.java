package org.neu.java.exercise5_design_pattern;

import org.junit.*;
import static org.junit.Assert.*;

public class DesignPatternSingletonTest {

    @Test
    public void getInstance_WhenNew_AllInstanceShouldBeTheSame() {

        DesignPatternSingleton DesignPatternSingleton = new DesignPatternSingleton();

        DesignPatternSingleton.Service singletonA = DesignPatternSingleton.getInstance();
        DesignPatternSingleton.Service singletonB = DesignPatternSingleton.getInstance();

        System.out.println("Is singletonA the same as singletonB? " + (singletonA == singletonB));
        System.out.println("Is singletonA call count incremented? " + (singletonA.getCallCount() == 2));

    }
}
