/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka.flights;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.AndroidElementConstants;
import com.testing.constants.ConfigConstants;
import com.testing.constants.Constants;
import com.testing.constants.WebElementConstants;
import com.testing.traveloka.constants.TravelokaAndroidElementConstants;
import com.testing.traveloka.constants.TravelokaWebElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SelectFlight {

    private final static int SORT_BY_LOWEST_PRICE_INDEX = 0;
    private final static int SORT_BY_EARLIEST_DEPARTURE_INDEX = 1;
    private final static int SORT_BY_LATEST_DEPARTURE_INDEX = 2;
    private final static int SORT_BY_EARLIEST_ARRIVAL_INDEX = 3;
    private final static int SORT_BY_LATEST_ARRIVAL_INDEX = 4;
    private final static int SORT_BY_SHORTEST_DURATION_INDEX = 5;
    
    @Test
    @Parameters({"platform", "input"})
    public void SortBy(String platform, @Optional String input) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            if (input != null) {
                Utility.GetElementsById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_FLIGHT_NAME);

                Utility.ClickElementById(Handler.GetCurrentAppiumDriver(), TravelokaAndroidElementConstants.ID_TEXT_VIEW_SORT);

                if (TravelokaAndroidElementConstants.TEXT_LOWEST_PRICE.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_EARLIEST_DEPARTURE.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_LATEST_DEPARTURE.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_EARLIEST_ARRIVAL.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_LATEST_ARRIVAL.equalsIgnoreCase(input)
                        || TravelokaAndroidElementConstants.TEXT_SHORTEST_DURATION.equalsIgnoreCase(input)) {

                    Utility.ClickElementByXPath(Handler.GetCurrentAppiumDriver(),
                            AndroidElementConstants.CLASS_ANDROID_WIDGET_TEXTVIEW,
                            AndroidElementConstants.PARAM_TEXT,input);
                } else {
                    System.out.println("Flight Sort By: " + input + " is not available");
                }
            } else {
                System.out.println("SortBy doesn't have date input");
            }
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            int sortByIndex = Constants.FIRST_INDEX;
            if (TravelokaAndroidElementConstants.TEXT_LOWEST_PRICE.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_LOWEST_PRICE_INDEX;
            else if (TravelokaAndroidElementConstants.TEXT_EARLIEST_DEPARTURE.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_EARLIEST_DEPARTURE_INDEX;
            else if (TravelokaAndroidElementConstants.TEXT_LATEST_DEPARTURE.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_LATEST_DEPARTURE_INDEX;
            else if (TravelokaAndroidElementConstants.TEXT_EARLIEST_ARRIVAL.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_EARLIEST_ARRIVAL_INDEX;
            else if (TravelokaAndroidElementConstants.TEXT_LATEST_ARRIVAL.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_LATEST_ARRIVAL_INDEX;
            else if (TravelokaAndroidElementConstants.TEXT_SHORTEST_DURATION.equalsIgnoreCase(input))
                sortByIndex = SORT_BY_SHORTEST_DURATION_INDEX;
            else
                System.out.println("Flight Sort By: " + input + " is not available");

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.FLIGHT_FILTER_MENU_SORT);

            Utility.ClickElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.FLIGHT_SORT_BY_INDEX, sortByIndex);

            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.FLIGHT_FILTER_MENU_SORT);

        } else {
            throw new SkipException("Platform is not available");
        }
    }

    // TODO: Work on Set Filter for Flight
    @Test (enabled = false)
    @Parameters({"platform", "input"})
    public void SetFilter(@Optional String input) {

    }

    @Test
    @Parameters({"platform", "input"})
    public void SelectFlight(String platform, @Optional String input) {
        int index = Constants.FIRST_INDEX;
        if (input != null) {
            index = Integer.parseInt(input);
        }

        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            Utility.ClickElementsById(Handler.GetCurrentAppiumDriver(),
                    TravelokaAndroidElementConstants.ID_TEXT_VIEW_FLIGHT_NAME, index);
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {
            Utility.ClickElementByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.FLIGHT_SUBMIT_BUTTON);
        } else {
            throw new SkipException("This test only for Android!");
        }
    }

    @Test
    @Parameters({"platform"})
    public void PrintFlight(String platform) {
        if (ConfigConstants.PLATFORM_ANDROID.equalsIgnoreCase(platform)) {
            PrintFlightInformation(
                    Utility.GetElementsById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_FLIGHT_NAME),
                    Utility.GetElementsById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_FLIGHT_TIME),
                    Utility.GetElementsById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_INFORMATION),
                    Utility.GetElementsById(Handler.GetCurrentAppiumDriver(),
                            TravelokaAndroidElementConstants.ID_TEXT_VIEW_REDUCED_PRICE));
        } else if (ConfigConstants.PLATFORM_WEB.equalsIgnoreCase(platform)) {

            PrintFlightInformation (Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_CLASS,
                    TravelokaWebElementConstants.FLIGHT_ALL_INFORMATION),
                    Utility.GetElementsByCssSelector(Handler.GetCurrentWebDriver(),
                    WebElementConstants.PARAM_DATA_ID,
                    TravelokaWebElementConstants.FLIGHT_PRICE_NOW));
        } else {
            throw new SkipException("Platform is not available");
        }
    }

    private void PrintFlightInformation (List<WebElement> listFlightsInformation,
                                         List<WebElement> listPrices) {

        int listFlightInfoSize = 4;
        int listPricesSize = listPrices.size();
        System.out.println("###################################");
        for (int i = 0; i < listPricesSize; i++) {
            System.out.println("Flight: " + listFlightsInformation.get((i * listFlightInfoSize)).getText());
            System.out.println("Time: " + listFlightsInformation.get(1 + (i * listFlightInfoSize)).getText()
                    + " - " + listFlightsInformation.get(2 + (i * listFlightInfoSize)).getText());
            System.out.println("Info: " + listFlightsInformation.get(3 + (i * listFlightInfoSize)).getText());

            System.out.println("Price: " + listPrices.get(i).getText());
        }
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
