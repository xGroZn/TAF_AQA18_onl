package sauceDemo.steps;

import sauceDemo.models.User;
import sauceDemo.pages.LoginPage;

public class UserStep {

    private LoginPage loginPage;

    public UserStep() {
        loginPage = new LoginPage();
    }

    public void loginSuccessful(User user) {
        if (loginPage.loginButton.isDisplayed()) {
            loginPage.loginInput.val(user.getLogin());
            loginPage.passwordInput.val(user.getPassword());
            loginPage.goToProductsPage();
        }
    }
}