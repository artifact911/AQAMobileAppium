package testCases;

import core.CoreTestCase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.WaitersUtil;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.start.StartPage.DEMO_BTN_TEXT;

public class IOSTest extends CoreTestCase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Демоверсия']")
    WebElement demoBTN;

    @Test
    void testCompareArticleTitle() {



        //= WaitersUtil.waitForElPresent(By.xpath("//XCUIElementTypeButton[@name='Демоверсия']"), "DemoBTN was not found");

        assertEquals(DEMO_BTN_TEXT, demoBTN.getAttribute("name").toUpperCase(Locale.ROOT));
    }
}
