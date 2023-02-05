package stepDefs;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class FirstStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("открыт браузер")
    public void startBrowser() {
        driver = new BrowserFactory().getDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("страница логина открыта")
    @Given("дубликат шага")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());
    }

    @Then("поле username отображается")
    public void isUsernameDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @Then("поле password отображается")
    public void isPasswordDisplayed() {
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
    }

    @But("ошибка не отображается")
    public void isErrorDisplayed() {
        Assert.assertFalse(loginPage.getErrorTextElement().isDisplayed());
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        UserStep userStep = new UserStep(driver);
        dashboardPage = userStep.loginSuccessful(username, password);
    }

    @Then("title is {string}")
    public void titleIs(String value) {
        Assert.assertEquals(value, dashboardPage.getTtile());
    }

    @And("project id is {int}")
    public void projectIdIs(int value) {
        Assert.assertEquals(value, 123);
    }

}