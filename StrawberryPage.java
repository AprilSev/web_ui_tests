package ru.geekbrainsQA.DZ6Gardenmart;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StrawberryPage extends BaseView {

    public StrawberryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Земклуника Дар']")
    public WebElement productItemStrawberryGift;

    @Step("Клик на  иконку земклуника дар")
    public ProductItemStrawberryGiftPage clickToProductItemStrawberryGift() {
        productItemStrawberryGift.click();
        return new ProductItemStrawberryGiftPage(driver);
    }
}
