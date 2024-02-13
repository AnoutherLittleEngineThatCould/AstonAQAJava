package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductToBasketTest extends BaseTest{

    @Test
    @DisplayName("Total sum in Basket Test")
    void clickBasketButtonTest(){
        mainPage.fillBasket();
        basketPage = mainPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        basketPage.initInBasketProduct();
        Assertions.assertEquals(Integer
                        .valueOf(basketPage.productInBasketCoast.getText().replaceAll("\\D", "")),
                basketPage.productPriceWithDiscountInBasket.stream().mapToInt(o -> o).sum());
    }

}
