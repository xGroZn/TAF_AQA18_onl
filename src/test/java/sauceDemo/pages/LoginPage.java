package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sauceDemo.baseEntities.BasePage;

public class LoginPage extends BasePage {

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
        return new ProductsPage(driver);
    }
}