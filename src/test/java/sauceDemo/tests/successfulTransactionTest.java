package sauceDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sauceDemo.baseEntities.BaseTest;
import sauceDemo.pages.CheckoutCompletePage;
import sauceDemo.pages.CheckoutOverviewPage;
import sauceDemo.steps.ProductStep;
import sauceDemo.steps.UserStep;

public class successfulTransactionTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        UserStep userStep = new UserStep(driver);
        ProductStep productStep = new ProductStep(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        userStep.loginSuccessful("standard_user", "secret_sauce");
        productStep.addItemToCard();
        productStep.openCart();
        productStep.checkout();
        productStep.inputCheckoutInformation("Andy", "Harrison", "12322");
        productStep.checkoutFinish();
        Assert.assertTrue(checkoutCompletePage.isPageOpened());
    }
}