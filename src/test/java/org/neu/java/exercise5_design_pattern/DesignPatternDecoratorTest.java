package org.neu.java.exercise5_design_pattern;

import org.junit.*;
import static org.junit.Assert.*;

public class DesignPatternDecoratorTest {


    @Test
    public void getRate_AllStatesShouldOfferTaxRate_ReturnRate() {

        DesignPatternDecorator designPatternDecorator = new DesignPatternDecorator();
        assertEquals(
                "All states should return tax rate greater than 5",
                true,
                designPatternDecorator.californiaTax.getRate() > 5
                && designPatternDecorator.newHampshireTax.getRate() > 5
        );

        assertNotEquals(
                "All states should not return same tax rate",
                designPatternDecorator.californiaTax.getRate(),
                designPatternDecorator.newHampshireTax.getRate()
        );

    }
}
