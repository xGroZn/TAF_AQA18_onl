package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    LoginPage loginPage;

    public UserStep(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getInput().click();

    }

    public DashboardPage loginSuccessful(String email, String psw) {
        login(email, psw);
        return new DashboardPage(driver);
    }
    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);
        return loginPage;
    }
}