package sauceDemo.tests;

import configuration.ReadProperties;
import org.testng.annotations.Test;
import sauceDemo.baseEntities.BaseTest;
import sauceDemo.models.User;
import sauceDemo.pages.CheckoutCompletePage;
import sauceDemo.steps.ProductStep;
import sauceDemo.steps.UserStep;

import static com.codeborne.selenide.Condition.exist;

public class successfulTransactionTest extends BaseTest {

    @Test
    public void loginTest() {
        UserStep userStep = new UserStep();
        ProductStep productStep = new ProductStep();
        User user = new User.Builder()
                .withLogin(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .withFirstName("Andy")
                .withLastName("Harrison")
                .withZipCode("12322")
                .build();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        userStep.loginSuccessful(user);
        productStep.addItemToCard();
        productStep.openCart();
        productStep.checkout();
        productStep.inputCheckoutInformation(user);
        productStep.checkoutFinish();
        checkoutCompletePage.titleComplete
                .should(exist);
    }
}