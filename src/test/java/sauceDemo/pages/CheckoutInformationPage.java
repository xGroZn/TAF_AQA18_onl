package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutInformationPage {
    private final static String pagePath = "checkout-step-one.html";
    public SelenideElement titleYourInformation = $(".title");
    public SelenideElement firstNameInput = $(By.id("first-name"));
    public SelenideElement lastNameInput = $(By.id("last-name"));
    public SelenideElement zipInput = $(By.id("postal-code"));
    public SelenideElement continueButton = $(By.id("continue"));

    public CheckoutOverviewPage goToCheckoutOverviewPage() {
        continueButton.click();
        return new CheckoutOverviewPage();
    }
}