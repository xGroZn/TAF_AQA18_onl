package sauceDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";
    Logger logger = LogManager.getLogger();
    @FindBy (css = ".title")
    public WebElement titleYourCart;

    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage goToCheckoutInformationPage() {
        checkoutButton.click();
        logger.info("Используется класс CartPage, в котором реализованы паттерны Page Factory и Chain of invocations");
        return new CheckoutInformationPage(driver);
    }
}