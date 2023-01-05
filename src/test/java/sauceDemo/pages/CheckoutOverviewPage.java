package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private final static String pagePath = "checkout-step-two.html";
    private final By titleOverviewLocator = By.cssSelector(".title");
    private final By finishButtonLocator = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return titleOverviewLocator;
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }
}