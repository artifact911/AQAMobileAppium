package pages.main;

import lombok.Getter;
import org.openqa.selenium.By;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class MainPage {

    private final By barTitle = By.id(START_PAGE_PREFIX + "id/app_bar_title");
}
