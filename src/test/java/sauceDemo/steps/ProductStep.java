package sauceDemo.steps;

import io.cucumber.java.en.Then;
import sauceDemo.baseEntities.BaseCucumberTest;
import sauceDemo.pages.CartPage;
import sauceDemo.pages.CheckoutInformationPage;
import sauceDemo.pages.CheckoutOverviewPage;
import sauceDemo.pages.ProductsPage;

public class ProductStep extends BaseCucumberTest{

    private BaseCucumberTest baseCucumberTest;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    public ProductStep(BaseCucumberTest baseCucumberTest, ProductsPage productsPage, CartPage cartPage, CheckoutInformationPage checkoutInformationPage, CheckoutOverviewPage checkoutOverviewPage) {
        this.baseCucumberTest = baseCucumberTest;
        this.productsPage = productsPage;
        this.cartPage = cartPage;
        this.checkoutInformationPage = checkoutInformationPage;
        this.checkoutOverviewPage = checkoutOverviewPage;
    }

    @Then("добавить товар в корзину")
    public void addItemToCard() {
        if (productsPage.isPageOpened()) {
            productsPage.getAddProductToCartButton().click();
        }
    }

    @Then("открыть корзину")
    public void openCart() {
        if (productsPage.isPageOpened()) {
            productsPage.getCartButton().click();
        }
    }

    @Then("совершить покупку")
    public void checkout() {
        if (cartPage.isPageOpened()) {
            cartPage.getCheckoutButton().click();
        }
    }

    @Then("ввести данные пользователя First name {string}, Last name {string}, Zip code {string}")
    public void inputCheckoutInformation(String firstName, String lastName, String zipCode) {
        if (checkoutInformationPage.isPageOpened()) {
            checkoutInformationPage.getFirstNameInput().sendKeys(firstName);
            checkoutInformationPage.getLastNameInput().sendKeys(lastName);
            checkoutInformationPage.getZipInput().sendKeys(zipCode);
            checkoutInformationPage.getContinueButton().click();
        }
    }

    @Then("завершить покупку")
    public void checkoutFinish() {
        if (checkoutOverviewPage.isPageOpened()) {
            checkoutOverviewPage.getFinishButton().click();
        }
    }
}