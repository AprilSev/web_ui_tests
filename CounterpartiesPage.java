package ru.geekbrainsQA.Dz6Crm;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartiesPage extends BaseView {

    public CounterpartiesPage(WebDriver driver) {
        super(driver);
    }

    public static final String createNewContactPersonXpathLocator = "//a[text()='Создать контактное лицо']";

    @FindBy(xpath = createNewContactPersonXpathLocator)
    public WebElement createNewContactPersonButton;

    @Step("Клик на кнопку создать контактное лицо")
    public CreatingNewContactPersonPage createPerson() {
        createNewContactPersonButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(CreatingNewContactPersonPage.saveAndCloseButtonXpathLocator)));
        return new CreatingNewContactPersonPage(driver);
    }

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement requestContactPersonSavedElement;

}
