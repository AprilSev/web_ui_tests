package ru.geekbrainsQA.DZ6GardenmartTest;

import org.junit.jupiter.api.Test;
import ru.geekbrainsQA.DZ6Gardenmart.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenmartTest extends BaseTest{

    @Test
    void checkAddingProductToTheCart() throws InterruptedException {
        driver.get("https://gardenmart24.ru/");
        new MainPage(driver).clickToAuthorizationButton();

        new AuthorizationPage(driver)
                .fillEmail("balabol@mail.ru")
                .fillPassword("balabol")
                .clickToEnterButton();

        new MainPage(driver).clickToCatalogButton();

        new CatalogSubMenu(driver).clickToStrawberryButton();

        new StrawberryPage(driver).clickToProductItemStrawberryGift();

        new ProductItemStrawberryGiftPage(driver).clickToAddToCartButton();

        assertThat(new AddToCartPage(driver).productAddedToCart.isDisplayed());
    }

    @Test
    void checkDeleteProductFromCart() {
        driver.get("https://gardenmart24.ru/");
        new MainPage(driver).clickToAuthorizationButton();

        new AuthorizationPage(driver)
                .fillEmail("balabol@mail.ru")
                .fillPassword("balabol")
                .clickToEnterButton();

        new MainPage(driver).clickToShopCartButton();

        new CheckoutPage(driver).clickToRemoveButton();

        assertThat(new CheckoutPage(driver).yourShoppingCartEmpty.isDisplayed());
    }

    @Test
    void checkAddingProductToFavorites() throws InterruptedException {
        driver.get("https://gardenmart24.ru/");
        new MainPage(driver).clickToAuthorizationButton();

        new AuthorizationPage(driver)
                .fillEmail("balabol@mail.ru")
                .fillPassword("balabol")
                .clickToEnterButton();

        new MainPage(driver).clickToCatalogButton();

        new CatalogSubMenu(driver).clickToStrawberryButton();

        new StrawberryPage(driver).clickToProductItemStrawberryGift();

        new ProductItemStrawberryGiftPage(driver).clickToAddToFavoriteButton();

        assertThat(new ProductItemStrawberryGiftPage(driver).productSuccessfullyAddedToFavorites.isDisplayed());
        
    }


}
