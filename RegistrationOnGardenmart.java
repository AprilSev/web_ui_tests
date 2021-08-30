package ru.geekbrainsQA.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationOnGardenmart {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://gardenmart24.ru/");

        driver.findElement(By.xpath("//span[contains(text(), 'Авторизация')]")).click();

        driver.findElement(By.xpath("//span[contains(text(), 'Зарегистрироваться')]")).click();

        driver.findElement(By.name("firstname")).sendKeys("Balabol");

        driver.findElement(By.xpath("//div[@class='auth-popup_error registration-popup_error-email']/..//input"))
                .sendKeys("balabol@mail.ru");

        driver.findElement(By.xpath("//div[@class='registration-popup_error registration-popup_error-password']/..//input"))
                .sendKeys("balabol");

        driver.findElement(By.name("confirm")).sendKeys("balabol");

        driver.findElement(By.name("telephone")).sendKeys("+79219712338");

        driver.findElement(By.id("reg")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
