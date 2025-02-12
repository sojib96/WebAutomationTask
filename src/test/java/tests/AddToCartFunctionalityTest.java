package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartFunctionalityTest extends BaseTest {

    @Test
    public void test() {
        int addToCartCount = 2;
        login(utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());

        // EDGE CASE START
        productPage.addProductsToCartOrRemove(addToCartCount, true); //Adding cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), String.valueOf(addToCartCount),
                "Cart badge count mismatch: Expected and actual values do not match.");
        productPage.addProductsToCartOrRemove(addToCartCount, false);  //Removing cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), "",
                "Cart badge count mismatch: Expected and actual values do not match.");
        productPage.addProductsToCartOrRemove(addToCartCount, true); //Adding cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), String.valueOf(addToCartCount),
                "Cart badge count mismatch: Expected and actual values do not match.");
        productPage.addProductsToCartOrRemove(addToCartCount, false);  //Removing cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), "",
                "Cart badge count mismatch: Expected and actual values do not match.");
        // EDGE CASE FINISH

        productPage.addProductsToCartOrRemove(addToCartCount, true);
        productPage.clickCartIcon();
        for (int i = 0; i < addToCartCount; i++) {
            Assert.assertEquals(cartPage.getProductsTitle().get(i), productPage.getProductsTitle().get(i), "Product tile in the cart page does not match.");
        }
    }
}
