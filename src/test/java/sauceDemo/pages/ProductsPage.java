package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private final static String pagePath = "inventory.html";
    public SelenideElement titleProducts = $(".title");
    public SelenideElement addProductToCartButton = $(By.id("add-to-cart-sauce-labs-backpack"));
    public SelenideElement cartButton = $(".shopping_cart_link");

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage();
    }

}