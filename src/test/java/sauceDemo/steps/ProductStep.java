package sauceDemo.steps;

import sauceDemo.models.User;
import sauceDemo.pages.CartPage;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.CheckoutOverviewPage;
import sauceDemo.pages.ProductsPage;

public class ProductStep {
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    public ProductStep() {
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutInformationPage = new CheckoutInformationPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
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
            checkoutInformationPage.firstNameInput.val(user.getFirstName());
            checkoutInformationPage.lastNameInput.val(user.getLastName());
            checkoutInformationPage.zipInput.val(user.getZipCode());
            checkoutInformationPage.goToCheckoutOverviewPage();
        }
    }

    public void checkoutFinish() {
        if (checkoutOverviewPage.titleOverview.isDisplayed()) {
            checkoutOverviewPage.goToCheckoutCompletePage();
        }
    }
}