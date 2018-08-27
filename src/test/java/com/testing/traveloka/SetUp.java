/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing.traveloka;

import com.testing.Handler;
import com.testing.constants.CapabilitiesConstants;
import com.testing.logging.Log;
import com.testing.traveloka.constants.ConfigConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetUp {

    @BeforeSuite
    public void Init() {
        Log.Debug("SetUp initiated");
        Handler.init();
    }

    @BeforeTest
    @Parameters({"browser", "devicename", "udid", "ip", "port"})
    public void SetUp(@Optional String browser, @Optional String devicename, @Optional String udid,
                      @Optional String ip, @Optional String port) throws Exception {

        String info = "";

        Log.Error("Test " + browser);

        if (browser.equalsIgnoreCase("Android")) {
            if (com.testing.Handler.GetCurrentAppiumDriver() == null) {
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

                String url = "http://" + ip + ":" + port + "/wd/hub";
                Handler.SetCurrentAppiumDriver(new AndroidDriver(new URL(url), capabilities));

                info = "SetUp Appium Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
                        .getCapabilities().getCapability(CapabilitiesConstants.DEVICE_NAME);
                Log.Debug(info);

            } else {
                info = "Duplicate Appium driver in the same thread";
                Log.Error(info);
            }
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/ivanwidyan/Desktop/Ivan-Widyan/Tools/GeckoDriver/geckodriver");
            Handler.SetCurrentWebDriver(new FirefoxDriver());

            Handler.GetCurrentWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String url = "https://www.traveloka.com/en";

            Handler.GetCurrentWebDriver().get(url);
        }
    }

    @AfterTest
    public void AfterTest() {
        if (Handler.GetCurrentAppiumDriver() != null) {
            String info = "Quit Driver for Device = " + com.testing.Handler.GetCurrentAppiumDriver()
                    .getCapabilities().getCapability(CapabilitiesConstants.DEVICE_NAME);
            Log.Debug(info);
            Handler.GetCurrentAppiumDriver().quit();
        }

        if (Handler.GetCurrentWebDriver() != null) {
            String info = "Quit Driver for Web Driver = " + com.testing.Handler.GetCurrentWebDriver();
            Log.Debug(info);
            Handler.GetCurrentWebDriver().quit();
        }
    }

    @AfterSuite
    public void AfterSuite() throws Exception {
        String info = "Clear Driver Hashmap";
        Log.Debug(info);
        Handler.ClearAppiumDriverHashmap();
        Handler.ClearWebDriverHashmap();
    }
}
