package ru.geekbrainsQA.DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class CRMTests {
    static WebDriver driver;
    static WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCRM();
    }

    @Test
    void chekCreateNewProject() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[@class='btn back icons-holder-text ']")));
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_project[name]']")));
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("test");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organization = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organization.get(0).click();

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select projectManagerSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectManagerSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> contacts = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        contacts.get(0).click();

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        assertThat(driver.findElement(By.id("flash-messages")), hasText("Проект сохранен"));

    }

    @Test
    void chekCreateNewPerson() {
        Actions actions = new Actions(driver);
        WebElement counterpartiesMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(counterpartiesMenuElement).perform();

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Balabolov");

        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Balabol");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input']")));
        driver.findElement(By.xpath("//input[@class='select2-input']")).sendKeys("1");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@Class='select2-result-label']")));
        driver.findElement(By.xpath("//input[contains(@Class,'select2-input')]")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Senior Balabol");

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        assertThat(driver.findElement(By.id("flash-messages")), hasText("Контактное лицо сохранено"));
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    public static void loginToCRM() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
