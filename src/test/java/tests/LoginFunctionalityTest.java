package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionalityTest extends BaseTest {

    @Test
    public void testValidLogin() {
        utils.LoginUtils.login(driver, utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());

        Assert.assertEquals(productPage.getPageTitle(), "Products",
                "Login failed with valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        utils.LoginUtils.login(driver, utils.SettingsTestData.getInvalidUserData().getUsername(),
                utils.SettingsTestData.getInvalidUserData().getPassword());

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message not displayed for invalid login");
    }
}
