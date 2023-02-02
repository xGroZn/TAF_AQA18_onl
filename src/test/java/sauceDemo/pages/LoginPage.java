package sauceDemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class LoginPage extends BasePage {
    Logger logger = LogManager.getLogger();

    @FindBy (id = "user-name")
    public WebElement loginInput;

    @FindBy (id = "password")
    public WebElement passwordInput;

    @FindBy (id = "login-button")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage goToProductsPage() {
        loginButton.click();
        logger.info("Используется класс LoginPage, в котором реализованы паттерны Page Factory и Chain of invocations");
        return new ProductsPage(driver);
    }
}