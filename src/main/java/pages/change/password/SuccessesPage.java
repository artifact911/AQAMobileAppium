package pages.change.password;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class SuccessesPage {

    private final AppiumDriver<WebElement> driver;

    private final By toMainBTN = By.id(START_PAGE_PREFIX + "id/account_change_password_save_new_password_button");

    public SuccessesPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
