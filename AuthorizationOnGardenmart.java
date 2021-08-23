package ru.geekbrainsQA.DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationOnGardenmart {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://gardenmart24.ru/");

        driver.findElement(By.xpath("//span[contains(text(), 'Авторизация')]")).click();

        driver.findElement(By.xpath("//div[@class='auth-popup_error authorization-popup_error-email']/..//input"))
                .sendKeys("balabol@mail.ru");

        driver.findElement(By.id("authorization-password")).sendKeys("balabol");

        driver.findElement(By.xpath("//span[contains(text(), 'Войти')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
