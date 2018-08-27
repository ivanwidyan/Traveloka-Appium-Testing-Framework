/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

public class Handler {

    private static HashMap<Long, AppiumDriver> AppiumDriver;

    /**
     * Handler initialization
     */
    public static void init () {
        SetDriverHashmap(new HashMap<Long, AppiumDriver>());
    }

    /**
     * Get AppiumDriver Hashmap
     * @return Appium Driver Hashmap
     */
    public static HashMap<Long, AppiumDriver> GetDriverHashmap() {
        return AppiumDriver;
    }

    /**
     * Set Driver Hashmap
     * @param driverHashMap
     */
    public static void SetDriverHashmap(HashMap<Long, AppiumDriver> driverHashMap) {
        AppiumDriver = driverHashMap;
    }

    /**
     * Get Current Driver which running on the Current Thread
     * @return AppiumDriver
     */
    public static AppiumDriver GetCurrentDriver() {
        return Handler.AppiumDriver.get(Thread.currentThread().getId());
    }

    /**
     * Set Current Driver to run on the Current Thread
     * @param driver
     */
    public static void SetCurrentDriver (AppiumDriver driver) {
        Handler.AppiumDriver.put(Thread.currentThread().getId(), driver);
    }

    /**
     * Clear AppiumDriver Hashmap
     */
    public static void ClearDriverHashmap () {
        AppiumDriver.clear();
    }

}