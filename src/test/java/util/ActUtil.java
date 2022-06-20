package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ActUtil {

    private ActUtil() {
    }

    // хотим свайпнуть снизу экрана вверх по середине по оси Х
    // чем больше время, тем медленнее свайпает
    public void swipeUp(AppiumDriver driver, int timeOfSwipe) {

        // позволяет производить действия на экране
        TouchAction action = new TouchAction(driver);

        // получаем размер экрана
        Dimension size = driver.manage().window().getSize();

        // получаем середину экрана по оси Х
        int x = size.width / 2;

        // получаем начальную точку для свайпа (взяли не с самого низа)
        int startY = (int) (size.height * 0.8);

        // получаем конечную точку для свайпа (взяли не до самого верха)
        int endY = (int) (size.height * 0.2);

        action.press(PointOption.point(x, startY))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeOfSwipe)))
              .moveTo(PointOption.point(x, endY))
              .release()
              .perform();
    }

    public void swipeUpQuick(AppiumDriver driver) {
        swipeUp(driver, 200);
    }

    public void swipeUpToFindElement(AppiumDriver driver, By by, String err, int maxSwipes) {
     int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes){
                WaitersUtil.waitForElPresent(driver, by, "Can't find el by swiping up \n" + err);
                return;
            }
            swipeUpQuick(driver);
            ++alreadySwiped;
        }
    }

    public void swipeElementToLeft(AppiumDriver driver, By by, String err) {
        WebElement element = WaitersUtil.waitForElPresent(driver, by, err, 10);

        // левая/правая точка элемента по оси Х
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();

        // верхняя/нижняя точка элемента по оси Y
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        //найдем середину элемента по Y для свайпа
        int middleY = (upperY + lowerY) / 2;

        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(rightX, middleY))
              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(300)))
              .moveTo(PointOption.point(leftX, middleY))
              .release()
              .perform();
    }
}
