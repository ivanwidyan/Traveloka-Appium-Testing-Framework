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
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaConfigConstants;
import com.testing.traveloka.constants.TravelokaCoordinateConstants;
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

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.GetElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_CONTACT_DETAILS);

            Utility.SwipeVerticalByCoordinates(Handler.GetCurrentAppiumDriver(), TravelokaCoordinateConstants.FILL_IN_DETAILS_START_Y
                    , TravelokaCoordinateConstants.FILL_IN_DETAILS_END_Y, TravelokaCoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_FILL_IN_CONTACT_DETAILS);

            List<WebElement> textBox = Utility.GetElementsByClass(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT);

            if (fullname == null)
                fullname = TravelokaConfigConstants.DEFAULT_FULLNAME;
            textBox.get(FULLNAME_TEXTBOX_INDEX).sendKeys(fullname);

            if (countrycode != null)
                textBox.get(COUNTRYCODE_TEXTBOX_INDEX).sendKeys(countrycode);

            if (mobilenumber == null)
                mobilenumber = TravelokaConfigConstants.DEFAULT_MOBILENUMBER;
            textBox.get(MOBILENUMBER_TEXTBOX_INDEX).sendKeys(mobilenumber);

            if (email == null)
                email = TravelokaConfigConstants.DEFAULT_EMAIL;
            String emailEnter = email + Constants.ENTER;
            textBox.get(EMAIL_TEXTBOX_INDEX).sendKeys(emailEnter);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_BUTTON_SAVE);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform", "traveler", "title", "fullname"})
    public void TravelerDetails (String platform, String traveler, @Optional String title, @Optional String fullname) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.GetElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_CONTACT_DETAILS);

            Utility.SwipeVerticalByCoordinates(Handler.GetCurrentAppiumDriver(), TravelokaCoordinateConstants.FILL_IN_DETAILS_START_Y
                    , TravelokaCoordinateConstants.FILL_IN_DETAILS_END_Y, TravelokaCoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, traveler);

            Utility.ClickElementByClassName(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_SPINNER);

            if (title == null) {
                title = TravelokaConfigConstants.DEFAULT_TITLE;
            }
            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(), AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW, AndroidElementConstants.PARAM_TEXT, title);

            if (fullname == null) {
                fullname = TravelokaConfigConstants.DEFAULT_FULLNAME;
            }
            Utility.SendKeysElementByClassName(Handler.GetCurrentAppiumDriver()
                    , TravelokaAndroidElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT, fullname);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_BUTTON_SAVE);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test(dependsOnMethods = {"FillInContactDetails", "TravelerDetails"})
    @Parameters({"platform"})
    public void Continue (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_SEE_BELOW_VIEW);

        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
