package sauceDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutInformationPage extends BasePage {
    private final static String pagePath = "checkout-step-one.html";

    Logger logger = LogManager.getLogger();
    @FindBy (css = ".title")
    public WebElement titleYourInformation;

    @FindBy (id = "first-name")
    public WebElement firstNameInput;

    @FindBy (id = "last-name")
    public WebElement lastNameInput;

    @FindBy (id = "postal-code")
    public WebElement zipInput;

    @FindBy (id = "continue")
    public WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage goToCheckoutOverviewPage() {
        continueButton.click();
        logger.info("Используется класс CheckoutInformationPage, в котором реализованы паттерны Page Factory и Chain of invocations");
        return new CheckoutOverviewPage(driver);
    }
}