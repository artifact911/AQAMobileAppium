package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

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
              .moveTo(PointOption.point(x, endY)).release().perform();
    }
}
