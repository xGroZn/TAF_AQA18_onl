package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final static String pagePath = "checkout-complete.html";

    @FindBy (css = ".title")
    public WebElement titleComplete;

    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

}