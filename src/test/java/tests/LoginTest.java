package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
//import io.qameta.allure.*;
import elements.Checkbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import steps.NavigationSteps;
import steps.ProjectSteps;

public class LoginTest extends BaseTest {

    //@Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test (description = "Description")
//    @TmsLink("TC-001")
//    @Description("Description1")
//    @Link("https://onliner.by")
//    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
//    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        Assert.assertTrue(
                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.1"
        );
    }

    @Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void checkboxTest() {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        String pagePath = "index.php?/admin/users/overview#";
        driver.get(ReadProperties.getUrl() + pagePath);
        WebElement userCheckbox = driver.findElement(By.xpath("//td//input[@type='checkbox']"));
        Checkbox checkbox = new Checkbox(driver, userCheckbox);
        checkbox.isDisplayed();
        checkbox.isEnabled();
        checkbox.click();
        checkbox.isSelected();
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new AddProjectPage(driver);
        page.openPageByUrl();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }

    @Test
    public void DropDownTest() throws InterruptedException {
        userStep.login(ReadProperties.username(), ReadProperties.password());
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject("Project_1");
        String pagePath = "index.php?/cases/add/3";
        driver.get(ReadProperties.getUrl() + pagePath);
        Thread.sleep(2000);


        WebElement userCheckbox = driver.findElement(By.xpath("//td//input[@type='checkbox']"));
        Checkbox checkbox = new Checkbox(driver, userCheckbox);
        checkbox.isDisplayed();
        checkbox.isEnabled();
        checkbox.click();
        checkbox.isSelected();
    }



}