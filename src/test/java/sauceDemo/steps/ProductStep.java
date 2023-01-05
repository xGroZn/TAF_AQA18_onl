package sauceDemo.steps;

import org.openqa.selenium.WebDriver;
import sauceDemo.baseEntities.BaseStep;
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
        if (productsPage.isPageOpened()) {
            productsPage.getAddProductToCartButton().click();
        }
    }

    public void openCart() {
        if (productsPage.isPageOpened()) {
            productsPage.getCartButton().click();
        }
    }

    public void checkout() {
        if (cartPage.isPageOpened()) {
            cartPage.getCheckoutButton().click();
        }
    }

    public void inputCheckoutInformation(String firstName, String lastName, String zipCode) {
        if (checkoutInformationPage.isPageOpened()) {
            checkoutInformationPage.getFirstNameInput().sendKeys(firstName);
            checkoutInformationPage.getLastNameInput().sendKeys(lastName);
            checkoutInformationPage.getZipInput().sendKeys(zipCode);
            checkoutInformationPage.getContinueButton().click();
        }
    }

    public void checkoutFinish() {
        if (checkoutOverviewPage.isPageOpened()) {
            checkoutOverviewPage.getFinishButton().click();
        }
    }
}