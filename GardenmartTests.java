package ru.geekbrainsQA.DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class GardenmartTests {
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
        loginToGardenmart();
    }

    @Test
    void checkAddingProductToTheCart() throws InterruptedException {
        Thread.sleep(2000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navbar-header nav_category']")));
        driver.findElement(By.id("category")).click();
        driver.findElement(By.xpath("//img[@alt='Земляника']")).click();
        Thread.sleep(2000);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Земклуника Дар']")));
        driver.findElement(By.xpath("//img[@alt='Земклуника Дар']")).click();
        driver.findElement(By.id("button-cart")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-heading']")));
        assertThat(driver.findElement(By.xpath("//div[@class='modal-heading']")), hasText("Товар добавлен в корзину!"));
    }

    @Test
    void checkDeleteProductFromCart() throws InterruptedException {
        Thread.sleep(2000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='shop_cart']")));
        //Не могу понять, почему ожидания не срабатывают в этом месте и в тесте выше, ниже
        driver.findElement(By.xpath("//img[@alt='shop_cart']")).click();
        driver.findElement(By.xpath("//img[@alt='remove_img']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content']")));
        assertThat(driver.findElement(By.xpath("//div[@class='content']")), hasText("Ваша корзина пуста!"));
    }

    @Test
    void checkAddingProductToFavorites() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("category")).click();
        driver.findElement(By.xpath("//img[@alt='Земляника']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@alt='Земклуника Дар']")).click();
        driver.findElement(By.xpath("//button[@class='btn cart-main_wish-btn btn-default']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        assertThat(driver.findElement(By.xpath("//div[@class='alert alert-success']")),
                hasText("Товар Земклуника Дар успешно добавлен в избранное!"));
        //тут должен быть текст "Товар Земклуника Дар успешно добавлен в избранное!\n×", не разобралась как заэкранить часть после "!"
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

    public static void loginToGardenmart(){
        driver.get("https://gardenmart24.ru/");
        driver.findElement(By.xpath("//span[contains(text(), 'Авторизация')]")).click();
        driver.findElement(By.xpath("//div[@class='auth-popup_error authorization-popup_error-email']/..//input"))
                .sendKeys("balabol@mail.ru");
        driver.findElement(By.id("authorization-password")).sendKeys("balabol");
        driver.findElement(By.xpath("//span[contains(text(), 'Войти')]")).click();
    }
}
