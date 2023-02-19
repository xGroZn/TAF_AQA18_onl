package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
//import io.qameta.allure.*;
import io.qameta.allure.*;
import models.UserGUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test (description = "Description")
    @Issue("AQA18-12")
    @TmsLink("TC-001")
    @Description("Description1")
    @Link("https://onliner.by")
    @Link(name = "catalog", type = "mylink", url = "https://onliner.by")
    @Severity(SeverityLevel.BLOCKER)
    public void loginSuccessfulTest() {
        UserGUI userGUI = new UserGUI.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();

        Assert.assertTrue(
                userStep.loginSuccessful(userGUI)
                .isPageOpened()
        );
    }

    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}