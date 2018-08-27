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

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Home {

    @Test
    @Parameters({"browser"})
    public void ClickFlights (@Optional String browser) {
        /*System.out.println("test before swipe");
        Utility.SwipeVerticalByCoordinates(SetUp.GetCurrentAppiumDriver(), CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);
        System.out.println("test after swipe");*/

        // Get element by text is too heavy at this point
//        Utility.ClickElementByText(SetUp.GetCurrentAppiumDriver(), ElementConstants.TEXT_FLIGHTS);

        if (browser.equalsIgnoreCase("Android")) {
            Utility.TapByCoordinates(CoordinateConstants.HOME_FLIGHT_X_NO_LOGIN, CoordinateConstants.HOME_FLIGHT_Y_NO_LOGIN);

            try {
                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                        ConfigConstants.TOOLTIP_TIMEOUT);
            } catch (Exception e) {
                Log.Debug("Tooltip is not available");
            }
        } else if (browser.equalsIgnoreCase("Firefox")) {

            // driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
            Log.Debug("Test clicking in browser");
            Utility.ClickElementByText(Handler.GetCurrentWebDriver(), "oPeSS tvat-FLIGHT", ConfigConstants.ELEMENT_TYPE_DIV_CLASS);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void ClickLoginOrRegister () {
        Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_TEXT_VIEW_LOGIN_OR_REGISTER_TITLE);
    }
}
