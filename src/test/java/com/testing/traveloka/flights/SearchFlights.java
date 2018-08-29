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
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.logging.Log;
import com.testing.traveloka.constants.TravelokaConfigConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFlights {

    @Test
    @Parameters({"platform", "input"})
    public void SetOrigin(String platform, @Optional String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (input != null) {
                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                        AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                        AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_ORIGIN);

                Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                        TravelokaAndroidElementConstants.ID_TEXT_SEARCH_CONSTRAINTS, input);

                List<WebElement> origin = Utility.ClickElementsById(Handler.GetCurrentAppiumDriver(),
                        TravelokaAndroidElementConstants.ID_TEXT_VIEW_GEO_NAME, Constants.FIRST_INDEX);

                if (origin == null) {
                    Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_DIALOG_CLOSE);
                    Log.Debug("Origin not found");
                }
            } else {
                System.out.println("setOrigin doesn't have input");
            }
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            WebElement flightSource = Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.VALUE_FLIGHT_SOURCE, input);

            Utility.ClickElementsByXpath(Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_DIV, WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.VALUE_SUGGESTION_ITEM,
                    Constants.SECOND_INDEX);
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void SetDestination(String platform, @Optional String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (input != null) {
                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                        AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                        AndroidElementConstants.PARAM_TEXT,
                        TravelokaAndroidElementConstants.TEXT_DESTINATION);

                Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                        TravelokaAndroidElementConstants.ID_TEXT_SEARCH_CONSTRAINTS, input);

                List<WebElement> origin = Utility.ClickElementsById(Handler.GetCurrentAppiumDriver(),
                        TravelokaAndroidElementConstants.ID_TEXT_VIEW_GEO_NAME, Constants.FIRST_INDEX);

                if (origin == null) {
                    Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_DIALOG_CLOSE);
                    System.out.println("Destination not found");
                }
            } else {
                System.out.println("setDestination doesn't have input");
            }
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.VALUE_FLIGHT_DESTINATION, input);

            List<WebElement> origin = Utility.ClickElementsByXpath(Handler.GetCurrentWebDriver(),
                    WebElementConstants.CLASS_DIV, WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.VALUE_SUGGESTION_ITEM,
                    Constants.SECOND_INDEX);
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "date", "month", "year"})
    public void SetDepartureDate(String platform, @Optional String date, @Optional String month, @Optional String year) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (date != null) {
                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_DEPARTURE_DATE);

                try {
                    Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                            TravelokaConfigConstants.TOOLTIP_TIMEOUT);
                } catch (Exception e) {
                    Log.Debug("Tooltip is not available");
                }

                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, date);
            } else {
                System.out.println("SetDepartureDate doesn't have date input");
            }
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test (enabled = false)
    @Parameters({"platform", "adult", "child", "infant"})
    public void SetPassenger(String platform, @Optional String adult, @Optional String child, @Optional String infant) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (adult != null || child != null || infant != null) {
                // TODO: Create swipe function with sensitivity
                // Here are the code to swipe based on the input
            } else {
                System.out.println("SetDepartureDate doesn't have date input");
            }
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform", "input"})
    public void SetSeatClass(String platform, @Optional String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (input != null) {
                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_SEAT_CLASS);

                if (TravelokaAndroidElementConstants.TEXT_ECONOMY.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_BUSINESS.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_FIRST_CLASS.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_PREMIUM_ECONOMY.equalsIgnoreCase(input)) {
                    Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, input);
                } else {
                    System.out.println("Seat Class: " + input + " is not available");
                }

                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_WIDGET_BUTTON_ACCEPT);
            } else {
                System.out.println("SetDepartureDate doesn't have date input");
            }
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void SwapOriginAndDestination(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_BUTTON_VIEW_SWAP);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.VALUE_AIRPORT_SWITCH_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void ReturnSwitch(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_RETURN_SWITCH);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test(dependsOnMethods = {"ReturnSwitch"})
    @Parameters({"platform", "date", "month", "year"})
    public void SetReturnDate(String platform, @Optional String date, @Optional String month, @Optional String year) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (date != null) {
                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_RETURN_DATE);

                try {
                    Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                            TravelokaConfigConstants.TOOLTIP_TIMEOUT);
                } catch (Exception e) {
                    Log.Debug("Tooltip is not available");
                }

                Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, date);

                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_TOOLTIP_ACTION);
            } else {
                System.out.println("SetReturnDate doesn't have date input");
            }
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void SearchFlights(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_BUTTON_CHOOSE_FLIGHT);
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.VALUE_SEARCH_FLIGHT_SUBMIT);
        } else {
            throw new SkipException("Platform is not available");
        }
    }
}
