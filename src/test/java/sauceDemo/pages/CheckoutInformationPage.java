package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BaseCucumberTest;

public class CheckoutInformationPage extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private final static String pagePath = "checkout-step-one.html";
    private final By titleYourInformationLocator = By.cssSelector(".title");
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.id("continue");

    public CheckoutInformationPage(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    protected By getPageIdentifier() {
        return titleYourInformationLocator;
    }

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getZipInput() {
        return driver.findElement(zipInputLocator);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }
}
