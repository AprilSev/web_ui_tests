package ru.geekbrainsQA.DZ6Gardenmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductItemStrawberryGiftPage extends BaseView{

    public ProductItemStrawberryGiftPage(WebDriver driver) {
        super(driver);
    }

    public static final String productSuccessfullyAddedToFavoritesXpathLocator = "//div[@class='alert alert-success']";

    @FindBy(id = "button-cart")
    public WebElement addToCartButton;

    public AddToCartPage clickToAddToCartButton(){
        addToCartButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-heading']")));
        return new AddToCartPage(driver);
    }

    @FindBy(xpath = "//button[@class='btn cart-main_wish-btn btn-default']")
    public WebElement addToFavoriteButton;

    public void clickToAddToFavoriteButton(){
        addToFavoriteButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productSuccessfullyAddedToFavoritesXpathLocator)));
    }

    @FindBy(xpath = productSuccessfullyAddedToFavoritesXpathLocator)
    public WebElement productSuccessfullyAddedToFavorites;
}
