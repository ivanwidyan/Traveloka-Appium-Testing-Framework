/*
 * Copyright (c) 2018. Ivan Widyan - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Email: ivanwidyan@yahoo.com
 */

package com.testing;

import com.testing.logging.Log;
import com.testing.traveloka.constants.ConfigConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Utility {
    private final static String NO_SENDKEYS = null;

    private final static boolean CLICK_TRUE = true;
    private final static boolean CLICK_FALSE = false;

    private final static long DEFAULT_TIMEOUT = 30;
    private final static long ZERO_TIMEOUT = 0;

    private final static long DEFAULT_SWIPE_DURATION = 1;

    /**
     * This method used to get element by id with default timeout
     * @param driver WebDriver
     * @param id element
     * @return WebElement
     */
    public static WebElement GetElementById (WebDriver driver, String id) {
        return webElementUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_FALSE,
                NO_SENDKEYS, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get element by id and click with default timeout
     * @param driver WebDriver
     * @param id
     * @return WebElement
     */
    public static WebElement ClickElementById (WebDriver driver, String id) {
        return webElementUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_TRUE,
                NO_SENDKEYS, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get element by id and click with true or false timeout
     * @param driver WebDriver
     * @param id
     * @param timeout false to set no timeout, true to use default timeout
     * @return
     */
    public static WebElement ClickElementById (WebDriver driver, String id, boolean timeout) {
        if (timeout)
            return ClickElementByText(driver, id);
        else
            return webElementUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_TRUE,
                    NO_SENDKEYS, ZERO_TIMEOUT);
    }

    /**
     * This method used to get element by id and click with input timeout
     * @param driver WebDriver
     * @param id
     * @param timeout in seconds
     * @return
     */
    public static WebElement ClickElementById (WebDriver driver, String id, long timeout) {
        return webElementUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_TRUE,
                NO_SENDKEYS, timeout);
    }

    /**
     * This method used to get element by id and send keys with default timeout
     * @param driver WebDriver
     * @param id
     * @return WebElement
     */
    public static WebElement SendKeysElementById (WebDriver driver, String id, String sendKeys) {
        return webElementUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_FALSE,
                sendKeys, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to find element by text with default timeout
     * @param driver
     * @param text
     * @return WebElement
     */
    public static WebElement GetElementByText (WebDriver driver, String text) {
        return webElementUtility(driver, text, ConfigConstants.ELEMENT_TYPE_TEXT_TEXT_VIEW, CLICK_FALSE,
                NO_SENDKEYS, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to find element by text and click with default timeout
     * @param driver web driver
     * @param text
     * @return WebElement
     */
    public static WebElement ClickElementByText (WebDriver driver, String text) {
        return ClickElementByText(driver, text, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to find element by id then click with 1s timeout and 1s delay
     * @param driver web driver
     * @param text element which need to be found
     * @return WebElement
     */
    public static WebElement ClickElementByText (WebDriver driver, String text, String type) {
        return webElementUtility(driver, text, type, CLICK_TRUE,
                NO_SENDKEYS, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to find element by text and click with true or false timeout
     * @param driver web driver
     * @param text
     * @param timeout false to set no timeout, true to use default timeout
     * @return WebElement
     */
    public static WebElement ClickElementByText (WebDriver driver, String text, boolean timeout) {
        if (timeout)
            return ClickElementByText(driver, text);
        else
            return webElementUtility(driver, text, ConfigConstants.ELEMENT_TYPE_TEXT_TEXT_VIEW, CLICK_TRUE,
                    NO_SENDKEYS, ZERO_TIMEOUT);
    }

    /**
     * This method used to find element by text and click with input timeout
     * @param driver web driver
     * @param text
     * @param timeout in seconds
     * @return WebElement
     */
    public static WebElement ClickElementByText (WebDriver driver, String text, long timeout) {
            return webElementUtility(driver, text, ConfigConstants.ELEMENT_TYPE_TEXT_TEXT_VIEW, CLICK_TRUE,
                    NO_SENDKEYS, timeout);
    }

    /**
     * This method used to find element by text and send keys with default timeout
     * @param driver web driver
     * @param text
     * @param sendKeys
     * @return WebElement
     */
    public static WebElement SendKeysElementByText (WebDriver driver, String text, String sendKeys) {
        return webElementUtility(driver, text, ConfigConstants.ELEMENT_TYPE_TEXT_TEXT_VIEW, CLICK_FALSE,
                sendKeys, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get element by class name and click with default timeout
     * @param driver
     * @param className
     * @return WebElement
     */
    public static WebElement ClickElementByClassName (WebDriver driver, String className) {
        return webElementUtility(driver, className, ConfigConstants.ELEMENT_TYPE_CLASSNAME, CLICK_TRUE,
                NO_SENDKEYS, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get element by class name and send keys with default timeout
     * @param driver
     * @param className
     * @return WebElement
     */
    public static WebElement SendKeysElementByClassName (WebDriver driver, String className, String sendKeys) {
        return webElementUtility(driver, className, ConfigConstants.ELEMENT_TYPE_CLASSNAME, CLICK_FALSE,
                sendKeys, DEFAULT_TIMEOUT);
    }

    private static WebElement webElementUtility (WebDriver driver, String input, String type, boolean click,
                                                 String sendKeys, long timeout) {
        if (driver == null) {
            return null;
        } else {
            WebElement webElement = null;

            webElement = findWebElement(driver, type, input, timeout);

            if (webElement == null) {
                Log.Warning("Result: Timeout " + timeout + "s with input = " + input + ", type = " + type);
//                System.out.println("Result: Timeout " + timeout + "s with input = " + input + ", type = " + type);
                return null;
            } else {

                if (click)
                    webElement.click();

                if (sendKeys != null)
                    webElement.sendKeys(sendKeys);

                /*System.out.println("Result: WebElement found with input = " + input + ", type = " + type
                        + ", click = " + click + ", sendKeys = " + sendKeys);*/
            }

            return webElement;
        }
    }

    private static WebElement findWebElement (WebDriver driver, String type, String input, long timeout) {
        WebElement webElement;
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // TODO: Report bug to appium
        /* This code is not working when using CLI setup appium server
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        */

        if (type.equals(ConfigConstants.ELEMENT_TYPE_TEXT_TEXT_VIEW)) {
            String xpath = "//android.widget.TextView[@text='" + input + "']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            webElement = driver.findElement(By.xpath(xpath));

        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_TEXT_BUTTON)) {
            String xpath = "//android.widget.Button[@text='" + input + "']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            webElement = driver.findElement(By.xpath(xpath));

        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_DIV_CLASS)) {
            String xpath = "//div[@class='" + input + "']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            webElement = driver.findElement(By.xpath(xpath));
        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_ID)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(input)));

            webElement = driver.findElement(By.id(input));

        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_CLASSNAME)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className(input)));

            webElement = driver.findElement(By.className(input));
        } else {
            Log.Error("Type is not defined");
            return null;
        }
        return webElement;
    }

    /**
     * This method used to get elements by id with default timeout
     * @param driver
     * @param id
     * @return List<WebElement>
     */
    public static List<WebElement> GetElementsById (WebDriver driver, String id) {
        return webElementsUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_FALSE,
                ConfigConstants.FIRST_INDEX, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get elements by id and click by index with default timeout
     * @param driver
     * @param id
     * @return List<WebElement>
     */
    public static List<WebElement> ClickElementsById (WebDriver driver, String id, int index) {
        return webElementsUtility(driver, id, ConfigConstants.ELEMENT_TYPE_ID, CLICK_TRUE,
                index, DEFAULT_TIMEOUT);
    }

    public static List<WebElement> ClickElementsByValue (WebDriver driver, String value
            , String type, int index) {
        return webElementsUtility(driver, value, type, CLICK_TRUE,
                index, DEFAULT_TIMEOUT);
    }

    /**
     * This method used to get elements by class name with default timeout
     * @param driver
     * @param className
     * @return List<WebElement>
     */
    public static List<WebElement> GetElementsByClass (WebDriver driver, String className) {
        return webElementsUtility(driver, className, ConfigConstants.ELEMENT_TYPE_CLASSNAME, CLICK_FALSE,
                ConfigConstants.FIRST_INDEX, DEFAULT_TIMEOUT);
    }

    private static List<WebElement> webElementsUtility (WebDriver driver, String input, String type, boolean click,
                                                 int index, long timeout) {
        if (driver == null) {
            return null;
        } else {
            List<WebElement> webElement;

            webElement = findWebElements(driver, type, input, timeout);

            if (webElement == null) {
                Log.Warning("Result: Timeout " + timeout + "s with input = " + input + ", type = " + type);
//                System.out.println("Result: Timeout " + timeout + "s with input = " + input + ", type = " + type);
                return null;
            } else {
                if (click) {
                    WebElement element = webElement.get(index);
                    element.click();
                }

                /*System.out.println("Result: WebElements found with input = " + input + ", type = " + type
                        + ", click = " + click + ", index = " + index);*/
            }

            return webElement;
        }
    }

    private static List<WebElement> findWebElements (WebDriver driver, String type, String input, long timeout) {
        List<WebElement> webElement;
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        if (type.equals(ConfigConstants.ELEMENT_TYPE_DIV_CLASS)) {
            String xpath = "//div[@class='" + input + "']";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            webElement = driver.findElements(By.xpath(xpath));
        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_ID)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id(input)));

            webElement = driver.findElements(By.id(input));

        } else if (type.equals(ConfigConstants.ELEMENT_TYPE_CLASSNAME)) {
            wait.until(ExpectedConditions.elementToBeClickable(By.className(input)));

            webElement = driver.findElements(By.className(input));
        } else {
            Log.Error("Type is not defined");
            return null;
        }
        return webElement;
    }

    /**
     * Tap in x and y coordinates
     * @param x coordinate
     * @param y coordinate
     */
    public static void TapByCoordinates (int x, int y) {
        TouchAction touchAction = new TouchAction(Handler.GetCurrentAppiumDriver());
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    /**
     * Swipe screen vertically by anchor start point, end point, and anchor
     * @param driver
     * @param startPoint in y coordinates
     * @param endPoint in y coordinates
     * @param anchor in x coordinates
     */
    public static void SwipeVerticalByCoordinates(AppiumDriver driver, int startPoint, int endPoint, int anchor) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(DEFAULT_SWIPE_DURATION)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }

    /**
     * Swipe screen horizontally by anchor start point, end point, and anchor
     * @param driver
     * @param startPoint in x coordinates
     * @param endPoint in y coordinates
     * @param anchor in y coordinates
     */
    public static void SwipeHorizontalByCoordinates (AppiumDriver driver, int startPoint, int endPoint, int anchor) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(DEFAULT_SWIPE_DURATION)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }

    /**
     * Swipe screen horizontally by x and y start point to x and y end point.
     * @param driver
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    public static void SwipeByCoordinates (AppiumDriver driver, int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(DEFAULT_SWIPE_DURATION)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}