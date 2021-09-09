package ru.geekbrainsQA.Dz6Crm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @Step("Заполнить поле логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @Step("Заполнить поле пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @Step("Клик на кнопку логина")
    public LoginPage clickInLoginButton() {
        loginButton.click();
        return this;
    }
}
