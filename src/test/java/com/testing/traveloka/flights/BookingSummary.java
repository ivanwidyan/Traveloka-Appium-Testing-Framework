/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.flights;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ElementConstants;
import org.testng.annotations.Test;

public class BookingSummary {

    // TODO: Work on Add Hotel in Booking Summary
    @Test (enabled = false)
    public void AddHotel() {
    }

    // TODO: Work on Add Airport Transport in Booking Summary
    @Test (enabled = false)
    public void AddAirportTransport() {
    }

    @Test
    public void Select() {
        Utility.GetElementByText(Handler.GetCurrentAppiumDriver(), ElementConstants.TEXT_FLIGHT);

        Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), ElementConstants.ID_BUTTON_SELECT);
    }
}
