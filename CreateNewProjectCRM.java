package ru.geekbrainsQA.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateNewProjectCRM {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCRM();

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

        driver.quit();

    }

    public static void loginToCRM() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
