package core.driver;

import io.appium.java_client.AppiumDriver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.remote.RemoteWebElement;

@UtilityClass
public class Platform {

    private boolean isAndroid() {
        return isPlatform(DriverSingleton.ANDROID);
    }

    private boolean isIOS() {
        return isPlatform(DriverSingleton.IOS);
    }

    private boolean isPlatform(DriverSingleton driverSingleton) {
        return driverSingleton.name.equalsIgnoreCase(getPlatformVar());
    }

    private String getPlatformVar() {
        return System.getenv("platformName");
    }

    public AppiumDriver<RemoteWebElement> getDriver() {
        if(isAndroid()) {
            return DriverSingleton.ANDROID.getDriverByPlatform();
        } else {
            return DriverSingleton.IOS.getDriverByPlatform();
        }
    }
}
