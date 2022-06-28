package pages.start;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.BasePage;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class StartPageFindBy extends BasePage {

    public static final String DEMO_BTN_TEXT = "ДЕМОВЕРСИЯ";

    private final By enterBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_enter");
    private final By demoBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_demo");

    @AndroidFindBy(id = "id/splash_button_enter")
    private MobileElement enter;

    public StartPageFindBy(AppiumDriver<RemoteWebElement> driver) {
        super(driver);
    }

    //    @iOSXCUITFindBy
//    @AndroidFindBy(id = START_PAGE_PREFIX + "id/splash_button_enter")
//    private MobileElement element;
}
