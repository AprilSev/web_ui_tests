package ru.geekbrainsQA.Dz6Crm;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatingNewContactPersonPage extends BaseView {

    public CreatingNewContactPersonPage(WebDriver driver) {
        super(driver);
    }

    public static final String allOrganizationsXpathLocator = "//input[@class='select2-input']";

    @FindBy(name = "crm_contact[lastName]")
    public WebElement inputLastName;

    @Step("Заполнить поле фамилия")
    public CreatingNewContactPersonPage fillInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement inputFirstName;

    @Step("Заполнить поле имя")
    public CreatingNewContactPersonPage fillInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement inputOrganization;

    public static final String saveAndCloseButtonXpathLocator = "//button[@class='btn btn-success action-button']";

    @Step("Клик на селект организация")
    public CreatingNewContactPersonPage clickToOrganization() {
        inputOrganization.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(allOrganizationsXpathLocator)));
        return this;
    }

    @FindBy(xpath = allOrganizationsXpathLocator)
    public WebElement inputAllOrganizations;

    @Step("Заполнить поле организация")
    public CreatingNewContactPersonPage fillInputAllOrganizations(String organization) {
        inputAllOrganizations.sendKeys(organization);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@Class='select2-result-label']")));
        return this;
    }

    @FindBy(xpath = "//input[contains(@Class,'select2-input')]")
    public WebElement fieldAllOrganizations;

    @Step("Ввод энтера в поле организация")
    public CreatingNewContactPersonPage clickToFieldAllOrganization() {
        fieldAllOrganizations.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement inputJobTitle;

    @Step("Заполнить поле должность")
    public CreatingNewContactPersonPage fillInputJobTitle(String jobTitle) {
        inputJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    @Step("Клик на кнопку сохранить и закрыть")
    public void clickToButtonSaveAndClose() {
        saveAndCloseButton.click();
    }
}
