package ru.geekbrainsQA.Dz6Crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenu extends BaseView{

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navigationMenuItems;

    public void openNavigationMenu(String nameMenuItem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationMenuItems.stream()
                .filter(element -> element.getText().equals(nameMenuItem))
                .findFirst().get()).perform();
    }
}
