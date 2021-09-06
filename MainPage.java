package ru.geekbrainsQA.DZ6Gardenmart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Авторизация')]")
    public WebElement authorizationButton;

    public AuthorizationPage clickToAuthorizationButton() {
        authorizationButton.click();
        return new AuthorizationPage(driver);
    }

    @FindBy(id = "category")
    public WebElement catalogButton;

    public CatalogSubMenu clickToCatalogButton(){
        catalogButton.click();
        return new CatalogSubMenu(driver);
    }

    @FindBy(xpath = "//img[@alt='shop_cart']")
    public WebElement shopCartButton;

    public CheckoutPage clickToShopCartButton(){
        shopCartButton.click();
        return new CheckoutPage(driver);
    }
}
