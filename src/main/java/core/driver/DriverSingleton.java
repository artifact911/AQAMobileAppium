package core.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;

import static core.driver.CapType.*;

@Getter
public enum DriverSingleton {

    IOS("iOS", new IOSDriver<>(getUrl(), getIosDesiredCapabilities())),
    ANDROID("Android", new AndroidDriver<>(getUrl(), getAndroidDesiredCapabilities()));

    private final String name;
    private final AppiumDriver<RemoteWebElement> driver;

    DriverSingleton (String name, AppiumDriver<RemoteWebElement> driver) {
        this.name = name;
        this.driver = driver;
    }

    @SneakyThrows
    private static URL getUrl(){
        return new URL(APPIUM_URL);
    }

    private static final String APPIUM_URL = "http://127.0.0.1:5566/wd/hub";

    private static DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities cap = setCommonCapabilities();
        cap.setCapability(APP_PACKAGE.getCapName(), System.getenv(APP_PACKAGE.getCapName()));
        cap.setCapability(APP_ACTIVITY.getCapName(), System.getenv(APP_ACTIVITY.getCapName()));
        cap.setCapability(APP.getCapName(), System.getenv(APP.getCapName()));
        return cap;
    }

    private static DesiredCapabilities getIosDesiredCapabilities() {
        DesiredCapabilities cap = setCommonCapabilities();
        cap.setCapability(BUNDLE_ID.getCapName(), System.getenv(BUNDLE_ID.getCapName()));
        cap.setCapability(XCODE_ORG_ID.getCapName(), System.getenv(XCODE_ORG_ID.getCapName()));
        cap.setCapability(XCODE_SINGING_ID.getCapName(), System.getenv(XCODE_SINGING_ID.getCapName()));
        cap.setCapability(INSTALL_APP.getCapName(), System.getenv(INSTALL_APP.getCapName()));
        cap.setCapability(FEATURE_APP.getCapName(), System.getenv(FEATURE_APP.getCapName()));
        return cap;
    }

    private static DesiredCapabilities setCommonCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(PLATFORM_NAME.getCapName(), System.getenv(PLATFORM_NAME.getCapName()));
        cap.setCapability(PLATFORM_VERSION.getCapName(), System.getenv(PLATFORM_VERSION.getCapName()));
        cap.setCapability(DEVICE_NAME.getCapName(), System.getenv(DEVICE_NAME.getCapName()));
        cap.setCapability(UDID.getCapName(), System.getenv(UDID.getCapName()));
        cap.setCapability(AUTOMATION_NAME.getCapName(), System.getenv(AUTOMATION_NAME.getCapName()));
        return cap;
    }
}

@Getter
enum CapType {
    //common
    PLATFORM_NAME("platformName"),
    PLATFORM_VERSION("platformVersion"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    AUTOMATION_NAME("automationName"),

    //Android
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    APP("app"),

    //iOS
    APP_PATH("appPath"),
    BUNDLE_ID("bundleId"),
    XCODE_ORG_ID("xcodeOrgId"),
    XCODE_SINGING_ID("XcodeSigningId"),

    INSTALL_APP("installApp"),
    FEATURE_APP("featureApp");

    private final String capName;

    CapType(String capName) {
        this.capName = capName;
    }
}
