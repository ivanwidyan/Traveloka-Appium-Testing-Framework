/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.logging.Log;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.CoordinateConstants;
import com.testing.traveloka.constants.ElementConstants;

import org.testng.annotations.*;

public class Home {

    @Test
    public void ClickFlights () {
        /*System.out.println("test before swipe");
        Utility.SwipeVerticalByCoordinates(SetUp.GetCurrentDriver(), CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);
        System.out.println("test after swipe");*/

        // Get element by text is too heavy at this point
//        Utility.ClickElementByText(SetUp.GetCurrentDriver(), ElementConstants.TEXT_FLIGHTS);

        Utility.TapByCoordinates(CoordinateConstants.HOME_FLIGHT_X_NO_LOGIN, CoordinateConstants.HOME_FLIGHT_Y_NO_LOGIN);

        try {
            Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                    ConfigConstants.TOOLTIP_TIMEOUT);
        } catch (Exception e) {
            Log.Debug("Tooltip is not available");
        }
    }

    @Test
    public void ClickLoginOrRegister () {
        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_LOGIN_OR_REGISTER_TITLE);
    }
}
