package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class ProductsPage extends BasePage {
    private final static String pagePath = "inventory.html";

    @FindBy (css = ".title")
    public WebElement titleProducts;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement addProductToCartButton;

    @FindBy (css = ".shopping_cart_link")
    public WebElement cartButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

}