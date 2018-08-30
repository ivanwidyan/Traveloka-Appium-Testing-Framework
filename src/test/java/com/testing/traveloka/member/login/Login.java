/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.member.login;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.constants.WebElementConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

    @Test
    @Parameters({"platform", "email", "password"})
    public void LoginWithEmail(String platform, @Optional String email, @Optional String password) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (email == null) {
                email = TravelokaAndroidElementConstants.TEST_EMAIL;
            }

            if (password == null) {
                password = TravelokaAndroidElementConstants.TEST_PASSWORD;
            }

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(), WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.LOGIN_USERNAME_FIELD, email);

            Utility.SendKeysElementByCssSelector(Handler.GetCurrentWebDriver(), WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.LOGIN_PASSWORD_FIELD, password);

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(), WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.LOGIN_SUBMIT_BTN);
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "email", "password"})
    public void LoginWithFacebook(String platform, @Optional String email, @Optional String password) {

        if (email == null) {
            email = TravelokaAndroidElementConstants.TEST_EMAIL;
        }

        if (password == null) {
            password = TravelokaAndroidElementConstants.TEST_PASSWORD;
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_WIDGET_BUTTON_LOGIN_WITH_FACEBOOK);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            // TODO: How to handle Pop Up
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    @Test
    @Parameters({"platform", "email", "password"})
    public void LoginWithGoogle(String platform, @Optional String email, @Optional String password) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_WIDGET_BUTTON_LOGIN_WITH_GOOGLE);

            if (email == null) {
                email = TravelokaAndroidElementConstants.TEST_EMAIL;
            }

            if (password == null) {
                password = TravelokaAndroidElementConstants.TEST_PASSWORD;
            }

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            // TODO: How to handle Pop Up
        } else {
            throw new SkipException("Platform is not available");
        }
    }
}
