package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.ElementConstants;
import org.testng.annotations.*;

public class SplashScreen {

    /**
     * Choose Country & Language using parameters
     */
    @Test
    @Parameters({"country", "language"})
    public void ChooseCountryLanguage (@Optional String country, @Optional String language) {
        String countryLanguage = "";
        if (country == null || language == null)
            countryLanguage = ElementConstants.TEXT_INDONESIA_ENGLISH;
        else
            countryLanguage = country + "(" + language + ")";

        Utility.ClickElementByText(Handler.GetCurrentDriver(), countryLanguage); // -> language is already set

        Utility.ClickElementByText(Handler.GetCurrentDriver(), ElementConstants.TEXT_CONTINUE);
    }

    @Test
    public void SkipSplashScreen () {
        Utility.ClickElementByText(Handler.GetCurrentDriver(), ElementConstants.TEXT_SKIP);

        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_BUTTON_START_SEARCH);

        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_WIDGET_BUTTON_BLUE);

        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                ConfigConstants.TIMEOUT_FALSE);// -> tooltip is gone
    }
}
