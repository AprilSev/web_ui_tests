package ru.geekbrainsQA.Dz6Crm.CrmTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrainsQA.Dz6Crm.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CRMTest extends BaseTest {

    @Test
    @Description("Тест логина и создания нового контактного лица")
    void chekCreateNewPerson() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickInLoginButton();

        new MainPage(driver).navigationMenu.openNavigationMenu("Контрагенты");

        new CounterpartiesSubMenu(driver).goToCounterpartiesPage();

        new CounterpartiesPage(driver).createPerson();

        new CreatingNewContactPersonPage(driver)
                .fillInputLastName("Balabolov")
                .fillInputFirstName("Balabol")
                .clickToOrganization()
                .fillInputAllOrganizations("1")
                .clickToFieldAllOrganization()
                .fillInputJobTitle("Senior Balabol")
                .clickToButtonSaveAndClose();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CounterpartiesPage(driver).requestContactPersonSavedElement.isDisplayed());
    }

    @Test
    @Description("Тест логина и создания нового проекта")
    void chekCreateNewProject() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickInLoginButton();

        new MainPage(driver).navigationMenu.openNavigationMenu("Проекты");

        new ProjectsSubMenu(driver).goToProjectPage();

        new ProjectsPage(driver).createProject();

        new CreatingNewProjectPage(driver)
                .fillInputProjectName("Balabol")
                .clickToSpecifyOrganization()
                .fillSpecifyOrganization("1")
                .selectOrganization()
                .selectBusinessUnit("Research & Development")
                .selectProjectCurator("Applanatest Applanatest Applanatest")
                .selectProjectManager("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .clickToContactPerson()
                .inputContactPerson("1")
                .selectContactPerson()
                .clickToSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new ProjectsPage(driver).requestProjectSavedElement.isDisplayed());
    }

}
