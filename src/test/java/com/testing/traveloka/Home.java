/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaConfigConstants;
import com.testing.traveloka.constants.TravelokaCoordinateConstants;

import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Home {

    @Test
    @Parameters({"platform"})
    public void ClickFlights (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.TapByCoordinates(TravelokaCoordinateConstants.HOME_FLIGHT_X_NO_LOGIN, TravelokaCoordinateConstants.HOME_FLIGHT_Y_NO_LOGIN);

            try {
                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                        TravelokaConfigConstants.TOOLTIP_TIMEOUT);
            } catch (Exception e) {
                Log.Debug("Tooltip is not available");
            }
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            /*Utility.ClickElementByXPath(Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_DIV,
                    WebElementConstants.PARAM_CLASS, TravelokaWebElementConstants.HOME_FLIGHTS_NOT_CLICKED);*/

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(), WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.HOME_FLIGHTS_NOT_CLICKED);

            /*Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(), WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.HOME_FLIGHTS_CLICKED);*/
        } else {
            throw new SkipException("Platform is not available for test");
        }
    }

    @Test
    @Parameters({"platform"})
    public void ClickLoginOrRegister (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_LOGIN_OR_REGISTER_TITLE);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
