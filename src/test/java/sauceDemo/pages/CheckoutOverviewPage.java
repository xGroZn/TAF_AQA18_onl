package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private final static String pagePath = "checkout-step-two.html";

    @FindBy (css = ".title")
    public WebElement titleOverview;

    @FindBy (id = "finish")
    public WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage goToCheckoutCompletePage() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

}