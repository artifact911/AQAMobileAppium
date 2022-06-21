package util;

import core.CoreTestCase;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@UtilityClass
public class WaitersUtil extends CoreTestCase {

    @SneakyThrows
    public void getTimeOut(long time) {
        Thread.sleep(time);
    }

    public WebElement waitForElPresent(By by, String errMessage, long timeOutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSec);
        wait.withMessage(errMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElPresent(By by, String errMessage) {
      return waitForElPresent(by, errMessage, 5L);
    }

    public WebElement waitForElementAndClick(By by, String err) {
        WebElement webElement = waitForElPresent(by, err);
        webElement.click();
        return webElement;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String err) {
        WebElement webElement = waitForElPresent(by, err);
        webElement.sendKeys(value);
        return webElement;
    }

    public boolean waitForElementNotPresent(By by, String err, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(err + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String err, long timeOut) {
        WebElement element = waitForElPresent(by, err, timeOut);
        element.clear();
        return element;
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String err, long timeOut) {
        WebElement element = waitForElPresent(by, err, timeOut);
        return element.getAttribute(attribute);
    }
}
