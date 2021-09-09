package ru.geekbrainsQA.DZ6Gardenmart;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BaseView {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='auth-popup_error authorization-popup_error-email']/..//input")
    public WebElement emailInput;

    @Step("Заполнить поле email")
    public AuthorizationPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @FindBy(id = "authorization-password")
    public WebElement passwordInput;

    @Step("Заполнить поле пароль")
    public AuthorizationPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//span[contains(text(), 'Войти')]")
    public WebElement enterButton;

    @Step("Клик на кнопку войти")
    public void clickToEnterButton() {
        enterButton.click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("author_popup")));
    }
}
