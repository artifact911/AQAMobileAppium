package util;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersUtil {

    private WaitersUtil() {
    }

    @SneakyThrows
    public static void getTimeOut(long time) {
        Thread.sleep(time);
    }

    public static WebElement waitForElPresent(RemoteWebDriver driver, By by, String errMessage, long timeOutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSec);
        wait.withMessage(errMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElPresent(RemoteWebDriver driver, By by, String errMessage) {
      return waitForElPresent(driver, by, errMessage, 5L);
    }

    public static WebElement waitForElementAndClick(RemoteWebDriver driver, By by, String err) {
        WebElement webElement = waitForElPresent(driver, by, err);
        webElement.click();
        return webElement;
    }

    public static WebElement waitForElementAndSendKeys(RemoteWebDriver driver, By by, String value, String err) {
        WebElement webElement = waitForElPresent(driver, by, err);
        webElement.sendKeys(value);
        return webElement;
    }

    public static boolean waitForElementNotPresent(RemoteWebDriver driver, By by, String err, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(err + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static WebElement waitForElementAndClear(RemoteWebDriver driver, By by, String err, long timeOut) {
        WebElement element = waitForElPresent(driver, by, err, timeOut);
        element.clear();
        return element;
    }
}
