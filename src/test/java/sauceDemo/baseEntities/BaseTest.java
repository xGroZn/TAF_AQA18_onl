package sauceDemo.baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 10000;
        //Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void start() {
        Selenide.open(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}