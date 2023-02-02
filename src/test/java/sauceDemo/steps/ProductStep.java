package sauceDemo.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import sauceDemo.baseEntities.BaseStep;
import sauceDemo.models.User;
import sauceDemo.pages.CartPage;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.CheckoutOverviewPage;
import sauceDemo.pages.ProductsPage;

public class ProductStep extends BaseStep {
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    Logger logger = LogManager.getLogger();

    public ProductStep(WebDriver driver) {
        super(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    public void addItemToCard() {
        if (productsPage.titleProducts.isDisplayed()) {
            productsPage.addProductToCartButton.click();
        }
    }

    public void openCart() {
        if (productsPage.titleProducts.isDisplayed()) {
            productsPage.goToCartPage();
        }
    }

    public void checkout() {
        if (cartPage.titleYourCart.isDisplayed()) {
            cartPage.goToCheckoutInformationPage();
        }
    }

    public void inputCheckoutInformation(User user) {
        if (checkoutInformationPage.titleYourInformation.isDisplayed()) {
            checkoutInformationPage.firstNameInput.sendKeys(user.getFirstName());
            checkoutInformationPage.lastNameInput.sendKeys(user.getLastName());
            checkoutInformationPage.zipInput.sendKeys(user.getZipCode());
            logger.info("В данном степе используется объект User, который содержит следующие значения: " +
                    "First name - " + user.getFirstName().toString() +
                    ", Last name - " + user.getLastName().toString() +
                    ", ZIP code - " + user.getZipCode().toString());
            checkoutInformationPage.goToCheckoutOverviewPage();
        }
    }

    public void checkoutFinish() {
        if (checkoutOverviewPage.titleOverview.isDisplayed()) {
            checkoutOverviewPage.goToCheckoutCompletePage();
        }
    }
}