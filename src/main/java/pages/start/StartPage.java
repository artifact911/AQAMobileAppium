package pages.start;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class StartPage {

    private final AppiumDriver<WebElement> driver;

    private final By enterBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_enter");

    public StartPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
