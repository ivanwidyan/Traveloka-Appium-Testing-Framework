package com.testing.traveloka.flights.fillindetails;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.CoordinateConstants;
import com.testing.traveloka.constants.ElementConstants;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Book {

    private final static int FULLNAME_TEXTBOX_INDEX = 0;
    private final static int COUNTRYCODE_TEXTBOX_INDEX = 1;
    private final static int MOBILENUMBER_TEXTBOX_INDEX = 2;
    private final static int EMAIL_TEXTBOX_INDEX = 3;

    @Test
    @Parameters({"fullname", "countrycode", "mobilenumber", "email"})
    public void FillInContactDetails (@Optional String fullname, @Optional String countrycode,
                                      @Optional String mobilenumber, @Optional String email) {

        Utility.GetElementByText(Handler.driver, ElementConstants.TEXT_CONTACT_DETAILS);

        Utility.SwipeVerticalByCoordinate(Handler.driver, CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

        Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_FILL_IN_CONTACT_DETAILS);

        List<WebElement> textBox = Utility.GetElementsByClass(Handler.driver, ElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT);

        if (fullname == null)
            fullname = ConfigConstants.DEFAULT_FULLNAME;
        textBox.get(FULLNAME_TEXTBOX_INDEX).sendKeys(fullname);

        if (countrycode != null)
            textBox.get(COUNTRYCODE_TEXTBOX_INDEX).sendKeys(countrycode);

        if (mobilenumber == null)
            mobilenumber = ConfigConstants.DEFAULT_MOBILENUMBER;
        textBox.get(MOBILENUMBER_TEXTBOX_INDEX).sendKeys(mobilenumber);

        if (email == null)
            email = ConfigConstants.DEFAULT_EMAIL;
        String emailEnter = email + ConfigConstants.ENTER;
        textBox.get(EMAIL_TEXTBOX_INDEX).sendKeys(emailEnter);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_SAVE);
    }

    @Test
    @Parameters({"traveler", "title", "fullname"})
    public void TravelerDetails (String traveler, @Optional String title, @Optional String fullname) {

        Utility.GetElementByText(Handler.driver, ElementConstants.TEXT_CONTACT_DETAILS);

        Utility.SwipeVerticalByCoordinate(Handler.driver, CoordinateConstants.FILL_IN_DETAILS_START_Y
                , CoordinateConstants.FILL_IN_DETAILS_END_Y, CoordinateConstants.FILL_IN_DETAILS_ANCHOR_X);

        Utility.ClickElementByText(Handler.driver, traveler);

        Utility.ClickElementByClassName(Handler.driver, ElementConstants.CLASS_ANDROID_WIDGET_SPINNER);

        if (title == null) {
            title = ConfigConstants.DEFAULT_TITLE;
        }
        Utility.ClickElementByText(Handler.driver, title);

        if (fullname == null) {
            fullname = ConfigConstants.DEFAULT_FULLNAME;
        }
        Utility.SendKeysElementByClassName(Handler.driver
                , ElementConstants.CLASS_ANDROID_WIDGET_EDITTEXT, fullname);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_SAVE);
    }

    @Test(dependsOnMethods = {"FillInContactDetails", "TravelerDetails"})
    public void Continue () {
        Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_SEE_BELOW_VIEW);
    }
}
