package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.CoordinateConstants;
import com.testing.traveloka.constants.ElementConstants;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.*;

import java.net.URL;

public class Home {

    /**
     * Click Flight
     */
    @Test
    public void ClickFlights () {
        /*System.out.println("test before swipe");
        Utility.SwipeVerticalByCoordinate(Handler.driver, CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);
        System.out.println("test after swipe");*/

        TouchAction touchAction = new TouchAction(Handler.driver);
        touchAction.tap(PointOption.point(CoordinateConstants.HOME_FLIGHT_X, CoordinateConstants.HOME_FLIGHT_Y)).perform();
        System.out.println("Tap at coordinate x = 110 & y=505");

        try {
            Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK, ConfigConstants.TIMEOUT_FALSE);
        } catch (Exception e) {}
    }
}
