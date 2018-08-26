package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.CoordinateConstants;
import com.testing.traveloka.constants.ElementConstants;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.*;

public class Home {

    @Test
    public void ClickFlights () {
        /*System.out.println("test before swipe");
        Utility.SwipeVerticalByCoordinate(SetUp.GetCurrentDriver(), CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);
        System.out.println("test after swipe");*/

        // Get element by text is too heavy at this point
//        Utility.ClickElementByText(SetUp.GetCurrentDriver(), ElementConstants.TEXT_FLIGHTS);

        // TODO: Encapsulate this into Utility
        TouchAction touchAction = new TouchAction(Handler.GetCurrentDriver());
        touchAction.tap(PointOption.point(CoordinateConstants.HOME_FLIGHT_X, CoordinateConstants.HOME_FLIGHT_Y)).perform();

        try {
            Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK, ConfigConstants.TIMEOUT_FALSE);
        } catch (Exception e) {}
    }

    @Test
    public void ClickLoginOrRegister () {
        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_LOGIN_OR_REGISTER_TITLE);
    }
}
