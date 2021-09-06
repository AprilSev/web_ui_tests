package ru.geekbrainsQA.DZ6Gardenmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BaseView{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public static final String yourShoppingCartEmptyXpathLocator = "//div[@class='content']";

    @FindBy(xpath = "//img[@alt='remove_img']")
    public WebElement removeButton;

    public void clickToRemoveButton(){
        removeButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(yourShoppingCartEmptyXpathLocator)));
    }

    @FindBy(xpath = yourShoppingCartEmptyXpathLocator)
    public WebElement yourShoppingCartEmpty;
}
