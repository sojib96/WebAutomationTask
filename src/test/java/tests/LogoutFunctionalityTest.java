package tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutFunctionalityTest extends BaseTest{

    @Test
    public void test() {
        utils.LoginUtils.login(driver, utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());

        productPage.clickHamburgerMenu();
        productPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),
                "Logout failed: Login button is not displayed.");
    }
}
