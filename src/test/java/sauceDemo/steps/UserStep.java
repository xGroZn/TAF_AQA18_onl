package sauceDemo.steps;

import org.openqa.selenium.WebDriver;
import sauceDemo.baseEntities.BaseStep;
import sauceDemo.models.User;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.LoginPage;

public class UserStep extends BaseStep {

    private LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void loginSuccessful(User user) {
        if (loginPage.loginButton.isDisplayed()) {
            loginPage.loginInput.sendKeys(user.getLogin());
            loginPage.passwordInput.sendKeys(user.getPassword());
            loginPage.goToProductsPage();
        }
    }
}