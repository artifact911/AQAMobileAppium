package pages.change.password;

import lombok.Getter;
import org.openqa.selenium.By;

import static core.common.CommonLocators.START_PAGE_PREFIX;

@Getter
public class SuccessesPage {

    private final By toMainBTN = By.id(START_PAGE_PREFIX + "id/account_change_password_save_new_password_button");
}
