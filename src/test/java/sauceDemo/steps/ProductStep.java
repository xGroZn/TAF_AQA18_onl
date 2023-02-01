package sauceDemo.steps;

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
            checkoutInformationPage.goToCheckoutOverviewPage();
        }
    }

    public void checkoutFinish() {
        if (checkoutOverviewPage.titleOverview.isDisplayed()) {
            checkoutOverviewPage.goToCheckoutCompletePage();
        }
    }
}