package pages.change.password;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class ChangePasswordPage {

    private final AppiumDriver<WebElement> driver;

    private final By currentPasswordField = By.id(START_PAGE_PREFIX + "id/account_change_password_current_password_text");
    private final By newPasswordField = By.id(START_PAGE_PREFIX + "id/account_change_password_new_password_text");
    private final By repeatPasswordField = By.id(START_PAGE_PREFIX + "id/account_change_password_repeat_new_password_text");
    private final By savePasswordBTN = By.id(START_PAGE_PREFIX + "id/account_change_password_save_new_password_button");

    public ChangePasswordPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
