package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class AppTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("---disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @Test
    void nameOfPaymentTitleTest() {
        String onlinePaymentTitle = driver.findElement(By.xpath("//h2[contains(.,'Онлайн пополнение')]"))
                .getText().replaceAll("\n", " ");
        Assertions.assertEquals("Онлайн пополнение без комиссии", onlinePaymentTitle);
    }

    @Test
    void logoPaySystemsDisplayTest() {
        List<WebElement> elementList = driver.findElements(By.xpath("//img[contains(@src, '/pay')]"));
        for (WebElement we :
                elementList) {
            Assertions.assertTrue(we.isDisplayed());
        }
    }

    @Test
    void serviceDetailsTest() {
        String expectedURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String expectedTitle = "Порядок оплаты и безопасность интернет платежей";
        driver.findElement(By.xpath("//a[contains(.,'Подробнее о сервисе')]")).click();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedURL, driver.getCurrentUrl()),
                () -> Assertions.assertEquals(expectedTitle, driver.getTitle())
        );
    }

    @Test
    void buttonContinueClickTest()  {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("42");
        driver.findElement(By.xpath("//button[contains(.,'Продолжить')][1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        //? Почему без этого ожтдания не работает стабитьно ? (Тест ждет пока появится окно, а оно всегда грузится
        // по разному?)
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='header__payment']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='header__payment-info']")).getText()
                .contains("Оплата: Услуги связи Номер:"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}