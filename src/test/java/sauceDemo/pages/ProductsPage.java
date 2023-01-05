package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BasePage;

public class ProductsPage extends BasePage {
    private final static String pagePath = "inventory.html";
    private final By titleProductsLocator = By.cssSelector(".title");
    private final By addProductToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButtonLocator = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return titleProductsLocator;
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getAddProductToCartButton() {
        return driver.findElement(addProductToCartButtonLocator);
    }

    public WebElement getCartButton() {
        return driver.findElement(cartButtonLocator);
    }
}