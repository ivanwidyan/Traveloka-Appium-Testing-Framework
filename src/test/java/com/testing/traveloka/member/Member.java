/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.member;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ElementConstants;
import org.testng.annotations.Test;

public class Member {

    @Test
    public void Login() {
        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_LOGIN_BUTTON);
    }

    @Test
    public void Register() {
        Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_REGISTER_BUTTON);
    }
}
