package pages.main;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class MainPage {

    private final AppiumDriver<WebElement> driver;

    private final By barTitle = By.id(START_PAGE_PREFIX + "id/app_bar_title");

    public MainPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
