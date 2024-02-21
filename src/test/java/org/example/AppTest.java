package org.example;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Story("Тестирование приложения Google Calculator на телефоне Xiaomi через USB кабель")
public class AppTest {
    static AndroidDriver<AndroidElement> driver = null;
    @BeforeAll
    @Step("Инициализация драйвера")
    public static void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест операции сложения")
    @Step("Складываем 2 + 2")
    public void addTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        Assertions.assertEquals("4", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    @DisplayName("Тест операции вычитания")
    @Step("Вычитаем 7 - 3")
    public void subTest() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.calculator:id/digit_7").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        Assertions.assertEquals("4", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    @DisplayName("Тест операции умножения")
    @Step("Умножаем 5 х 5")
    public void mulTest() {
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        Assertions.assertEquals("25", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    @DisplayName("Тест операции деления")
    @Step("Делим 9 : 1")
    public void divTest() {
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        Assertions.assertEquals("9", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}