package ru.geekbrainsQA.Dz6Crm;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BaseView {

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public static final String createNewProjectButtonXpathLocator = "//a[@class='btn back icons-holder-text ']";

    @FindBy(xpath = createNewProjectButtonXpathLocator)
    public WebElement createNewProjectButton;

    @Step("Клик по кнопке создать проект")
    public CreatingNewProjectPage createProject() {
        createNewProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(CreatingNewProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreatingNewProjectPage(driver);
    }

    @FindBy(xpath = "//*[text()='Проект сохранен']")
    public WebElement requestProjectSavedElement;

}
