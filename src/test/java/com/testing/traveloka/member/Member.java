/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.member;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.ConfigConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Member {

    @Test
    @Parameters({"platform"})
    public void Login(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_LOGIN_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void Register(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_REGISTER_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }
}
