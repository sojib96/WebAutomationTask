package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends BaseTest {

    @Test
    public void testValidLogin() {
        login(utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());
        Assert.assertTrue(productPage.isProductPageDisplayed(), "Login failed with valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        login(utils.SettingsTestData.getInvalidUserData().getUsername(),
                utils.SettingsTestData.getInvalidUserData().getPassword());
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid login");
    }
}
