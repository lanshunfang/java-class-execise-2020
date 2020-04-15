package org.neu.java.exercise5_design_pattern;

import org.junit.*;
import static org.junit.Assert.*;

public class DesignPatternMediatorTest {

    @Test
    public void locationAt_WhenCellPhoneGPSReportHome_UtilityReact() {

        DesignPatternMediator designPatternMediator = new DesignPatternMediator();

        designPatternMediator.cellphone.locationAt(DesignPatternMediator.LocationEnum.Home);

        assertEquals(designPatternMediator.inDoorThiefAlarm.isAlarmOn, false);
        assertEquals(designPatternMediator.smartLight.isOn, true);

    }
}
