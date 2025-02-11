package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@UtilityClass
public class LoginUtils {

    public void login(WebDriver driver, String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
