package testCases;

import com.google.common.base.Strings;
import core.CoreTestCase;
import helpers.LoginFlow;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.main.MainPage;
import pages.start.StartPage;
import pages.start.StartPageFindBy;
import util.WaitersUtil;

import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @SneakyThrows
    @Test
    void testCompareArticleTitle() {

       StartPage page = new StartPage();

        Field enter = page.getClass().getDeclaredField("enter");
        enter.setAccessible(true);

            AndroidFindBy annotation = enter.getDeclaredAnnotation(AndroidFindBy.class);
        String id = annotation.id();
        String xpath = annotation.xpath();

        List<Method> methods = Arrays.stream(AndroidFindBy.class.getMethods()).toList();



        for (Method method : methods) {
           // method.setAccessible(true);
            if(method.getParameterCount() == 0) {
                String invoke = String.valueOf(method.invoke(annotation));
                if(!Strings.isNullOrEmpty(invoke)) {

                    System.out.println(invoke);
                };
            }

        }





        //page.getEnter().click();

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
