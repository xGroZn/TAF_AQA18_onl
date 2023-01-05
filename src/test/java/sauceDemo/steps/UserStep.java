package sauceDemo.steps;

import org.openqa.selenium.WebDriver;
import sauceDemo.baseEntities.BaseStep;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.LoginPage;

public class UserStep extends BaseStep {

    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void loginSuccessful(String login, String password) {
        if (loginPage.isPageOpened()) {
            loginPage.getLoginInput().sendKeys(login);
            loginPage.getPasswordInput().sendKeys(password);
            loginPage.getLoginButton().click();
        }
    }
}