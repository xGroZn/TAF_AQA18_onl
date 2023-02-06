package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BaseCucumberTest;

public class CartPage extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private final static String pagePath = "cart.html";
    private final By titleYourCartLocator = By.cssSelector(".title");
    private final By checkoutButtonLocator = By.id("checkout");

    public CartPage(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    protected By getPageIdentifier() {
        return titleYourCartLocator;
    }

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getCheckoutButton () {
        return driver.findElement(checkoutButtonLocator);
    }
}