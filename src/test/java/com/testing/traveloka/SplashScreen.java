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
import com.testing.traveloka.constants.ElementConstants;
import org.testng.annotations.*;

public class SplashScreen {

    @Test
    @Parameters({"country", "language"})
    public void ChooseCountryLanguage (@Optional String country, @Optional String language) {
        String countryLanguage;
        if (country == null || language == null)
            countryLanguage = ElementConstants.TEXT_INDONESIA_ENGLISH;
        else
            countryLanguage = country + "(" + language + ")";

        Utility.ClickElementByText(Handler.GetCurrentAppiumDriver(), countryLanguage); // -> language is already set

        Utility.ClickElementByText(Handler.GetCurrentAppiumDriver(), ElementConstants.TEXT_CONTINUE);
    }

    @Test
    public void SkipSplashScreen () {
        Utility.ClickElementByText(Handler.GetCurrentAppiumDriver(), ElementConstants.TEXT_SKIP);

        Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_BUTTON_START_SEARCH);

        Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_WIDGET_BUTTON_BLUE);

        try {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                    ConfigConstants.TOOLTIP_TIMEOUT);
        } catch (Exception e) {
            Log.Debug("Tooltip is not available");
        }
    }
}
