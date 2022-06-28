package pages.start;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class StartPage {

    public static final String DEMO_BTN_TEXT = "ДЕМОВЕРСИЯ";

    private final By enterBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_enter");
    private final By demoBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_demo");

    @AndroidFindBy(id = "id/splash_button_enter", xpath = "fdeg")
    public WebElement enter;

    @AndroidFindBy(xpath = "id/splash_button_demo")
    public WebElement demo;


//    @iOSXCUITFindBy
//    @AndroidFindBy(id = START_PAGE_PREFIX + "id/splash_button_enter")
//    private MobileElement element;
}
