/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.logging.Log;
import com.testing.traveloka.constants.TravelokaConfigConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import org.testng.SkipException;
import org.testng.annotations.*;

public class SplashScreen {

    @Test
    @Parameters({"platform", "country", "language"})
    public void ChooseCountryLanguage (String platform, @Optional String country, @Optional String language) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            String countryLanguage;
            if (country == null || language == null)
                countryLanguage = TravelokaAndroidElementConstants.TEXT_INDONESIA_ENGLISH;
            else
                countryLanguage = country + "(" + language + ")";

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT, countryLanguage); // -> language is already set

            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_CONTINUE);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void SkipSplashScreen (String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                    AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                    AndroidElementConstants.PARAM_TEXT, TravelokaAndroidElementConstants.TEXT_SKIP);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_BUTTON_START_SEARCH);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_WIDGET_BUTTON_BLUE);

            try {
                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                        TravelokaConfigConstants.TOOLTIP_TIMEOUT);
            } catch (Exception e) {
                Log.Debug("Tooltip is not available");
            }
        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
