package pages.confirmation;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class ConfirmationLoginPage {

    private final AppiumDriver<WebElement> driver;

    private final By confirmField = By.id(START_PAGE_PREFIX + "id/code_confirm_code_input_field");
    private final By confirmBTN = By.id(START_PAGE_PREFIX + "id/code_confirm_button_confirm");

    public ConfirmationLoginPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }
}
