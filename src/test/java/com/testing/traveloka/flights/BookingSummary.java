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
        Utility.GetElementByText(Handler.driver, ElementConstants.TEXT_FLIGHT);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_SELECT);
    }
}
