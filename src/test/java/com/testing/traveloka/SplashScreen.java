package com.testing.traveloka;

import com.testing.Handler;
import com.testing.Utility;
import com.testing.constants.CapabilitiesConstants;
import com.testing.traveloka.constants.ConfigConstants;
import com.testing.traveloka.constants.ElementConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class SplashScreen {

    @BeforeTest
    @Parameters({"devicename", "udid", "ip", "port"})
    public void SetUp(@Optional String devicename, @Optional String udid,
                      @Optional String ip, @Optional String port) throws Exception {
        if (devicename == null)
            devicename = ConfigConstants.DEVICE_NAME;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilitiesConstants.DEVICE_NAME, devicename);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, ConfigConstants.BROWSER_NAME);
        capabilities.setCapability(CapabilitiesConstants.PLATFORM_NAME, ConfigConstants.PLATFORM_NAME);
        capabilities.setCapability(CapabilitiesConstants.APP_PACKAGE, ConfigConstants.APP_PACKAGE);
        capabilities.setCapability(CapabilitiesConstants.APP_ACTIVITY, ConfigConstants.APP_ACTIVITY);

        if (udid != null)
            capabilities.setCapability(CapabilitiesConstants.UDID, udid);

        if (ip == null)
            ip = ConfigConstants.DEFAULT_IP;

        if (port == null)
            port = ConfigConstants.DEFAULT_PORT;

        String url = "http://" +  ip + ":" + port + "/wd/hub";
        Handler.driver = new AndroidDriver(new URL(url), capabilities);
    }

    /**
     * Choose Country & Language using parameters
     */
    @Test
    @Parameters({"country", "language"})
    public void ChooseCountryLanguage (@Optional String country, @Optional String language) {
        String countryLanguage = "";
        if (country == null || language == null)
            countryLanguage = ElementConstants.TEXT_INDONESIA_ENGLISH;
        else
            countryLanguage = country + "(" + language + ")";

        Utility.ClickElementByText(Handler.driver, countryLanguage); // -> language is already set

        Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_CONTINUE);
    }

    @Test
    public void SkipSplashScreen () {
        Utility.ClickElementByText(Handler.driver, ElementConstants.TEXT_SKIP);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_BUTTON_START_SEARCH);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_WIDGET_BUTTON_BLUE);

        Utility.ClickElementById(Handler.driver, ElementConstants.ID_TEXT_VIEW_TOOLTIP_OK,
                ConfigConstants.TIMEOUT_FALSE);// -> tooltip is gone
    }

    @AfterTest
    public void AfterTest() {
        Handler.driver.quit();
//        System.out.println("AfterTest: " + Handler.driver);
    }
}
