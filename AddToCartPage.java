package ru.geekbrainsQA.DZ6Gardenmart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BaseView{

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='modal-heading']")
    public WebElement productAddedToCart;
}
