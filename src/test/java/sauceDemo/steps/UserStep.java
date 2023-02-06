package sauceDemo.steps;

import io.cucumber.java.en.Given;
import sauceDemo.baseEntities.BaseCucumberTest;
import sauceDemo.pages.LoginPage;

public class UserStep extends BaseCucumberTest {

    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;

    public UserStep(BaseCucumberTest baseCucumberTest, LoginPage loginPage) {
        this.baseCucumberTest = baseCucumberTest;
        this.loginPage = loginPage;
    }

    @Given("пользователь {string} с паролем {string} вошел в систему")
    public void loginSuccessful(String login, String password) {
        if (loginPage.isPageOpened()) {
            loginPage.getLoginInput().sendKeys(login);
            loginPage.getPasswordInput().sendKeys(password);
            loginPage.getLoginButton().click();
        }
    }
}