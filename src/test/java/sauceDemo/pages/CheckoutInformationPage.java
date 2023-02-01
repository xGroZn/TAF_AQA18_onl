package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutInformationPage extends BasePage {
    private final static String pagePath = "checkout-step-one.html";

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
        return new CheckoutOverviewPage(driver);
    }
}