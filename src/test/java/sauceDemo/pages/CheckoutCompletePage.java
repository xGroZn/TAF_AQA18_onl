package sauceDemo.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BaseCucumberTest;

public class CheckoutCompletePage extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    private final static String pagePath = "checkout-complete.html";
    private final By titleCompleteLocator = By.cssSelector(".title");
    private final By backHomeButtonLocator = By.id("back-to-products");

    public CheckoutCompletePage(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    protected By getPageIdentifier() {
        return titleCompleteLocator;
    }

    //@Override
    @Then("открыта страница успешной покупки")
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButtonLocator);
    }
}