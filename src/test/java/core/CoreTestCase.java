package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    @SneakyThrows
    @BeforeEach
    public void setUp() {
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
    public void tearDown() {
        driver.quit();
    }
}
