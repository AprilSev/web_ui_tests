package ru.geekbrainsQA.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactPersonCRM {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCRM();

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
        //не хочет вводить "1" в импут, пробовала разные ожидания, в том числе и Thread.sleep(5000), xpath верный
        driver.findElement(By.xpath("//input[@class='select2-input']")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Senior Balabol");

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
