package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final static String pagePath = "checkout-complete.html";
    private final By titleCompleteLocator = By.cssSelector(".title");
    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return titleCompleteLocator;
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }
}