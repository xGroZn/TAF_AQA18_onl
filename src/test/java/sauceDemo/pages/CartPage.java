package sauceDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";
    @FindBy (css = ".title")
    public WebElement titleYourCart;

    @FindBy (id = "checkout")
    public WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInformationPage goToCheckoutInformationPage() {
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }
}