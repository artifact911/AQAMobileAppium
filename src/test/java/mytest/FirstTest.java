package mytest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.WaitersUtil;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    private static AppiumDriver<WebElement> driver;

    private static final String START_PAGE_PREFIX = "com.andersen.abanking:";

    @SneakyThrows
    @BeforeAll
    static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "SamsungA52");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.andersen.abanking");
        capabilities.setCapability("appActivity", "com.andersen.abanking.MainActivity");
        capabilities.setCapability("app", "/Users/anduser/Documents/_Projects/fromLessons/AQAMobileAppium/src/apks/app-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void firstTest() {
        WebElement enterBtn = WaitersUtil
                .waitForElementAndClick(driver, By.id(START_PAGE_PREFIX + "id/splash_button_enter"), "err");

        WebElement login = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "1234567", "err");

        login = WaitersUtil.waitForElementAndClear(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "err", 2L);

        login = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "1234567", "err");

        WebElement password = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_password"), "Passw0rd", "err");

        WebElement enterBTN = WaitersUtil
                .waitForElementAndClick(driver, By.id(START_PAGE_PREFIX + "id/login_submit_button"), "err");


        System.out.println("!!!");
    }

    @Test
    void testCompareArticleTitle() {

        // так поворачиваем девайс
//        driver.rotate(ScreenOrientation.LANDSCAPE);

        WebElement demoBTN = WaitersUtil
                .waitForElPresent(driver, By.id(START_PAGE_PREFIX + "id/splash_button_demo"), "err");

        String text = demoBTN.getAttribute("text");

        assertEquals("ДЕМОВЕРСИЯ", text);
    }
}
