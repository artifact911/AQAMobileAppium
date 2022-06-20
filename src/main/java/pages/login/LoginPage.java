package pages.login;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class LoginPage {

    private final AppiumDriver<WebElement> driver;

    private final By loginField = By.id(START_PAGE_PREFIX + "id/login_et_login");
    private final By passwordField = By.id(START_PAGE_PREFIX + "id/login_et_password");
    private final By enterBTN = By.id(START_PAGE_PREFIX + "id/login_submit_button");

    public LoginPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
