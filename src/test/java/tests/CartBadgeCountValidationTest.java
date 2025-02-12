package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartBadgeCountValidationTest extends BaseTest{

    @Test
    public void test() {
        int addToCartCount = 5;
        int removeFromCartCount = 1;
        login(utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());
        productPage.addProductsToCartOrRemove(addToCartCount, true); //Adding cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), String.valueOf(addToCartCount),
                "Cart badge count mismatch: Expected and actual values do not  match.");
        productPage.addProductsToCartOrRemove(removeFromCartCount, false);  //Removing cart item
        Assert.assertEquals(productPage.getCartBadgeCount(), String.valueOf(addToCartCount-removeFromCartCount),
                "Cart badge count mismatch: Expected and actual values do not match.");
    }
}
