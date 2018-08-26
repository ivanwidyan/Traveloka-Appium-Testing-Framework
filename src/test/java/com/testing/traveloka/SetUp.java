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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

public class SetUp {

    @BeforeSuite
    public void Init() {
        Log.Debug("SetUp initiated");
        Handler.init();
    }

    @BeforeTest
    @Parameters({"devicename", "udid", "ip", "port"})
    public void SetUp(@Optional String devicename, @Optional String udid,
                      @Optional String ip, @Optional String port) throws Exception {

        String info = "";

        if (com.testing.Handler.GetCurrentDriver() == null) {
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
            Handler.SetCurrentDriver(new AndroidDriver(new URL(url), capabilities));

            info = "SetUp Driver for Device = " + com.testing.Handler.GetCurrentDriver()
                    .getCapabilities().getCapability(CapabilitiesConstants.DEVICE_NAME);
            Log.Debug(info);

        } else {
            info = "Duplicate driver in the same thread";
            Log.Error(info);
        }
    }

    @AfterTest
    public void AfterTest() {
        String info = "Quit Driver for Device = " + com.testing.Handler.GetCurrentDriver()
                .getCapabilities().getCapability(CapabilitiesConstants.DEVICE_NAME);
        Log.Debug(info);
        Handler.GetCurrentDriver().quit();
        Handler.SetCurrentDriver(null);
    }

    @AfterSuite
    public void AfterSuite() throws Exception {
        String info = "Clear Driver Hashmap";
        Log.Debug(info);
        Handler.ClearDriverHashmap();
    }
}
