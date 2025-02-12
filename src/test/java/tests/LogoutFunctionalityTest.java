package tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutFunctionalityTest extends BaseTest{

    @Test
    public void test() {
        login(utils.SettingsTestData.getValidUserData().getUsername(),
                utils.SettingsTestData.getValidUserData().getPassword());
        productPage.clickHamburgerMenu();
        productPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed: Login page is not displayed.");
    }
}
