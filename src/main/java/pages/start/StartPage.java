package pages.start;

import lombok.Getter;
import org.openqa.selenium.By;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class StartPage {

    public static final String DEMO_BTN_TEXT = "ДЕМОВЕРСИЯ";

    private final By enterBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_enter");
    private final By demoBtnId = By.id(START_PAGE_PREFIX + "id/splash_button_demo");


//    @iOSXCUITFindBy
//    @AndroidFindBy(id = START_PAGE_PREFIX + "id/splash_button_enter")
//    private MobileElement element;
}
