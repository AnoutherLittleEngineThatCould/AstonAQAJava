package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageProducts extends BaseView {

    public MainPageProducts(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-card__wrapper']")
    public List<WebElement> mainPageProductObjects;
}
