package ru.geekbrainsQA.Dz6Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartiesSubMenu extends BaseView{

    public CounterpartiesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement counterpartiesMenuItem;

    public CounterpartiesPage goToCounterpartiesPage() {
        counterpartiesMenuItem.click();
        webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated
                        (By.xpath(CounterpartiesPage.createNewContactPersonXpathLocator)));
        return new CounterpartiesPage(driver);
    }

}
