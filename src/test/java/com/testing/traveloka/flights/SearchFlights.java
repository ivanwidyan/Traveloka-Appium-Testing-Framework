package com.testing.traveloka.flights;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.ElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFlights {

    @Test
    @Parameters({"input"})
    public void SetOrigin(@Optional String input) {
        if (input != null) {
            Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_ORIGIN);

            Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_TEXT_SEARCH_CONSTRAINTS, input);

            List<WebElement> origin = Utility.ClickElementsById(Handler.driver, ElementConstants.ID_TEXT_VIEW_GEO_NAME, ConfigConstants.FIRST_INDEX);

            if (origin == null) {
                Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_DIALOG_CLOSE);
                System.out.println("Origin not found");
            }
        } else {
            System.out.println("setOrigin doesn't have input");
        }
    }

    @Test
    @Parameters({"input"})
    public void SetDestination(@Optional String input) {
        if (input != null) {
            Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_DESTINATION);

            Utility.SendKeysElementById(Handler.driver, ElementConstants.ID_TEXT_SEARCH_CONSTRAINTS, input);

            List<WebElement> origin = Utility.ClickElementsById(Handler.driver,
                    ElementConstants.ID_TEXT_VIEW_GEO_NAME, ConfigConstants.FIRST_INDEX);

            if (origin == null) {
                Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_DIALOG_CLOSE);
                System.out.println("Destination not found");
            }
        } else {
            System.out.println("setDestination doesn't have input");
        }
    }

    @Test
    @Parameters({"date", "month", "year"})
    public void SetDepartureDate(@Optional String date, @Optional String month, @Optional String year) {
        if (date != null) {
            Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_DEPARTURE_DATE);

            try {
                Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK, ConfigConstants.TIMEOUT_FALSE);
            } catch (Exception e) {}

            Utility.ClickElementByText(Handler.driver, date);
        } else {
            System.out.println("SetDepartureDate doesn't have date input");
        }
    }

    // TODO: Create swipe function with sensitivity
    @Test (enabled = false)
    @Parameters({"adult", "child", "infant"})
    public void SetPassenger(@Optional String adult, @Optional String child, @Optional String infant) {
        if (adult != null || child != null || infant != null) {
            // Here are the code to swipe based on the input
        } else {
            System.out.println("SetDepartureDate doesn't have date input");
        }
    }

    @Test
    @Parameters({"input"})
    public void SetSeatClass(@Optional String input) {
        if (input != null) {
            Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_SEAT_CLASS);

            if (ElementConstants.TEXT_ECONOMY.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_BUSINESS.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_FIRST_CLASS.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_PREMIUM_ECONOMY.equalsIgnoreCase(input)) {
                Utility.ClickElementByText(Handler.driver, input);
            } else {
                System.out.println("Seat Class: " + input + " is not available");
            }

            Utility.ClickElementById(Handler.driver, ElementConstants.ID_WIDGET_BUTTON_ACCEPT);
        } else {
            System.out.println("SetDepartureDate doesn't have date input");
        }
    }

    @Test
    public void SwapOriginAndDestination() {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_VIEW_SWAP);
    }

    @Test
    public void ReturnSwitch() {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_RETURN_SWITCH);
    }

    @Test(dependsOnMethods = {"ReturnSwitch"})
    @Parameters({"date", "month", "year"})
    public void SetReturnDate(@Optional String date, @Optional String month, @Optional String year) {
        if (date != null) {
            Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_RETURN_DATE);

            try {
                Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK, ConfigConstants.TIMEOUT_FALSE);
            } catch (Exception e) {}

            Utility.ClickElementByText(Handler.driver, date);

            Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_TOOLTIP_ACTION);
        } else {
            System.out.println("SetReturnDate doesn't have date input");
        }
    }

    @Test
    public void SearchFlights() {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_CHOOSE_FLIGHT);
    }
}
