package sauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sauceDemo.baseEntities.BaseCucumberTest;

public class LoginPage extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private final By loginInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    public LoginPage(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public WebElement getLoginInput() {
        return driver.findElement(loginInputLocator);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(passwordInputLocator);
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }
}