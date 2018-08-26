package com.testing;

import com.testing.log.Log;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

public class Handler {

    private static HashMap<Long, AppiumDriver> AppiumDriver;

    public static void init () {
        SetDriverHashmap(new HashMap<Long, AppiumDriver>());
    }

    public static HashMap<Long, AppiumDriver> GetDriverHashmap() {
        return AppiumDriver;
    }

    public static void SetDriverHashmap(HashMap<Long, AppiumDriver> driverHashMap) {
        AppiumDriver = driverHashMap;
    }

    public static AppiumDriver GetCurrentDriver() {
        return Handler.AppiumDriver.get(Thread.currentThread().getId());
    }

    public static void SetCurrentDriver (AppiumDriver driver) {
        Handler.AppiumDriver.put(Thread.currentThread().getId(), driver);
    }

    public static void ClearDriverHashmap () {
        AppiumDriver.clear();
    }

}