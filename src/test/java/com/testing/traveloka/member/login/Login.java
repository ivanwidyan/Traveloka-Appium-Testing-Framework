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
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
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

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform", "email", "password"})
    public void LoginWithFacebook(String platform, @Optional String email, @Optional String password) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_WIDGET_BUTTON_LOGIN_WITH_FACEBOOK);

            if (email == null) {
                email = TravelokaAndroidElementConstants.TEST_EMAIL;
            }

            if (password == null) {
                password = TravelokaAndroidElementConstants.TEST_PASSWORD;
            }

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

            Utility.SendKeysElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
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
        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
