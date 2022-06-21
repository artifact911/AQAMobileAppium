package core;

import core.driver.Platform;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public abstract class CoreTestCase {

    protected static AppiumDriver<RemoteWebElement> driver;

    @SneakyThrows
    @BeforeEach
    protected void setUp() {
        driver = Platform.getDriver();
        this.rotateScreenPortrait();
    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(Duration duration) {
        driver.runAppInBackground(duration);
    }
}
