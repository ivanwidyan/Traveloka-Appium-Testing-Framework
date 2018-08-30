/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.flights.fillindetails;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaConfigConstants;
import com.testing.traveloka.constants.TravelokaCoordinateConstants;
import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Book {

    private final static int FULLNAME_TEXTBOX_INDEX = 0;
    private final static int COUNTRYCODE_TEXTBOX_INDEX = 1;
    private final static int MOBILENUMBER_TEXTBOX_INDEX = 2;
    private final static int EMAIL_TEXTBOX_INDEX = 3;

    @Test
    @Parameters({"platform", "fullname", "countrycode", "mobilenumber", "email"})
    public void FillInContactDetails (String platform, @Optional String fullname, @Optional String countrycode,
                                      @Optional String mobilenumber, @Optional String email) {

        if (fullname == null)
            fullname = TravelokaConfigConstants.DEFAULT_FULLNAME;

        if (mobilenumber == null)
            mobilenumber = TravelokaConfigConstants.DEFAULT_MOBILENUMBER;

        if (email == null)
            email = TravelokaConfigConstants.DEFAULT_EMAIL;

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.GetElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_CONTACT_DETAILS);

            Utility.SwipeVerticalByCoordinates(Handler.GetCurrentAppiumDriver(), TravelokaCoordinateConstants.FILL_IN_DETAILS_START_Y
                    , TravelokaCoordinateConstants.FILL_IN_DETAILS_END_Y, TravelokaCoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_FILL_IN_CONTACT_DETAILS);

            List<WebElement> textBox = Utility.GetElementsByClass(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT);

            textBox.get(FULLNAME_TEXTBOX_INDEX).sendKeys(fullname);

            // TODO: Work on Country code on android
            /*if (countrycode != null)
                textBox.get(COUNTRYCODE_TEXTBOX_INDEX).sendKeys(countrycode);*/

            textBox.get(MOBILENUMBER_TEXTBOX_INDEX).sendKeys(mobilenumber);

            String emailEnter = email + Constants.ENTER;
            textBox.get(EMAIL_TEXTBOX_INDEX).sendKeys(emailEnter);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_BUTTON_SAVE);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            List<WebElement> fieldNames = Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_FULL_NAME);


            fieldNames.get(Constants.FIRST_INDEX).sendKeys(fullname);

            // TODO: Work on Country code on web
            /*if (countrycode != null)
                textBox.get(COUNTRYCODE_TEXTBOX_INDEX).sendKeys(countrycode);*/

            Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_PHONE_NUMBER,
                    mobilenumber);

            Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_EMAIL_ADDRESS,
                    email);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "traveler", "title", "fullname"})
    public void TravelerDetails (String platform, @Optional String traveler,
                                 @Optional String title, @Optional String fullname) {

        if (fullname == null) {
            fullname = TravelokaConfigConstants.DEFAULT_FULLNAME;
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.GetElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_CONTACT_DETAILS);

            Utility.SwipeVerticalByCoordinates(Handler.GetCurrentAppiumDriver(), TravelokaCoordinateConstants.FILL_IN_DETAILS_START_Y
                    , TravelokaCoordinateConstants.FILL_IN_DETAILS_END_Y, TravelokaCoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, traveler);

            Utility.ClickElementByClassName(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_SPINNER);

            if (title == null) {
                title = TravelokaConfigConstants.ANDROID_DEFAULT_TITLE;
            }
            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, title);

            Utility.SendKeysElementByClassName(Handler.GetCurrentAppiumDriver()
                    , TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT, fullname);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_BUTTON_SAVE);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            List<WebElement> fieldNames = Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_FULL_NAME);

            fieldNames.get(Constants.SECOND_INDEX).sendKeys(fullname);

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_TITLE);

            if (title == null) {
                title = TravelokaConfigConstants.WEB_DEFAULT_TITLE;
            }
            String setTitle = TravelokaWebElementConstants.BOOK_TITLE +
                    "-" + title;

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    setTitle);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test(dependsOnMethods = {"FillInContactDetails", "TravelerDetails"})
    @Parameters({"platform"})
    public void Continue (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_TEXT_VIEW_SEE_BELOW_VIEW);

        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.BOOK_CONTINUE);

        } else {
            throw new SkipException("Platform is not available");
        }
    }
}
