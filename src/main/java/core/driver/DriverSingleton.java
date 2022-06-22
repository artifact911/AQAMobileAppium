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
        capabilities.setCapability(CapType.PLATFORM_NAME.capName, System.getenv(CapType.PLATFORM_NAME.capName));
        capabilities.setCapability(CapType.PLATFORM_VERSION.capName, System.getenv(CapType.PLATFORM_VERSION.capName));
        capabilities.setCapability(CapType.DEVICE_NAME.capName, System.getenv(CapType.DEVICE_NAME.capName));
        capabilities.setCapability(CapType.UDID.capName, System.getenv(CapType.UDID.capName));
        capabilities.setCapability(CapType.AUTOMATION_NAME.capName, System.getenv(CapType.AUTOMATION_NAME.capName));
        capabilities.setCapability(CapType.APP_PACKAGE.capName, System.getenv(CapType.APP_PACKAGE.capName));
        capabilities.setCapability(CapType.APP_ACTIVITY.capName, System.getenv(CapType.APP_ACTIVITY.capName));
        capabilities.setCapability(CapType.APP.capName, System.getenv(CapType.APP.capName));
        return capabilities;

    }
}

enum CapType {
    PLATFORM_NAME("platformName"),
    PLATFORM_VERSION("platformVersion"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    AUTOMATION_NAME("automationName"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    APP("app");

    final String capName;

    CapType(String capName) {
        this.capName = capName;
    }
}
