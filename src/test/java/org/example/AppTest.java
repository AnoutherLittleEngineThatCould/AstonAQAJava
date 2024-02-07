package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    double moneyToPhone;
    String phoneNumber;

    public void paymentPageLogin(String phoneNumber, double moneyBYN) {
        //Данные для проверки номера телефона и денег
        moneyToPhone = moneyBYN;
        this.phoneNumber = phoneNumber;
        //Переход на страницу оплаты сотовой связи
        driver.findElement(By.id("connection-phone")).sendKeys(phoneNumber);
        driver.findElement(By.id("connection-sum")).sendKeys(Double.toString(moneyBYN));
        driver.findElement(By.xpath("//button[contains(.,'Продолжить')][1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='header__payment']")));
    }

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("---disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @ParameterizedTest(name = "Тест для полей страницы оплаты сотовой связи")
    @MethodSource("generateCardPaymentFields")
    void fieldsOfPhonePaymentTest(List<String> cardPaymentFields) {
        paymentPageLogin("297777777", 50);
        //Проверка соответсвия текста в полях
        List<WebElement> elementList = driver.findElements(By.xpath("//label[contains(@class,'ng-tns')]"));
        List<String> elementListText = elementList.stream().map(WebElement::getText).collect(Collectors.toList());
        for (int i = 0; i < cardPaymentFields.size(); i++) {
            Assertions.assertEquals(cardPaymentFields.get(i), elementListText.get(i));
        }
        //Проверка наличия иконок платежных систем в поле "Номер карты"
        List<WebElement> imgList = driver.findElements(By.xpath("//img[contains(@src,'system')]"));
        for (int i = 0; i < imgList.size(); i++) {
            if (i < imgList.size() - 1) {
                Assertions.assertTrue(imgList.get(i).isDisplayed());
            } else {
                webDriverWait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//img[contains(@src,'maestro')]")));
                Assertions.assertTrue(imgList.get(i).isDisplayed());
            }
        }
    }

    static Stream<Arguments> generateCardPaymentFields() {
        return Stream.of(
                Arguments.of(Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"))
        );
    }

    @ParameterizedTest(name = "Тест для пункта меню {0}")
    @MethodSource("generatePaymentFormFields")
    void fieldsOfPaymentFormTest(String testName, List<String> cardPaymentFields) {
        //Выбор пункта меню
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath(String.format("//li/p[contains(., '%s')]", testName))).click();
        List<WebElement> elementList = driver.findElements(
                By.xpath("//form[@class='pay-form opened']/div/input"));
        List<String> elementListText = elementList.stream().map(o -> o.getAttribute("placeholder"))
                .collect(Collectors.toList());
        Assertions.assertAll(
                () -> Assertions.assertEquals(elementListText.get(0), cardPaymentFields.get(0)),
                () -> Assertions.assertEquals(elementListText.get(1), cardPaymentFields.get(1)),
                () -> Assertions.assertEquals(elementListText.get(2), cardPaymentFields.get(2))
        );
    }

    static Stream<Arguments> generatePaymentFormFields() {
        return Stream.of(
                Arguments.of("Услуги связи",
                        Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека")),
                Arguments.of("Домашний интернет",
                        Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека")),
                Arguments.of("Рассрочка",
                        Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека")),
                Arguments.of("Задолженность",
                        Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека"))
        );
    }

    @Test
    @DisplayName("Тест корректности ввода телефона и суммы пополнения")
    void correctPhoneAndSumTest() {
        paymentPageLogin("297777777", 42);
        //Обработка номера телефона
        String removeLetters = "[^0-9.]";
        String phoneNumberInPaymentForm = driver
                .findElement(By.xpath("//p[@class='header__payment-info']")).getText()
                .replaceAll(removeLetters, "");
        //Обработка суммы пополнения
        String headerSum = driver.findElement(By.xpath("//p[@class='header__payment-amount']")).getText()
                .replaceAll(removeLetters, "");
        String buttonSum = driver.findElement(By.xpath("//button[contains(.,'Оплатить')]")).getText()
                .replaceAll(removeLetters, "");
        String inputSum = String.format("%.2f", moneyToPhone).replaceAll(",", ".");

        Assertions.assertAll(
                () -> Assertions.assertEquals(phoneNumberInPaymentForm, "375" + phoneNumber),
                () -> Assertions.assertTrue(inputSum.equals(buttonSum) && buttonSum.equals(headerSum))
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}