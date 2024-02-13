package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = WebDriverManager.chromedriver().create();
    protected MainPage mainPage = new MainPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeAll
    void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void fillBasket() {
        driver.manage().window().setSize(new Dimension(1300, 1000));
        mainPage = new MainPage(driver);
        while (mainPage.addToBasketButtonList.isEmpty()) {
            driver.get("https://www.wildberries.ru/");
            mainPage = new MainPage(driver);
            webDriverWait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath
                            ("//div[@class='product-card__wrapper']")));
        }
    }

    @AfterEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    void closeBrowser() {
        driver.quit();
    }

}
