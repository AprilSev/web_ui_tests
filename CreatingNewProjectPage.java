package ru.geekbrainsQA.Dz6Crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreatingNewProjectPage extends BaseView{

    public CreatingNewProjectPage(WebDriver driver) {
        super(driver);
    }

    public static final String saveAndCloseButtonXpathLocator = "//button[@class='btn btn-success action-button']";

    public static final String contactPersonInputXpathLocator = "//div[@id='select2-drop']//input";

    public static final String contactPersonItemsXpathLocator = "//div[@class='select2-result-label']";

    @FindBy(xpath = "//input[@name='crm_project[name]']")
    public WebElement inputProjectName;

    public CreatingNewProjectPage fillInputProjectName(String name) {
        inputProjectName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyTheOrganizationElement;

    public CreatingNewProjectPage clickToSpecifyOrganization() {
        specifyTheOrganizationElement.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputSpecifyOrganization;

    public CreatingNewProjectPage fillSpecifyOrganization(String organization) {
        inputSpecifyOrganization.sendKeys();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-result-label']")
    public List<WebElement> organizationItem;

    public CreatingNewProjectPage selectOrganization(){
        organizationItem.get(0).click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public CreatingNewProjectPage selectBusinessUnit(String businessUnit){
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement projectCuratorSelect;

    public CreatingNewProjectPage selectProjectCurator(String projectCurator){
        new Select(projectCuratorSelect).selectByVisibleText(projectCurator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectManagerSelect;

    public CreatingNewProjectPage selectProjectManager(String projectManager){
        new Select(projectManagerSelect).selectByVisibleText(projectManager);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement administratorSelect;

    public CreatingNewProjectPage selectAdministrator(String administrator) throws InterruptedException {
        new Select(administratorSelect).selectByVisibleText(administrator);
        Thread.sleep(3000);
        return this;
    }

    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")
    public WebElement contactPersonElement;

    public CreatingNewProjectPage clickToContactPerson(){
        contactPersonElement.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(CreatingNewProjectPage.contactPersonInputXpathLocator)));
        return this;
    }

    @FindBy(xpath = contactPersonInputXpathLocator)
    public WebElement contactPersonInput;

    public CreatingNewProjectPage inputContactPerson(String contactPerson){
        contactPersonInput.sendKeys(contactPerson);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(CreatingNewProjectPage.contactPersonItemsXpathLocator)));
        return this;
    }

    @FindBy(xpath = contactPersonItemsXpathLocator)
    List<WebElement> contactPersonItems;

    public CreatingNewProjectPage selectContactPerson() {
        contactPersonItems.get(0).click();
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public void clickToSaveAndCloseButton(){
        saveAndCloseButton.click();
    }
}
