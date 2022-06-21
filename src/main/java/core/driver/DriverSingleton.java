package core.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;

public enum DriverSingleton {

    IOS("iOS") {
        @SneakyThrows
        @Override
        public AppiumDriver<RemoteWebElement> getDriverByPlatform() {
            return null;
        }
    },
    ANDROID("Android") {
        @SneakyThrows
        @Override
        public AppiumDriver<RemoteWebElement> getDriverByPlatform() {
            return new AndroidDriver<>(new URL(APPIUM_URL), DriverSingleton.getAndroidDesiredCapabilities());
        }
    };

    public final String name;

    DriverSingleton(String name) {
        this.name = name;
    }

    public abstract AppiumDriver<RemoteWebElement> getDriverByPlatform();

    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "SamsungA52");
        capabilities.setCapability("udud", "RZ8RB0QCRLY");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.andersen.abanking");
        capabilities.setCapability("appActivity", "com.andersen.abanking.MainActivity");
        capabilities.setCapability("app", "/Users/anduser/Documents/_Projects/fromLessons/AQAMobileAppium/src/apks/app-debug.apk");
        return capabilities;
    }
}
