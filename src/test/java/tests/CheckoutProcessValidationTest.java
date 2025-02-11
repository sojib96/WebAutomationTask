package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessValidationTest extends BaseTest {

    @Test
    public void test() {
        utils.LoginUtils.login(driver, utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());
        productPage.addProductsToCartOrRemove(1, true);
        productPage.clickCartIcon();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName(utils.SettingsTestData.getCheckoutData().getFirstName());
        checkoutPage.enterLastName(utils.SettingsTestData.getCheckoutData().getLastName());
        checkoutPage.enterPostalCode(utils.SettingsTestData.getCheckoutData().getPostalCode());
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutSummaryPage.getProductsTitle().getFirst(), productPage.getProductsTitle().getFirst(),
                "Product title mismatch: The product in the checkout summary does not match the selected product.");
        checkoutSummaryPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getSuccessMessage(), "Thank you for your order!",
                "Order confirmation failed: The success message is incorrect.");
    }
}
