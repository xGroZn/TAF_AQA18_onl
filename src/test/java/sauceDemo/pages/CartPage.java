package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final static String pagePath = "cart.html";

    public SelenideElement titleYourCart = $(".title");
    public SelenideElement checkoutButton = $(By.id("checkout"));

    public CheckoutInformationPage goToCheckoutInformationPage() {
        checkoutButton.click();
        return new CheckoutInformationPage();
    }
}