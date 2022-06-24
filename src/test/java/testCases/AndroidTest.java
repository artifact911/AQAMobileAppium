package testCases;

import core.CoreTestCase;
import helpers.LoginFlow;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.main.MainPage;
import pages.start.StartPage;
import util.WaitersUtil;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.start.StartPage.DEMO_BTN_TEXT;

public class AndroidTest extends CoreTestCase {



    @Test
    void logInTest() {
        MainPage mainPage = new MainPage();
        LoginFlow.logInFull();

        assertTrue(WaitersUtil.waitForElPresent(mainPage.getBarTitle(), "err").isDisplayed());
    }

    @Test
    void testCompareArticleTitle() {
        StartPage page = new StartPage();
        WebElement demoBTN = WaitersUtil
                .waitForElPresent(page.getDemoBtnId(), "DemoBTN was not found");

        assertEquals(DEMO_BTN_TEXT, demoBTN.getAttribute("text"));
    }

    @Test
    void testCheckEnterBtnInBackground() {
        StartPage page = new StartPage();
        WebElement enterBtn = WaitersUtil
                .waitForElPresent(page.getEnterBtnId(), "EnterBTN was not found");
        driver.runAppInBackground(Duration.ofSeconds(2));

        assertTrue(enterBtn.isDisplayed());
    }
}
