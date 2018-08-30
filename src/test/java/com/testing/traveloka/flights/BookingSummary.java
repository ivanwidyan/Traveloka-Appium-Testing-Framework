/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.flights;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookingSummary {

    // TODO: Work on Add Hotel in Booking Summary
    @Test (enabled = false)
    public void AddHotel() {
    }

    // TODO: Work on Add Airport Transport in Booking Summary
    @Test (enabled = false)
    public void AddAirportTransport() {
    }

    @Test
    @Parameters({"platform"})
    public void Select(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.GetElementByXPath(Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_FLIGHT);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_BUTTON_SELECT);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.PREBOOK_CONFIRM_BUTTON);

        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
