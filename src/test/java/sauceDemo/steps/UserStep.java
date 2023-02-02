package sauceDemo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import sauceDemo.baseEntities.BaseStep;
import sauceDemo.models.User;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.LoginPage;

public class UserStep extends BaseStep {

    private LoginPage loginPage;
    Logger logger = LogManager.getLogger();

    public UserStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void loginSuccessful(User user) {
        if (loginPage.loginButton.isDisplayed()) {
            loginPage.loginInput.sendKeys(user.getLogin());
            loginPage.passwordInput.sendKeys(user.getPassword());
            logger.info("В данном степе используется объект User, который содержит следующие значения: " +
                    "Login - " + user.getLogin().toString() +
                    ", Password - " + user.getPassword().toString());
            loginPage.goToProductsPage();
        }
    }
}