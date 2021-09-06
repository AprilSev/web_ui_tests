package ru.geekbrainsQA.Dz6Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    public LoginPage fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    public LoginPage clickInLoginButton() {
        loginButton.click();
        return this;
    }
}
