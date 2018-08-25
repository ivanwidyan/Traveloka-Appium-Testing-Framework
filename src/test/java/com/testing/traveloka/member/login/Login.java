/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.member.login;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ElementConstants;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

    @Test
    @Parameters({"email", "password"})
    public void LoginWithEmail(@Optional String email, @Optional String password) {
        if (email == null) {
            email = ElementConstants.TEST_EMAIL;
        }

        if (password == null) {
            password = ElementConstants.TEST_PASSWORD;
        }

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_LOGIN_BUTTON);
    }

    @Test
    @Parameters({"email", "password"})
    public void LoginWithFacebook(@Optional String email, @Optional String password) {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_WIDGET_BUTTON_LOGIN_WITH_FACEBOOK);

        if (email == null) {
            email = ElementConstants.TEST_EMAIL;
        }

        if (password == null) {
            password = ElementConstants.TEST_PASSWORD;
        }

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_LOGIN_BUTTON);
    }

    @Test
    @Parameters({"email", "password"})
    public void LoginWithGoogle(@Optional String email, @Optional String password) {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_WIDGET_BUTTON_LOGIN_WITH_GOOGLE);

        if (email == null) {
            email = ElementConstants.TEST_EMAIL;
        }

        if (password == null) {
            password = ElementConstants.TEST_PASSWORD;
        }

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_TEXT_EMAIL, email);

        Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_INFORMATION_FIELD_PASSWORD_WIDGET, password);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_LOGIN_BUTTON);
    }
}
