package sauceDemo.steps;

import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import sauceDemo.baseEntities.BaseCucumberTest;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initScenario(Scenario scenario) {
        System.out.println("HOOK: Start browser...");
        baseCucumberTest.driver = new BrowserFactory().getDriver();
    }

    @Given("страница логина открыта")
    public void openLoginPage() {
        baseCucumberTest.driver.get(ReadProperties.getUrl());
    }

    @After
    public void completeScenario(Scenario scenario) {
        if (baseCucumberTest.driver != null) {
            baseCucumberTest.driver.quit();
        }
    }
}