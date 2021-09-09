package ru.geekbrainsQA.DZ6Gardenmart;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogSubMenu extends BaseView {

    public CatalogSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Земляника']")
    public WebElement strawberryButton;

    @Step("Клик на иконку земляника")
    public StrawberryPage clickToStrawberryButton() {
        strawberryButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Земляника']")));
        return new StrawberryPage(driver);
    }
}
