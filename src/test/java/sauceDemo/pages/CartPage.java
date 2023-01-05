package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BasePage;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";
    private final By titleYourCartLocator = By.cssSelector(".title");
    private final By checkoutButtonLocator = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return titleYourCartLocator;
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getCheckoutButton () {
        return driver.findElement(checkoutButtonLocator);
    }
}