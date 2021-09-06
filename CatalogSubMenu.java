package ru.geekbrainsQA.DZ6Gardenmart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogSubMenu extends BaseView{

    public CatalogSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Земляника']")
    public WebElement strawberryButton;

    public StrawberryPage clickToStrawberryButton() throws InterruptedException {
        strawberryButton.click();
        Thread.sleep(2000);
        return new StrawberryPage(driver);
    }
}
