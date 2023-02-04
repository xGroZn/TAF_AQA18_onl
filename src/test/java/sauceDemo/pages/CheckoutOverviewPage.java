package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    private final static String pagePath = "checkout-step-two.html";
    public SelenideElement titleOverview = $(".title");
    public SelenideElement finishButton = $(By.id("finish"));

    public CheckoutCompletePage goToCheckoutCompletePage() {
        finishButton.click();
        return new CheckoutCompletePage();
    }

}