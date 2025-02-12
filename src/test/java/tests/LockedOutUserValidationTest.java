package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LockedOutUserValidationTest extends BaseTest {

    @Test
    public void test() {
        login(utils.SettingsTestData.getLockedUserData().getUsername(),
                utils.SettingsTestData.getLockedUserData().getPassword());
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out."),
                "Error message mismatch: Expected message not found in actual error message.");
    }
}
