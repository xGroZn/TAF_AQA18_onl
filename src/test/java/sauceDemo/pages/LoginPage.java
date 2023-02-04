package sauceDemo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement loginInput = $(By.id("user-name"));
    public SelenideElement passwordInput = $(By.id("password"));
    public SelenideElement loginButton = $(By.id("login-button"));

    public ProductsPage goToProductsPage() {
        loginButton.click();
        return new ProductsPage();
    }
}