package mytest;

import core.CoreTestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.main.MainPage;
import util.WaitersUtil;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest extends CoreTestCase {

    private static final String START_PAGE_PREFIX = "com.andersen.abanking:";

    @Test
    void logInTest() {
        MainPage mainPage = new MainPage(driver);
        logIn();

        assertTrue(WaitersUtil.waitForElPresent(driver, mainPage.getBarTitle(), "err").isDisplayed());
        System.out.println("!!!");
    }

    @Test
    void testCompareArticleTitle() {

        // так поворачиваем девайс
//        driver.rotate(ScreenOrientation.LANDSCAPE);

        WebElement demoBTN = WaitersUtil
                .waitForElPresent(driver, By.id(START_PAGE_PREFIX + "id/splash_button_demo"), "err");

        String text = demoBTN.getAttribute("text");

        assertEquals("ДЕМОВЕРСИЯ", text);
    }

    @Test
    void testCheckEnterBtnInBackground() {
        WebElement enterBtn = WaitersUtil
                .waitForElPresent(driver, By.id(START_PAGE_PREFIX + "id/splash_button_enter"), "err");

        driver.runAppInBackground(Duration.ofSeconds(2));

        WebElement enterBtnAfterReturnFromBackground = WaitersUtil
                .waitForElPresent(driver, By.id(START_PAGE_PREFIX + "id/splash_button_enter"), "err");
    }
}
