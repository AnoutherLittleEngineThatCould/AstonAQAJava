package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BaseView {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'list-item__wrap')]")
    public List<WebElement> basketItemsList;

    @FindBy(xpath = "//p[contains(@class, 'total line')]/span[2]")
    public WebElement productInBasketCoast;


    //Список продуктов в виде "Название", "Цена"
    List<List<String>> inBasketProduct;

    List<Integer> productPriceWithDiscountInBasket;

    //Наполняю inBasketProduct значениями из List<WebElement> basketItemsList
    // Если делать без метода, то работет плохо
    public void initInBasketProduct() {
        inBasketProduct =
                basketItemsList.stream().map(b -> Arrays.asList(b.findElement(By.xpath("div/div/a/span")).getText(),
                        b.findElement(By.xpath("div[3]/div[2]")).getText())).collect(Collectors.toList());
        productPriceWithDiscountInBasket = basketItemsList.stream()
                .map(o -> Integer.valueOf(o.findElement(By.xpath("div[contains(@class, 'price')]/div[1]"))
                        .getText().replaceAll("\\D", ""))).collect(Collectors.toList());
    }
}
