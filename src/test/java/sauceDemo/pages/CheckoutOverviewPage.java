package sauceDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private final static String pagePath = "checkout-step-two.html";
    Logger logger = LogManager.getLogger();

    @FindBy (css = ".title")
    public WebElement titleOverview;

    @FindBy (id = "finish")
    public WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage goToCheckoutCompletePage() {
        finishButton.click();
        logger.info("Используется класс CheckoutOverviewPage, в котором реализованы паттерны Page Factory и Chain of invocations");
        return new CheckoutCompletePage(driver);
    }

}