package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TitleAndPriceProductTest extends BaseTest {
    @Test
    @DisplayName("Same title product in Main page and Basket")
    void titleAndPriceProductsTest() {
        mainPage.fillBasket();
        basketPage = mainPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        basketPage.initInBasketProduct();
        //Удаляю одинаковые элементы, если после этого лист пустой, значит все продукты из Main page попали в корзину
        for (List<String> list :
                basketPage.inBasketProduct) {
            mainPage.inputProduct.remove(list);
        }
        Assertions.assertTrue(mainPage.inputProduct.isEmpty());

    }

}
