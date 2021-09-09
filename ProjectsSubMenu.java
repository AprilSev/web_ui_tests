package ru.geekbrainsQA.Dz6Crm;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsSubMenu extends BaseView {

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@data-route='crm_project_my']/a")
    public WebElement projectsSubMenuItem;

    @Step("Переход на страницу проекты")
    public ProjectsPage goToProjectPage() {
        projectsSubMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(ProjectsPage.createNewProjectButtonXpathLocator)));
        return new ProjectsPage(driver);
    }
}
