package mytest;

import core.CoreTestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.WaitersUtil;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest extends CoreTestCase {

    private static final String START_PAGE_PREFIX = "com.andersen.abanking:";

    @Test
    void firstTest() {
        WebElement enterBtn = WaitersUtil
                .waitForElementAndClick(driver, By.id(START_PAGE_PREFIX + "id/splash_button_enter"), "err");

        WebElement login = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "1234567", "err");

        login = WaitersUtil.waitForElementAndClear(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "err", 2L);

        login = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_login"), "1234567", "err");

        WebElement password = WaitersUtil
                .waitForElementAndSendKeys(driver, By.id(START_PAGE_PREFIX + "id/login_et_password"), "Passw0rd", "err");

        WebElement enterBTN = WaitersUtil
                .waitForElementAndClick(driver, By.id(START_PAGE_PREFIX + "id/login_submit_button"), "err");


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
