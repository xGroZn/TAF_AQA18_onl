package sauceDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final static String pagePath = "checkout-complete.html";
    Logger logger = LogManager.getLogger();

    @FindBy (css = ".title")
    public WebElement titleComplete;

    @FindBy (id = "back-to-products")
    public WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        logger.info("Используется класс CheckoutCompletePage, в котором реализован паттерн Page Factory");
    }

}