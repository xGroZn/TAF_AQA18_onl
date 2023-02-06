package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BaseCucumberTest;

public class CheckoutOverviewPage extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private final static String pagePath = "checkout-step-two.html";
    private final By titleOverviewLocator = By.cssSelector(".title");
    private final By finishButtonLocator = By.id("finish");

    public CheckoutOverviewPage(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    protected By getPageIdentifier() {
        return titleOverviewLocator;
    }

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }
}