package sauceDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sauceDemo.baseEntities.BaseTest;
import sauceDemo.models.User;
import sauceDemo.pages.CheckoutCompletePage;
import sauceDemo.pages.CheckoutOverviewPage;
import sauceDemo.steps.ProductStep;
import sauceDemo.steps.UserStep;

public class successfulTransactionTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        UserStep userStep = new UserStep(driver);
        ProductStep productStep = new ProductStep(driver);
        User user = new User();
        user.setLogin("standard_user");
        user.setPassword("secret_sauce");
        user.setFirstName("Andy");
        user.setLastName("Harrison");
        user.setZipCode("12322");
        //System.out.println(user.toString());
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        userStep.loginSuccessful(user);
        productStep.addItemToCard();
        productStep.openCart();
        productStep.checkout();
        productStep.inputCheckoutInformation(user);
        productStep.checkoutFinish();
        Assert.assertTrue(checkoutCompletePage.titleComplete.isDisplayed());
    }
}