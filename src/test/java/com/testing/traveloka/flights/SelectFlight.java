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

public class SelectFlight {

    @Test
    @Parameters({"input"})
    public void SortBy(@Optional String input) {
        if (input != null) {
            Utility.GetElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_FLIGHT_NAME);

            Utility.ClickElementById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_SORT);

            if (ElementConstants.TEXT_LOWEST_PRICE.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_EARLIEST_DEPARTURE.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_LATEST_DEPARTURE.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_EARLIEST_ARRIVAL.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_LATEST_ARRIVAL.equalsIgnoreCase(input)
                    || ElementConstants.TEXT_SHORTEST_DURATION.equalsIgnoreCase(input)) {

                Utility.ClickElementByText(Handler.GetCurrentDriver(), input);
            } else {
                System.out.println("Flight Sort By: " + input + " is not available");
            }
        } else {
            System.out.println("SortBy doesn't have date input");
        }
    }

    // TODO: Work on Set Filter for Flight
    @Test (enabled = false)
    @Parameters({"input"})
    public void SetFilter(@Optional String input) {

    }

    @Test
    @Parameters({"input"})
    public void SelectFlight(@Optional String input) {
        int index = ConfigConstants.FIRST_INDEX;
        if (input != null) {
            index = Integer.parseInt(input);
        }

        Utility.ClickElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_FLIGHT_NAME, index);
    }

    @Test
    public void PrintFlight() {
        PrintFlightInformation(Utility.GetElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_FLIGHT_NAME),
                Utility.GetElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_FLIGHT_TIME),
                Utility.GetElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_INFORMATION),
                Utility.GetElementsById(Handler.GetCurrentDriver(), ElementConstants.ID_TEXT_VIEW_REDUCED_PRICE));
    }

    private void PrintFlightInformation (List<WebElement> listFlights, List<WebElement> listTimes,
                                               List<WebElement> listInfo, List<WebElement> listPrices) {
        System.out.println("###################################");
        for (int i = 0; i < listPrices.size(); i++) {
            System.out.println("Flight: " + listFlights.get(i).getText());
            System.out.println("Time: " + listTimes.get(i).getText());
            System.out.println("Info: " + listInfo.get(i).getText());
            System.out.println("Price: " + listPrices.get(i).getText());
        }
    }
}
