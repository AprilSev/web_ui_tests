package ru.geekbrainsQA.DZ6GardenmartTest;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.geekbrainsQA.DZ6Gardenmart.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenmartTest extends BaseTest {

    @Test
    @Description("Тест логина и добавления товара в корзину")
    void checkAddingProductToTheCart() {
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
    @Description("Тест логина и удаления товара из корзины")
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
    @Description("Тест логина и добавления товара в избранное")
    void checkAddingProductToFavorites() {
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
