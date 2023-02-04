package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {

    private final static String pagePath = "checkout-complete.html";
    public SelenideElement titleComplete = $(".title");

    public SelenideElement backHomeButton = $(By.id("back-to-products"));
}