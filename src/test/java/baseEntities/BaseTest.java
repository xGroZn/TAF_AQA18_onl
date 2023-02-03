package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = true; //для быстрого заполнения форм, значений
        //Configuration.assertionMode = AssertionMode.SOFT; //для мягкого прохождения тестов, тесты продолжаются, даже если первый тест упал
        //Configuration.headless = true; //для запуска браузера в тихом режиме
        //Configuration.reportsFolder = "target/"; //для junit тестов

    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}