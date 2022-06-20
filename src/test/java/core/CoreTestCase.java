package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.confirmation.ConfirmationLoginPage;
import pages.login.LoginPage;
import pages.start.StartPage;
import util.WaitersUtil;

import java.net.URL;

import static core.common.CommonConstants.CODE_AFTER_LOGIN;
import static core.common.CommonConstants.LOGIN;
import static core.common.CommonConstants.PASSWORD;
import static util.WaitersUtil.waitForElPresent;
import static util.WaitersUtil.waitForElementAndClick;
import static util.WaitersUtil.waitForElementAndSendKeys;

public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    @SneakyThrows
    @BeforeEach
    protected void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "SamsungA52");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.andersen.abanking");
        capabilities.setCapability("appActivity", "com.andersen.abanking.MainActivity");
        capabilities.setCapability("app", "/Users/anduser/Documents/_Projects/fromLessons/AQAMobileAppium/src/apks/app-debug.apk");

        driver = new AndroidDriver(new URL(APPIUM_URL), capabilities);
    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
    }

    protected void logIn() {
        StartPage startPage = new StartPage(driver);
        waitForElementAndClick(driver, startPage.getEnterBtnId(), "Enter button was not found");
        LoginPage loginPage = new LoginPage(driver);
        waitForElementAndSendKeys(driver, loginPage.getLoginField(), LOGIN, "Login field was not found");
        waitForElementAndSendKeys(driver, loginPage.getPasswordField(), PASSWORD, "Password field was not found");
        waitForElPresent(driver, loginPage.getEnterBTN(), "Enter button was not found").click();
        ConfirmationLoginPage confLoginPage = new ConfirmationLoginPage(driver);
        waitForElementAndSendKeys(driver, confLoginPage.getConfirmField(), CODE_AFTER_LOGIN, "Confirmation field was not found");
        waitForElPresent(driver, confLoginPage.getConfirmBTN(), "Confirmation button was not found");
    }
}
