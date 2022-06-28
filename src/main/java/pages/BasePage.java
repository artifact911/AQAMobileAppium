package pages;

import core.driver.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BasePage {


/*    AndroidFindBy annotation = page.getClass().getDeclaredField("enter").getDeclaredAnnotation(AndroidFindBy.class);
    Field field = Arrays.stream(annotation.getClass().getDeclaredFields()).toList().stream().filter(
            f -> Strings.isNullOrEmpty((String) f.get(annotation))).findFirst().get();
field.setAccessible(true);
    String name = field.getName();*/


    protected static AppiumDriver<RemoteWebElement> myDriver;

    @SneakyThrows
    public BasePage(AppiumDriver<RemoteWebElement> driver) {

        myDriver = driver;
        Thread.sleep(5000L);
        PageFactory.initElements(new AppiumFieldDecorator(myDriver, Duration.ofSeconds(10)), this);
    }
/*
    protected void init() {

        //Class<? extends Annotation> requiredAnnotation = Platform.isIOS() ? iOSXCUITFindBy.class : AndroidFindBy.class;

//        if (Platform.isIOS()) {
//            Arrays.stream(getClass().getDeclaredFields())
//                  .filter(f -> isAnnotationDeclared(f, iOSXCUITFindBy.class))
//                  .map(f -> extractFieldValue(f, this))
//                  .flatMap(v -> v instanceof List ? ((List<?>) v).stream() : Stream.of(v))
//        }
    }

    @SneakyThrows
    private Object extractFieldValue(Field field, Object owner) {
        field.setAccessible(true);
        return field.get(owner);
    }

    private <T extends Annotation> boolean isAnnotationDeclared(Field f, Class<T> annotationClass) {
        return f.getDeclaredAnnotation(annotationClass) != null;
    }*/
}
